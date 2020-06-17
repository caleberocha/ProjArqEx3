package projarqex3.facades;

import java.math.BigDecimal;

import projarqex3.exceptions.PayNotAllowedException;
import projarqex3.factories.ItemFactory;
import projarqex3.models.Cart;
import projarqex3.models.Item;

public class CartFacade {
    private Cart cart;

    public CartFacade() {
        this.cart = Cart.getInstance();
    }

    public boolean addItem(String nome, String preco) {
        Item item = ItemFactory.addItem(nome, preco);
        return cart.addItem(item);
    }

    public boolean removeItem(Item item) {
        return cart.removeItem(item);
    }

    public boolean close() {
        return cart.close();
    }

    public void pay(BigDecimal amount) throws PayNotAllowedException {
        if(!cart.needPayment()) {
            throw new PayNotAllowedException("Quer dar dinheiro de graça?");
        }
        cart.pay(amount);
    }
}