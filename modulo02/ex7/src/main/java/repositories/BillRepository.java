package repositories;

import entities.Bill;
import entities.Client;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class BillRepository implements Repository<Bill> {
    private List<Bill> bills = new ArrayList<>();

    private static final BillRepository INSTANCE = new BillRepository();

    private BillRepository() {}

    public static BillRepository getInstance() {
        return INSTANCE;
    }

    @Override
    public List<Bill> list() {
        return bills;
    }

    @Override
    public void save(Bill bill) {
        ClientRepository clientRepository = ClientRepository.getInstance();

        Optional<Client> clientAlreadyExists =  clientRepository.findById(bill.getClient().getID());

        if (clientAlreadyExists.isEmpty()) {
            System.out.println("Cliente informado na fatura ainda nao foi cadastrado. Cadastrando...");
            clientRepository.save(bill.getClient());
        }

        bill.setPurchaseTotal(bill.getItems().stream().reduce(BigDecimal.valueOf(0), (acc, item) -> acc.add(item.getUnitPrice().multiply(BigDecimal.valueOf(item.getAmountPurchased()))), BigDecimal::add));

        bills.add(bill);
    }

    @Override
    public Optional<Bill> findById(Long code) {
        Optional<Bill> billFound = bills.stream().filter(bill -> bill.getCode().equals(code)).findAny();

        if (billFound.isPresent()) {
            System.out.println("===== Fatura encontrada =====");
            System.out.println(billFound.get());
        } else {
            System.out.println("Fatura nao encontrada");
        }

        return billFound;
    }

    @Override
    public void showAll() {
        this.bills.forEach(System.out::println);
    }

    @Override
    public void deleteById(Long code) {
        boolean response = bills.removeIf(bill -> bill.getCode().equals(code));

        if (response) {
            System.out.println("Fatura excluida com sucesso");
            return;
        }


        System.out.println("Nao foi possivel encontrar a fatura informado para exclusao");
    }
}
