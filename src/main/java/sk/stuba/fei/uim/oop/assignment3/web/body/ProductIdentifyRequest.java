package sk.stuba.fei.uim.oop.assignment3.web.body;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class ProductIdentifyRequest {

    private long productId;

    private int amount;

}
