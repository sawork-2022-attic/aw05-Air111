package com.micropos.carts.rest;

import com.micropos.carts.api.ApiUtil;
import com.micropos.carts.api.CartsApi;
import com.micropos.carts.dto.CartDto;
import com.micropos.carts.mapper.CartMapper;
import com.micropos.carts.model.Item;
import com.micropos.carts.repository.Cart;
import com.micropos.carts.service.CartService;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api")
public class CartController implements CartsApi {

    private final CartMapper cartMapper;

    private final CartService cartService;


    public CartController(CartService cartService, CartMapper cartMapper) {
        this.cartMapper = cartMapper;
        this.cartService = cartService;
    }

    @Override
    public ResponseEntity<List<Item>> listCart() {
        List<ItemDto> items = new ArrayList<>(cartMapper.toItemsDto(this.cartService.items()));
        if (items.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(items, HttpStatus.OK);
    }

}
