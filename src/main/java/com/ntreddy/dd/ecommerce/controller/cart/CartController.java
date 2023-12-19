package com.ntreddy.dd.ecommerce.controller.cart;


import static com.ntreddy.dd.ecommerce.constants.PathConstants.ADD;
import static com.ntreddy.dd.ecommerce.constants.PathConstants.API_V1;
import static com.ntreddy.dd.ecommerce.constants.PathConstants.CART_ID;
import static com.ntreddy.dd.ecommerce.constants.PathConstants.CART;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ntreddy.dd.ecommerce.dto.request.cart.CartItemRequest;
import com.ntreddy.dd.ecommerce.dto.request.cart.CartRequest;
import com.ntreddy.dd.ecommerce.dto.response.cart.CartResponse;
import com.ntreddy.dd.ecommerce.mapper.CartMapper;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping(API_V1+CART)
@Tag(name = "Cart Controller")
public class CartController {

	@Autowired
    private CartMapper cartMapper;

    @PostMapping(ADD)
    @Operation(summary = "Create a new cart", description = "Creates a new cart")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully created cart"),
            @ApiResponse(responseCode = "500", description = "Internal server error occurred")
    })
    public ResponseEntity<CartResponse> createProduct(@Valid @RequestBody CartRequest cartRequest) {
        return ResponseEntity.ok(cartMapper.create(cartRequest));
    }

    @GetMapping(CART_ID)
    @Operation(summary = "Get a cart by ID", description = "Returns a single cart identified by its ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved cart"),
            @ApiResponse(responseCode = "404", description = "cart not found"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    public ResponseEntity<CartResponse> getCartById(@PathVariable("cartId") Long cartId) {
        return ResponseEntity.ok(cartMapper.getCartById(cartId));
    }

    @PutMapping(CART_ID+"/complete")
    @Operation(summary = "Create order", description = "Clear customer cart and create order")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully created order"),
            @ApiResponse(responseCode = "404", description = "Cart not found"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    public ResponseEntity<CartResponse> completeCart(@PathVariable("cartId") Long cartId) {
        return ResponseEntity.ok(cartMapper.completeCart(cartId));
    }

    @GetMapping("/customer/{customerId}")
    @Operation(summary = "Get a cart by customer id", description = "Get a cart by customer id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved cart"),
            @ApiResponse(responseCode = "404", description = "Customer not found"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    public ResponseEntity<CartResponse> getCartByCustomerId(@PathVariable("customerId") Long customerId) {
        return ResponseEntity.ok(cartMapper.getByCustomerId(customerId));
    }

//    Cart items

    @PostMapping(CART_ID+"/items")
    @Operation(summary = "Create a new cart item", description = "Returns a single cart identified by customer id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully created cart item"),
            @ApiResponse(responseCode = "500", description = "Internal server error occurred")
    })
    public ResponseEntity<CartResponse> createCartItem(@PathVariable("cartId") Long cartId, @Valid @RequestBody CartItemRequest cartItemRequest) {
        return ResponseEntity.ok(cartMapper.addItem(cartId, cartItemRequest));
    }

    @DeleteMapping(CART_ID+"/items/{itemId}")
    @Operation(summary = "Delete cart item", description = "Delete cart item")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully deleted cart item"),
            @ApiResponse(responseCode = "500", description = "Internal server error occurred")
    })
    public ResponseEntity<CartResponse> deleteCartItem(@PathVariable("cartId") Long cartId, @PathVariable("itemId") Long itemId) {
        return ResponseEntity.ok(cartMapper.removeItem(cartId, itemId));
    }
}
