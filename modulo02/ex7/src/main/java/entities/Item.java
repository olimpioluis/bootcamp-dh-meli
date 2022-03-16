package entities;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
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
