package sk.stuba.fei.uim.oop.assignment3.web.body;

import lombok.Getter;
import lombok.Setter;
import sk.stuba.fei.uim.oop.assignment3.data.Cart;
import sk.stuba.fei.uim.oop.assignment3.data.Product;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
public class CartResponse {
    private long id;
    private List<ProductResponse> cartList;
    private boolean payed;

    public CartResponse(Cart cart){
        this.id = cart.getId();
        this.payed = cart.isPayed();
        this.cartList = cart.getCartList().stream().map(ProductResponse::new).collect(Collectors.toList());

    }
}
