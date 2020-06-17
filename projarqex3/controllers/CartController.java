package projarqex3.controllers;

import java.math.BigDecimal;

import projarqex3.exceptions.PayNotAllowedException;
import projarqex3.facades.CartFacade;

public class CartController {
    private CartFacade cart;

    public CartController() {
        this.cart = new CartFacade();
    }

    public boolean addItem(String nome, String preco) {
        return cart.addItem(nome, preco);
    }

    public boolean close() {
        return cart.close();
    }

    public void pay(BigDecimal amount) throws PayNotAllowedException {
        cart.pay(amount);
    }

}