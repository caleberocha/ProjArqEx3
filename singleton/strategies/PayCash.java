package singleton.strategies;

import java.math.BigDecimal;

public class PayCash implements PayMethod {

    @Override
    public boolean pay(BigDecimal amount) {
        return true;
    }

    @Override
    public void getPayDetails() {
        // Money vivo, nada para implementar =)
    }
    
}