package com.micropos.carts.repository;

import com.micropos.carts.model.Item;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class Cart implements CartRepository {

    private List<Item> items = new ArrayList<>();

    @Override
    public List<Item> items() {
        return items;
    }

    @Override
    public Item getItem(String productId) {
        for (Item item: items) {
            if (item.getProductId().equals(productId))
                return item;
        }
        return null;
    }

    @Override
    public boolean addItem(String productId, int amount) {
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).getProductId().equals(productId)) {
                int quantity = items.get(i).getQuantity();
                quantity += amount;
                if (quantity < 0)
                    return false;
                if (quantity == 0)
                    items.remove(i);
                else
                    items.get(i).setQuantity(quantity);
                return true;
            }
        }
        return items.add(new Item(productId, amount));
    }

    @Override
    public boolean removeProduct(String productId) {
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).getProductId().equals(productId)) {
                items.remove(i);
                return true;
            }
        }
        return false;
    }

}
