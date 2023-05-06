package sk.stuba.fei.uim.oop.assignment3.logic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sk.stuba.fei.uim.oop.assignment3.data.Cart;
import sk.stuba.fei.uim.oop.assignment3.data.ICartRepository;
import sk.stuba.fei.uim.oop.assignment3.data.Product;
import sk.stuba.fei.uim.oop.assignment3.exception.IllegalOperationException;
import sk.stuba.fei.uim.oop.assignment3.exception.NotFoundException;
import sk.stuba.fei.uim.oop.assignment3.web.body.ProductIdentifyRequest;
import sk.stuba.fei.uim.oop.assignment3.web.body.ProductUpdateRequest;

import java.util.List;
@Service
public class CartService implements ICartService {
    @Autowired
    private  ICartRepository repository;
    @Autowired
    private  IProductService service;

    @Override
    public Cart create() {
        return this.repository.save(new Cart());
    }

    @Override
    public List<Cart> getAll() {
        return  this.repository.findAll();
    }

    @Override
    public Cart getById(Long id) throws NotFoundException {
        Cart cart = this.repository.findCartById(id);
        if( cart == null){
            throw  new NotFoundException();
        }
        return cart;
    }

    @Override
    public void delete(long id) throws NotFoundException {
     Cart cart = this.getById(id);
     this.repository.delete(cart);
    }

    @Override
    public Cart addToCart(Long id, ProductIdentifyRequest body) throws NotFoundException, IllegalOperationException {
        Cart cart = this.getById(id);
        Product product = this.service.getById(body.getId());
        if(cart.getShoppingList().contains(product)){
            cart.getShoppingList().add(product);
        }
        else {
            throw  new NotFoundException();
        }
        this.repository.save(cart);
        return cart;
    }

    @Override
    public void payForCart(Long id) throws NotFoundException, IllegalOperationException {
        Cart cart =  this.getById(id);
        if(cart.isPayed()){
            throw  new IllegalOperationException();
        }
        cart.setPayed(true);
        this.repository.save(cart);
    }

}
