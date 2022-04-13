package com.micropos.carts.repository;


import com.micropos.carts.model.Item;

import java.util.List;

public interface CartRepository {

    public List<Item> items();

    public Item getItem(String productId);

    public boolean addItem(String productId, int amount);

    public boolean removeProduct(String productId);

}