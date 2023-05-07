package sk.stuba.fei.uim.oop.assignment3.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sk.stuba.fei.uim.oop.assignment3.exception.NotFoundException;
import sk.stuba.fei.uim.oop.assignment3.logic.IProductService;
import sk.stuba.fei.uim.oop.assignment3.web.body.ProductAmount;
import sk.stuba.fei.uim.oop.assignment3.web.body.ProductRequest;
import sk.stuba.fei.uim.oop.assignment3.web.body.ProductResponse;
import sk.stuba.fei.uim.oop.assignment3.web.body.ProductUpdateRequest;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/product")
public class ProductController {
    private final IProductService service;
    @Autowired
    public ProductController(IProductService service){
        this.service = service;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ProductResponse> getAllProducts() {
        return this.service.getAll().stream().map(ProductResponse::new).collect(Collectors.toList());
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ProductResponse> addProduct(@RequestBody ProductRequest body) throws NotFoundException {
        return new ResponseEntity<>(new ProductResponse(this.service.create(body)), HttpStatus.CREATED);
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ProductResponse getProduct(@PathVariable("id") Long id) throws NotFoundException {
        return new ProductResponse(this.service.getById(id));
    }

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ProductResponse updateProduct(@PathVariable("id") Long id, @RequestBody ProductUpdateRequest body) throws NotFoundException {
        return new ProductResponse(this.service.update(id, body));
    }

    @DeleteMapping(value = "/{id}")
    public void deleteProduct(@PathVariable("id") Long id) throws NotFoundException {
        this.service.delete(id);
    }

    @GetMapping(value = "/{id}/amount", produces = MediaType.APPLICATION_JSON_VALUE)
    public ProductAmount getAmount(@PathVariable("id") Long id) throws NotFoundException {
        return new ProductAmount(this.service.getAmount(id));
    }

    @PostMapping(value = "/{id}/amount", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ProductAmount addAmount(@PathVariable("id") Long id, @RequestBody ProductAmount body) throws NotFoundException {
        return new ProductAmount(this.service.addAmount(id, body.getAmount()));
    }


}
