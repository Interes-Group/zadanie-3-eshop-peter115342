package sk.stuba.fei.uim.oop.assignment3.web.body;

import lombok.Getter;
import lombok.Setter;
import sk.stuba.fei.uim.oop.assignment3.data.Product;

@Getter
@Setter
public class ProductInCartResponse {
    private Long productId;
    private int amount;

    public ProductInCartResponse(Product product) {
        this.productId = product.getId();
        this.amount = product.getAmountInCart();
    }
}
