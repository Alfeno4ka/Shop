package org.example.service.impl;

import org.example.domain.Cart;
import org.example.domain.Customer;
import org.example.domain.Product;
import org.example.service.CartService;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class CartServiceImpl implements CartService {
    
    private Map<Customer, Cart> carts = new HashMap<>();

    @Override
    public void add(Customer customer, Product product) {
        Cart cart = getCart(customer);
        cart.add(product);
    }

    @Override
    public void edit(Customer customer, Product product, int newQuantity) {
        Cart cart = getCart(customer);
        cart.edit(product, newQuantity);
    }

    @Override
    public void remove(Customer customer, Product product) {
        Cart cart = getCart(customer);
        cart.remove(product);
    }

    @Override
    public Cart getCart(Customer customer) {
        Cart found = carts.get(customer);
        if (Objects.isNull(found)) {
            Cart newCart = new Cart();
            carts.put(customer, newCart);
            return newCart;
        }
        
        return found;
    }
}
