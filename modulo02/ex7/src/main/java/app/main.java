package app;

import entities.Bill;
import entities.Client;
import entities.Item;
import repositories.BillRepository;
import repositories.ClientRepository;
import repositories.ItemRepository;

import java.math.BigDecimal;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ClientRepository clientRepository = ClientRepository.getInstance();
        ItemRepository itemRepository = ItemRepository.getInstance();
        BillRepository billRepository = BillRepository.getInstance();

        Client client1 = new Client(1L, "Luis", "Olimpio");
        Client client2 = new Client(2L, "Diego", "Fernandes");
        Client client3 = new Client(3L, "Mayk", "Brito");

        clientRepository.save(client1);
        clientRepository.save(client2);
        clientRepository.save(client3);

        System.out.println("---------------------------------------");
        System.out.println("Imprimindo clientes:");
        clientRepository.showAll();

        System.out.println("---------------------------------------");
        System.out.print("Deletando um cliente...");
        clientRepository.deleteById(2L);

        System.out.println("---------------------------------------");
        System.out.print("Digite o id de um cliente para consulta: ");
        Long id = scanner.nextLong();
        clientRepository.findById(id);

        Item item1 = new Item(111L, "TV", 2, BigDecimal.valueOf(1500));
        Item item2 = new Item(222L, "PC", 1, BigDecimal.valueOf(3000));
        Item item3 = new Item(333L, "Notebook", 3, BigDecimal.valueOf(2000));

        itemRepository.save(item1);
        itemRepository.save(item2);
        itemRepository.save(item3);

        Bill bill = new Bill(444L, new Client(5L, "Luis", "Olimpio"), itemRepository.list());
        System.out.println("---------------------------------------");
        System.out.println("Salvando uma nova fatura...");
        billRepository.save(bill);

        System.out.println("---------------------------------------");
        System.out.println("Imprimindo clientes:");
        clientRepository.showAll();
    }
}
