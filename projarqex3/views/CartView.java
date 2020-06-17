package projarqex3.views;

import java.math.BigDecimal;

import projarqex3.controllers.CartController;
import projarqex3.exceptions.NotImplementedException;
import projarqex3.exceptions.PayNotAllowedException;
import projarqex3.exceptions.TooMuchCashException;
import projarqex3.factories.PayMethodFactory;
import projarqex3.models.Cart;
import projarqex3.strategies.PayMethod;
import projarqex3.utils.Input;

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

        while (this.cart.isOpen() && running) {
            running = handleCart();
        }

        while (this.cart.needPayment() && running) {
            running = handlePayment();
        }

        Input.close();
        System.out.println("Obrigado pela preferẽncia =)");
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
        System.out.println("1 -> Adicionar item ao carrinho");
        System.out.println("2 -> Fechar carrinho");
        System.out.println("0 -> Sair do programa");
    }

    public void showPayMethods() {
        System.out.println("Como deseja pagar?");
        System.out.println("1 -> Dinheiro");
        System.out.println("2 -> Cartão de crédito");
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

    public boolean handleCart() {
        this.showCart();
        System.out.println();

        this.showCommands();
        String cmd = Input.input();
        switch (cmd) {
            case "1":
                this.addItem();
                break;
            case "2":
                this.controller.close();
                break;
            case "0":
                return false;
            default:
                System.out.println("Comando não reconhecido.");
                Input.pause();
        }

        Input.clear();

        return true;
    }

    public boolean handlePayment() {
        BigDecimal amount;
        PayMethod payMethod;

        System.out.format("Total a pagar: %s", this.cart.getToPay());
        System.out.println();

        while (true) {
            try {
                System.out.println("O pagamento pode ser dividido em várias formas. Quanto deseja pagar?");
                amount = new BigDecimal(Input.input()).setScale(2);
                if (amount.compareTo(this.cart.getToPay()) == 1) {
                    throw new TooMuchCashException("Dinheiro demais! Tá rico, é?");
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("Número inválido");
            } catch (TooMuchCashException e) {
                System.out.println(e.getMessage());
            }
        }

        this.showPayMethods();
        while(true) {
            try {
                String method = Input.input();
                payMethod = PayMethodFactory.addPayMethod(method);
                break;
            } catch (NotImplementedException e) {
                System.out.println(e.getMessage());
                Input.pause();
            }
        }
        payMethod.getPayDetails();
        if(payMethod.pay(amount)) {
            try {
                this.controller.pay(amount);
            } catch (PayNotAllowedException e) {
                System.out.println(e.getMessage());
                Input.pause();
            }
        };

        Input.clear();

        return true;
    }
}