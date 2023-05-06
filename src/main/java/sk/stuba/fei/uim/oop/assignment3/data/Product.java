package sk.stuba.fei.uim.oop.assignment3.data;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import sk.stuba.fei.uim.oop.assignment3.web.body.ProductRequest;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
@Getter
@Setter
@NoArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private String unit;

    private String description;

    private int amount;

    private int amountInCart;

    private  double price;
 public Product(ProductRequest request){
     this.name = request.getName();
     this.description = request.getDescription();
     this.amount = request.getAmount();
     this.unit = request.getUnit();
     this.price = request.getPrice();
     this.amountInCart = 0;

 }

}
