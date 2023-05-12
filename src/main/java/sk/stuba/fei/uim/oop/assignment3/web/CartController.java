package sk.stuba.fei.uim.oop.assignment3.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sk.stuba.fei.uim.oop.assignment3.exception.IllegalOperationException;
import sk.stuba.fei.uim.oop.assignment3.exception.NotFoundException;
import sk.stuba.fei.uim.oop.assignment3.logic.ICartService;
import sk.stuba.fei.uim.oop.assignment3.web.body.CartResponse;
import sk.stuba.fei.uim.oop.assignment3.web.body.ProductIdentifyRequest;

@RestController
@RequestMapping("/cart")
public class CartController {
    private final ICartService service;

    @Autowired
    public CartController(ICartService service)
    {
        this.service = service;
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CartResponse> addCart() {
        return new ResponseEntity<>(new CartResponse(this.service.create()), HttpStatus.CREATED);
    }


    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public CartResponse getCart(@PathVariable("id") Long id) throws NotFoundException {
        return new CartResponse(this.service.getById(id));
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable("id") Long id) throws NotFoundException, IllegalOperationException {
        this.service.delete(id);
    }

    @PostMapping(value = "/{id}/add", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public CartResponse addToCart(@PathVariable("id") Long id, @RequestBody ProductIdentifyRequest body) throws NotFoundException, IllegalOperationException {
        return new CartResponse(this.service.addToCart(id, body));
    }

    @GetMapping(value = "/{id}/pay", produces = MediaType.TEXT_PLAIN_VALUE)
    public String payCart(@PathVariable("id") Long id) throws NotFoundException, IllegalOperationException {
        return this.service.payForCart(id);

    }


}
