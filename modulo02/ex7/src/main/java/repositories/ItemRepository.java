package repositories;

import entities.Client;
import entities.Item;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ItemRepository implements Repository<Item> {
    private List<Item> items = new ArrayList<>();

    private static final ItemRepository INSTANCE = new ItemRepository();

    private ItemRepository() {}

    public static ItemRepository getInstance() {
        return INSTANCE;
    }

    @Override
    public List<Item> list() {
        return this.items;
    }

    @Override
    public void save(Item item) {
        this.items.add(item);
    }

    @Override
    public Optional<Item> findById(Long code) {
        Optional<Item> itemFound = this.items.stream().filter(client -> client.getCode().equals(code)).findAny();

        if (itemFound.isPresent()) {
            System.out.println("===== Item encontrado =====");
            System.out.println(itemFound.get());
        } else {
            System.out.println("Item nao encontrado");
        }

        return itemFound;
    }

    @Override
    public void showAll() {
        this.items.forEach(System.out::println);
    }

    @Override
    public void deleteById(Long code) {
        boolean response = this.items.removeIf(item -> item.getCode().equals(code));

        if (response) {
            System.out.println("Item excluido com sucesso");
            return;
        }


        System.out.println("Nao foi possivel encontrar o item informado para exclusao");
    }
}
