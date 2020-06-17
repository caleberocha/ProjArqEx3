package singleton.controllers;

import java.math.BigDecimal;

import singleton.exceptions.PayNotAllowedException;
import singleton.facades.CartFacade;

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