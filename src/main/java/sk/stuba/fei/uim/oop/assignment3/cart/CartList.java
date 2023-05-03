package sk.stuba.fei.uim.oop.assignment3.cart;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class CartList {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private  boolean payed;

    private int amount;


   // @OneToMany
   // private List<Product> cartList;
}
