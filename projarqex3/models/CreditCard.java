package projarqex3.models;

public class CreditCard {
    private String number;
    private String name;

    public CreditCard(String number, String name) {
        this.number = number;
        this.name = name;
    }

    public String getNumber() {
        return this.number;
    }

    public String getName() {
        return this.name;
    }
}