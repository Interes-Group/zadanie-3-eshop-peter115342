package sk.stuba.fei.uim.oop.assignment3.product.data;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;
@Repository
public interface IProductRepository extends JpaRepository<Product,Long> {
    List<Product> findAll();

    Product findProductById(Long id);
}
