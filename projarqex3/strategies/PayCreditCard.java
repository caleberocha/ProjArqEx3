package projarqex3.strategies;

import java.math.BigDecimal;

import projarqex3.models.CreditCard;
import projarqex3.utils.Input;

public class PayCreditCard implements PayMethod {
    private CreditCard card;

    @Override
    public boolean pay(BigDecimal amount) {
        if(card == null) {
            return false;
        }
        return true;

    }

    @Override
    public void getPayDetails() {
        System.out.print("Número do cartão: ");
        String number = Input.input();
        System.out.print("Nome no cartão: ");
        String name = Input.input();

        card = new CreditCard(number, name);
    }
    
    
}