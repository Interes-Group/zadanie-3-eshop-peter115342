package sk.stuba.fei.uim.oop.assignment3.web.body;

import lombok.Getter;
import lombok.Setter;
import sk.stuba.fei.uim.oop.assignment3.data.Product;

@Getter
@Setter
public class ProductResponse {
    private final Long id;
    private final String name;

    private final String unit;

    private final String description;

    private final int amount;

    private final double price;

    public ProductResponse(Product product) {
        this.id = product.getId();
        this.name = product.getName();
        this.unit = product.getUnit();
        this.description = product.getDescription();
        this.price = product.getPrice();
        this.amount = product.getAmount();
    }
}
