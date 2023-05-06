package sk.stuba.fei.uim.oop.assignment3.web.body;

import sk.stuba.fei.uim.oop.assignment3.data.Cart;

public class CartPriceResponse {

    private double price;

    public  CartPriceResponse(Cart cart){
        this.price = cart.getSum();
    }
}
