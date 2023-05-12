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

    private boolean payed;
    @OneToMany
    private List<Product> shoppingList;

    private double sum;

    public Cart() {
        this.shoppingList = new ArrayList<>();
        payed = false;
        sum = 0;
    }
}
