package projarqex3.factories;

import projarqex3.exceptions.NotImplementedException;
import projarqex3.strategies.PayCash;
import projarqex3.strategies.PayCreditCard;
import projarqex3.strategies.PayMethod;

public final class PayMethodFactory {
    private PayMethodFactory() {
        
    }

    public static PayMethod addPayMethod(String method) throws NotImplementedException {
        if(method.equals("1")) {
            return new PayCash();
        }
        if(method.equals("2")) {
            return new PayCreditCard();
        }
        throw new NotImplementedException(String.format("Método %s não implementado", method));
    }
}