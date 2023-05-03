package sk.stuba.fei.uim.oop.assignment3.product.logic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sk.stuba.fei.uim.oop.assignment3.exception.NotFoundException;
import sk.stuba.fei.uim.oop.assignment3.product.data.IProductRepository;
import sk.stuba.fei.uim.oop.assignment3.product.data.Product;
import sk.stuba.fei.uim.oop.assignment3.product.web.bodies.ProductRequest;

import java.util.List;

@Service
public class ProductService implements IProductService {
    @Autowired
    private IProductRepository repository;
    @Override
    public List<Product> getAll() {
        return null;
    }

    @Override
    public Product create(ProductRequest request) throws NotFoundException {
        return null;
    }

    @Override
    public Product getById(long id) throws NotFoundException {
        return null;
    }

    @Override
    public Product update(long id, ProductRequest request) throws NotFoundException {
        return null;
    }

    @Override
    public void delete(long id) throws NotFoundException {

    }

    @Override
    public int getAmount(long id) throws NotFoundException {
        return 0;
    }

    @Override
    public int addAmount(long id, int increment) throws NotFoundException {
        return 0;
    }


}
