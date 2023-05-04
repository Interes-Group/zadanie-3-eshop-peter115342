package sk.stuba.fei.uim.oop.assignment3.logic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sk.stuba.fei.uim.oop.assignment3.data.Cart;
import sk.stuba.fei.uim.oop.assignment3.data.ICartRepository;
import sk.stuba.fei.uim.oop.assignment3.data.IProductRepository;
import sk.stuba.fei.uim.oop.assignment3.data.Product;
import sk.stuba.fei.uim.oop.assignment3.exception.NotFoundException;
import sk.stuba.fei.uim.oop.assignment3.web.body.ProductIdentifyRequest;
import sk.stuba.fei.uim.oop.assignment3.web.body.ProductRequest;
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
        return null;
    }

    @Override
    public List<Cart> getAll() {
        return null;
    }

    @Override
    public Cart getById(Long id) throws NotFoundException {
        return null;
    }

    @Override
    public Product update(long id, ProductUpdateRequest request) throws NotFoundException {
        return null;
    }

    @Override
    public void delete(long id) throws NotFoundException {

    }

    @Override
    public Cart addToCartList(Long id, ProductIdentifyRequest body) throws NotFoundException {
        return null;
    }

    @Override
    public Cart removeFromCartList(long id, ProductIdentifyRequest body) throws NotFoundException {
        return null;
    }
}
