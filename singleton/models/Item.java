package singleton.models;

import java.math.BigDecimal;
import java.math.RoundingMode;

import singleton.config.Constants;

public class Item {
    private String nome;
    private BigDecimal preco;

    public Item(String nome, String preco) {
        this.setNome(nome);
        this.setPreco(preco);
    }

    public String getNome() {
        return this.nome;
    }

    public String getPreco() {
        return preco.toString();
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    private void setPreco(String preco) {
        this.preco = new BigDecimal(preco).setScale(2, RoundingMode.HALF_UP);
    }

    public String toString() {
        return String.format(Constants.ITEM_DISPLAY_FORMAT, this.nome, this.preco);
    }
}