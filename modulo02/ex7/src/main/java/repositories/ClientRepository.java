package repositories;

import entities.Client;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ClientRepository implements Repository<Client> {
    private List<Client> clients;

    public ClientRepository() {
        this.clients = new ArrayList<>();
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
        clients.add(obj);
    }

    @Override
    public Optional<Client> findById(Long id) {
        Optional<Client> clientFound = clients.stream().filter(client -> client.getID().equals(id)).findAny();

        if (clientFound.isPresent()) {
            show(clientFound.get());
        } else {
            System.out.println("Cliente nao encontrado");
        }

        return clientFound;
    }

    public void show(Client client) {
        System.out.println("===== Cliente =====");
        System.out.println(client);
    }

    @Override
    public void deleteById(Long id) {
        boolean response = clients.removeIf(client -> client.getID().equals(id));

        if (response) {
            System.out.println("Cliente excluido com sucesso");
            return;
        }


        System.out.println("Cliente nao encontrado");
    }
}
