package projarqex3.strategies;

import java.math.BigDecimal;

public interface PayMethod {
    boolean pay(BigDecimal amount);
    void getPayDetails();
}