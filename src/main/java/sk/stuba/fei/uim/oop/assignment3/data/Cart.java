package sk.stuba.fei.uim.oop.assignment3.data;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private  boolean payed;

    private int amount;
    @OneToMany
    private List<Product> cartList;

    public Cart(){
        this.cartList  = new ArrayList<>();
    }
}
