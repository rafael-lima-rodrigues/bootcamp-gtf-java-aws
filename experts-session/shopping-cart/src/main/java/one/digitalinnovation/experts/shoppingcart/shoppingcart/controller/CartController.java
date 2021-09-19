package one.digitalinnovation.experts.shoppingcart.shoppingcart.controller;

import one.digitalinnovation.experts.shoppingcart.shoppingcart.model.Cart;
import one.digitalinnovation.experts.shoppingcart.shoppingcart.model.Item;
import one.digitalinnovation.experts.shoppingcart.shoppingcart.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(value = "/cart")
public class CartController {

    @Autowired
    private CartRepository cartRepository;

    @RequestMapping(value = "/{id}", method = RequestMethod.POST)
    public Cart addItem(@PathVariable("id") Integer id, @RequestBody Item item){
        Optional<Cart> savedCart = cartRepository.findById(id);
        Cart cart;
        if (savedCart.equals(Optional.empty())){
            cart = new Cart(id);
        } else {
            cart = savedCart.get();
        }

        cart.getItems().add(item);
        return cartRepository.save(cart);
    }

    @GetMapping(value = "/{id}")
    public Optional<Cart> findById(@PathVariable("id") Integer id) {
        return cartRepository.findById(id);
    }

    @DeleteMapping(value = "{/id}")
    public void clear(@PathVariable("id") Integer id){
        cartRepository.deleteById(id);
    }

}
