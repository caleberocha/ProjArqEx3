package singleton.models;

import java.math.BigDecimal;
import java.util.ArrayList;
import singleton.config.Constants;

public final class Cart {
    private final static Cart INSTANCE = new Cart();
    private ArrayList<Item> items = new ArrayList<>();
    private boolean closed = false;
    private BigDecimal toPay;

    private Cart() {

    }

    public static Cart getInstance() {
        return INSTANCE;
    }

    public boolean addItem(Item item) {
        return items.add(item);
    }

    public boolean removeItem(Item item) {
        return items.remove(item);
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public int size() {
        return items.size();
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public String getTotal() {
        return this.items.stream().map(item -> new BigDecimal(item.getPreco()))
                .reduce(BigDecimal.ZERO, (total, item) -> item.add(total)).toString();
    }

    public BigDecimal getToPay() {
        return this.toPay;
    }

    public boolean needPayment() {
        return getToPay().compareTo(BigDecimal.ZERO) > 0;
    }

    public void pay(BigDecimal amount) {
        toPay = toPay.subtract(amount);
    }

    public boolean isOpen() {
        return !closed;
    }

    public boolean close() {
        if(closed) {
            return false;
        }
        toPay = new BigDecimal(getTotal());
        closed = true;
        return true;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Item item : this.items) {
            sb.append(item.toString()).append(System.lineSeparator());
        }
        sb.append(String.format(Constants.ITEM_DISPLAY_FORMAT, Constants.TOTAL, this.getTotal()));
        return sb.toString();
    }
}