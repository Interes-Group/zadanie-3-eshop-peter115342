package sk.stuba.fei.uim.oop.assignment3.web.body;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ProductUpdateRequest {
    private String name;
    private String description;
    private double price;
}
