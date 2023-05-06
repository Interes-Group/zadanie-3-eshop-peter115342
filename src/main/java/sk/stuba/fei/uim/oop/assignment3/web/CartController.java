package sk.stuba.fei.uim.oop.assignment3.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sk.stuba.fei.uim.oop.assignment3.exception.IllegalOperationException;
import sk.stuba.fei.uim.oop.assignment3.exception.NotFoundException;
import sk.stuba.fei.uim.oop.assignment3.logic.ICartService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sk.stuba.fei.uim.oop.assignment3.web.body.CartResponse;
import sk.stuba.fei.uim.oop.assignment3.web.body.ProductIdentifyRequest;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/cart")
public class CartController {

    @Autowired
    private ICartService service;

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CartResponse> addList() {
        return new ResponseEntity<>(new CartResponse(this.service.create()), HttpStatus.CREATED);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<CartResponse> getAllLists() {
        return this.service.getAll().stream().map(CartResponse::new).collect(Collectors.toList());
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public CartResponse getList(@PathVariable("id") long listId) throws NotFoundException {
        return new CartResponse(this.service.getById(listId));
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable("id") long listId) throws NotFoundException, IllegalOperationException {
        this.service.delete(listId);
    }

    @PostMapping(value = "/{id}/add", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public CartResponse addToList(@PathVariable("id") Long listId, @RequestBody ProductIdentifyRequest body) throws NotFoundException, IllegalOperationException {
        return new CartResponse(this.service.addToCart(listId, body));
    }

    @GetMapping(value = "/{id}/lend", produces = MediaType.TEXT_PLAIN_VALUE)
    public void lendList(@PathVariable("id") Long id) throws NotFoundException, IllegalOperationException {
        this.service.payForCart(id);
    }


}
