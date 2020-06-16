package singleton.controllers;

import singleton.models.Cart;
import singleton.models.Item;

public class CartController {
    private Cart cart;

    public CartController() {
        this.cart = Cart.getInstance();
    }

    public boolean addItem(String nome, String preco) {
        Item item = new Item(nome, preco);
        return cart.addItem(item);
    }

    public boolean removeItem(Item item) {
        return cart.removeItem(item);
    }

}