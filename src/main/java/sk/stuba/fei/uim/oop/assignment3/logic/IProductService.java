package sk.stuba.fei.uim.oop.assignment3.logic;

import sk.stuba.fei.uim.oop.assignment3.data.Product;
import sk.stuba.fei.uim.oop.assignment3.exception.NotFoundException;
import sk.stuba.fei.uim.oop.assignment3.web.body.ProductRequest;
import sk.stuba.fei.uim.oop.assignment3.web.body.ProductUpdateRequest;

import java.util.List;

public interface IProductService {
    List<Product> getAll();

    Product create(ProductRequest request) throws NotFoundException;

    Product getById(Long id) throws NotFoundException;

    Product update(Long id, ProductUpdateRequest request) throws NotFoundException;

    void delete(Long id) throws NotFoundException;

    int getAmount(Long id) throws NotFoundException;

    int addAmount(Long id, int i) throws NotFoundException;

}
