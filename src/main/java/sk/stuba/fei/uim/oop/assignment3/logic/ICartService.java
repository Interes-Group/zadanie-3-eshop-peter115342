package sk.stuba.fei.uim.oop.assignment3.logic;

import sk.stuba.fei.uim.oop.assignment3.data.Cart;
import sk.stuba.fei.uim.oop.assignment3.exception.IllegalOperationException;
import sk.stuba.fei.uim.oop.assignment3.exception.NotFoundException;
import sk.stuba.fei.uim.oop.assignment3.web.body.ProductIdentifyRequest;

public interface ICartService {
    Cart create();

    Cart getById(Long id) throws NotFoundException;

    void delete(long id) throws NotFoundException, IllegalOperationException;

    Cart addToCart(Long id, ProductIdentifyRequest body) throws NotFoundException, IllegalOperationException;

    String payForCart(Long id) throws NotFoundException, IllegalOperationException;

}
