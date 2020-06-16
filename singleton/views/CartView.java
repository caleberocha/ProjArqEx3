package singleton.views;

import singleton.controllers.CartController;
import singleton.models.Cart;
import singleton.utils.Input;

public class CartView {
    private Cart cart;
    private CartController controller;

    public CartView() {
        this.cart = Cart.getInstance();
        this.controller = new CartController();
        this.command();
    }

    public void command() {
        boolean running = true;
        while (running) {
            this.showCart();
            System.out.println();
            this.showCommands();
            String cmd = Input.input();
            switch (cmd) {
                case "add":
                    this.addItem();
                    break;
                case "sair":
                    running = false;
                    break;
                default:
                    System.out.println("Comando não reconhecido. Pressione ENTER para continuar.");
                    Input.input();
            }
            Input.clear();
        }
        Input.close();
        System.out.println("ADIOS");
    }

    public void showCart() {
        if (!this.cart.isEmpty()) {
            System.out.println("Carrinho:");
            System.out.println(this.cart.toString());
        }
    }

    public void showCommands() {
        System.out.println("Comandos:");
        System.out.println("add -> Adicionar item ao carrinho");
        System.out.println("sair -> Sair do programa");
    }

    public void addItem() {
        System.out.println("Insira o nome");
        String nome = Input.input();

        while (true) {
            try {
                System.out.println("Insira o preço");
                String preco = Input.input();

                controller.addItem(nome, preco);
                break;
            } catch (NumberFormatException e) {
                System.out.println("Formato do preço incorreto.");
            }
        }
    }
}