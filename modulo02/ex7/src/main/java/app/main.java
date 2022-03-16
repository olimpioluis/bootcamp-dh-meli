package app;

import entities.Client;
import repositories.ClientRepository;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ClientRepository clientRepository = new ClientRepository();

        // Criando lista de clientes
        Client client1 = new Client(1L, "Luis", "Olimpio");
        Client client2 = new Client(2L, "Diego", "Fernandes");
        Client client3 = new Client(3L, "Mayk", "Brito");

        clientRepository.save(client1);
        clientRepository.save(client2);
        clientRepository.save(client3);

        clientRepository.showAll();

        clientRepository.deleteById(2L);

        clientRepository.showAll();

        System.out.println("---------------------------------------");
        System.out.print("Digite o id de um cliente para consulta: ");
        Long id = scanner.nextLong();
        clientRepository.findById(id);
    }
}
