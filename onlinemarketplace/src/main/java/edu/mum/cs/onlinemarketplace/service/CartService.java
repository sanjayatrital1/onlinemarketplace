package edu.mum.cs.onlinemarketplace.service;

import edu.mum.cs.onlinemarketplace.domain.Cart;

public interface CartService {

    Cart getCartById(Long id);
    void removeOrderById(Long id);
    Cart saveCart(Cart cart);
}
