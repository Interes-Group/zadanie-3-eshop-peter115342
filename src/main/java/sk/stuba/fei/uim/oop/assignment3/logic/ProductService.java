package sk.stuba.fei.uim.oop.assignment3.logic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sk.stuba.fei.uim.oop.assignment3.exception.NotFoundException;
import sk.stuba.fei.uim.oop.assignment3.data.IProductRepository;
import sk.stuba.fei.uim.oop.assignment3.data.Product;
import sk.stuba.fei.uim.oop.assignment3.web.body.ProductRequest;
import sk.stuba.fei.uim.oop.assignment3.web.body.ProductUpdateRequest;

import java.util.List;

@Service
public class ProductService implements IProductService {
    @Autowired
    private IProductRepository repository;
    @Override
    public List<Product> getAll() {
         return  this.repository.findAll();
    }

    @Override
    public Product create(ProductRequest request)  {
        return this.repository.save(new Product(request));
    }

    @Override
    public Product getById(long id) throws NotFoundException {
        Product product = this.repository.findProductById(id);
        if(product == null){
            throw   new NotFoundException();
        }
        return product;
    }

    @Override
    public Product update(long id, ProductUpdateRequest request) throws NotFoundException {
        Product product = this.getById(id);
        if( request.getName() != null){
            product.setName(request.getName());
        }
        if( request.getDescription() != null){
            product.setDescription(request.getDescription());
        }
        this.repository.save(product);
        return  product;
    }

    @Override
    public void delete(long id) throws NotFoundException {
        Product product = this.getById(id);
        this.repository.delete(product);
    }

    @Override
    public int getAmount(long id) throws NotFoundException {
        Product product = this.getById(id);
        return product.getAmount();
    }

    @Override
    public int addAmount(long id, int i) throws NotFoundException {
        Product product = this.getById(id);
        product.setAmount(product.getAmount()+i);
        this.repository.save(product);
        return product.getAmount();
    }


}
