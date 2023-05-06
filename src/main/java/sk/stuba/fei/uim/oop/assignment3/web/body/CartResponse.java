package sk.stuba.fei.uim.oop.assignment3.web.body;

import lombok.Getter;
import lombok.Setter;
import sk.stuba.fei.uim.oop.assignment3.data.Cart;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
public class CartResponse {
    private long id;
    private List<ProductInCartResponse> shoppingList;
    private boolean payed;

    public CartResponse(Cart cart){
        this.id = cart.getId();
        this.payed = cart.isPayed();
        this.shoppingList = cart.getShoppingList().stream().map(ProductInCartResponse::new).collect(Collectors.toList());
    }
}