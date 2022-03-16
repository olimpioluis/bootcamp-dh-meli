package entities;

import java.math.BigDecimal;
import java.util.List;

public class Bill {
    private Client client;
    private List<Item> items;
    private BigDecimal purchaseTotal;
}
