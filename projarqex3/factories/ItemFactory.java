package projarqex3.factories;

import projarqex3.models.Item;

public final class ItemFactory {
    private ItemFactory() {

    }

    public static Item addItem(String nome, String preco) {
        return new Item(nome, preco);
    }
}