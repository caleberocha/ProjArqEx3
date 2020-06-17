package singleton.factories;

import singleton.exceptions.NotImplementedException;
import singleton.strategies.PayCash;
import singleton.strategies.PayCreditCard;
import singleton.strategies.PayMethod;

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