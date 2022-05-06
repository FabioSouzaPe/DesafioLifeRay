package model;

import java.util.ArrayList;
import java.util.List;

public class CarrinhoDeCompras {

    private List<ItemCarrinho> itens;

    public CarrinhoDeCompras() {
        this.itens = new ArrayList<>();
    }

    public void setItem(ItemCarrinho item) {
        this.itens.add(item);
    }

    public void setItens(List<ItemCarrinho> itens) {
        this.itens = itens;
    }

    public List<ItemCarrinho> getItens() {
        return itens;
    }
}
