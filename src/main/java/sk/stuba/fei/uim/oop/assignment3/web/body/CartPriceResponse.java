package sk.stuba.fei.uim.oop.assignment3.web.body;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import sk.stuba.fei.uim.oop.assignment3.data.Cart;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CartPriceResponse {
    double price;

    public CartPriceResponse(Cart cart){
        price = cart.getSum();
    }

}
