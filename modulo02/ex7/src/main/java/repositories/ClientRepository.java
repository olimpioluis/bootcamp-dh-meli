package repositories;

import entities.Client;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ClientRepository implements Repository<Client> {
    private List<Client> clients = new ArrayList<>();

    private static final ClientRepository INSTANCE = new ClientRepository();

    private ClientRepository() {}

    public static ClientRepository getInstance() {
        return INSTANCE;
    }

    @Override
    public List<Client> list() {
        return this.clients;
    }

    @Override
    public void showAll() {
        this.clients.forEach(System.out::println);
    }

    @Override
    public void save(Client obj) {
        this.clients.add(obj);
    }

    @Override
    public Optional<Client> findById(Long id) {
        Optional<Client> clientFound = this.clients.stream().filter(client -> client.getID().equals(id)).findAny();

        if (clientFound.isPresent()) {
            System.out.println("===== Cliente encontrado =====");
            System.out.println(clientFound.get());
        } else {
            System.out.println("Cliente nao encontrado");
        }

        return clientFound;
    }

    @Override
    public void deleteById(Long id) {
        boolean response = this.clients.removeIf(client -> client.getID().equals(id));

        if (response) {
            System.out.println("Cliente excluido com sucesso");
            return;
        }


        System.out.println("Nao foi possivel encontrar o cliente informado para exclusao");
    }
}
