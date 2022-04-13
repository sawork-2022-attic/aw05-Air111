package com.micropos.carts.service;

import com.micropos.carts.model.Item;
import com.micropos.carts.repository.Cart;
import com.micropos.carts.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartServiceImpl implements CartService {

    private CartRepository cartRepository;

    public CartServiceImpl(@Autowired CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }

    @Override
    public List<Item> items() {
        return cartRepository.items();
    }

    @Override
    public boolean add(String productId, int amount) {
        return cartRepository.addItem(productId, amount);
    }

    @Override
    public boolean remove(String productId) {
        return cartRepository.removeProduct(productId);
    }
}
