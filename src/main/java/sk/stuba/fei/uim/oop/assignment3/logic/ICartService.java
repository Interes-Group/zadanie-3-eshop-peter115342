package sk.stuba.fei.uim.oop.assignment3.logic;

import sk.stuba.fei.uim.oop.assignment3.data.Cart;
import sk.stuba.fei.uim.oop.assignment3.data.Product;
import sk.stuba.fei.uim.oop.assignment3.exception.IllegalOperationException;
import sk.stuba.fei.uim.oop.assignment3.exception.NotFoundException;
import sk.stuba.fei.uim.oop.assignment3.web.body.ProductIdentifyRequest;
import sk.stuba.fei.uim.oop.assignment3.web.body.ProductUpdateRequest;

import java.util.List;

public interface ICartService {
    Cart create();
    List<Cart> getAll();

    Cart getById(Long id) throws NotFoundException;
    void delete(long id) throws NotFoundException, IllegalOperationException;

    Cart addToCart(Long id, ProductIdentifyRequest body) throws NotFoundException, IllegalOperationException;

    void payForCart(Long id) throws NotFoundException, IllegalOperationException;

}
