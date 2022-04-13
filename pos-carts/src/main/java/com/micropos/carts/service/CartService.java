package com.micropos.carts.service;

import com.micropos.carts.model.Item;
import com.micropos.carts.repository.Cart;

import java.util.List;

public interface CartService {

    public Item getItem(String productId);

    public List<Item> items();

    public boolean add(String productId, int amount);

    public boolean remove(String productId);
}
