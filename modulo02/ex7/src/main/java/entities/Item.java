package entities;

import java.math.BigDecimal;

public class Item {
    private Long code;
    private String name;
    private int amountPurchased;
    private BigDecimal unitPrice;

    public Item(Long code, String name, int amountPurchased, BigDecimal unitPrice) {
        this.code = code;
        this.name = name;
        this.amountPurchased = amountPurchased;
        this.unitPrice = unitPrice;
    }
}
