package sk.stuba.fei.uim.oop.assignment3.logic;

import sk.stuba.fei.uim.oop.assignment3.data.Cart;
import sk.stuba.fei.uim.oop.assignment3.data.Product;
import sk.stuba.fei.uim.oop.assignment3.exception.NotFoundException;
import sk.stuba.fei.uim.oop.assignment3.web.body.ProductIdentifyRequest;
import sk.stuba.fei.uim.oop.assignment3.web.body.ProductUpdateRequest;

import java.util.List;

public interface ICartService {
    Cart create();
    List<Cart> getAll();

    Cart getById(Long id) throws NotFoundException;
    Product update(long id, ProductUpdateRequest request) throws NotFoundException;

    void delete(long id) throws NotFoundException;

    Cart addToCartList(Long id, ProductIdentifyRequest body) throws NotFoundException;

    Cart removeFromCartList(long id,ProductIdentifyRequest body) throws  NotFoundException;

}
