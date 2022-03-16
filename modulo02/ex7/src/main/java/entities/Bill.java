package entities;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
public class Bill {
    private Long code;
    private Client client;
    private List<Item> items;
    private BigDecimal purchaseTotal;

    public Bill(Long code, Client client, List<Item> items) {
        this.code = code;
        this.client = client;
        this.items = items;
    }

    @Override
    public String toString() {
        return "Comprador: " + client.getName() + "  " + client.getSurname() + " | " + " | " + "Valor total: " + purchaseTotal;
    }
}
