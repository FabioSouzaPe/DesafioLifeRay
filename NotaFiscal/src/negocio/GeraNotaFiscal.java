package negocio;

import enums.Impostos;
import enums.Precisao;
import model.CarrinhoDeCompras;
import model.ItemCarrinho;
import uteis.ArquivosTxt;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class GeraNotaFiscal {

    private ArquivosTxt arquivo;

    public GeraNotaFiscal(ArquivosTxt arquivo) {
        this.arquivo = arquivo;
    }

    public void executar(CarrinhoDeCompras carrinho) {

        double valorTotalNotaComImposto = 0.0;
        double valorTotalNotaSemImposto = 0.0;
        double valorTotalImpostos;

        StringBuilder nota = new StringBuilder();
        nota.append("Nota Fiscal" + "\n");

        for (ItemCarrinho itemCarrinho : carrinho.getItens()) {

            double valorProdutoComImposto = calcularImpostoPorProduto(itemCarrinho);

            nota.append(itemCarrinho.getQuantidade())
                    .append(" ")
                    .append(itemCarrinho.getProduto().getNome())
                    .append(": $")
                    .append(arredondaHalfEven(valorProdutoComImposto, Precisao.DUPLA.getValor())).append("\n");

            valorTotalNotaSemImposto += itemCarrinho.getProduto().getValor();
            valorTotalNotaComImposto += valorProdutoComImposto;

        }

        valorTotalImpostos = valorTotalNotaComImposto - valorTotalNotaSemImposto;

        nota.append("Impostos sobre venda: $")
                .append(arredondaHalfEven(valorTotalImpostos, Precisao.DUPLA.getValor())).append("\n");
        nota.append("Valor total da Nota: $")
                .append(arredondaHalfEven(valorTotalNotaComImposto, Precisao.DUPLA.getValor()));

        //System.out.println(nota);

        arquivo.gerarArquiosTxt(nota);

        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    private double calcularImpostoPorProduto(ItemCarrinho itemCarrinho) {

        double valorProduto;

        if (itemCarrinho.getProduto().isRetemImpostoDeVenda()) {
            valorProduto = (((Impostos.IMPOSTOSOBREVENDA.getValor() / 100) * itemCarrinho.getProduto().getValor()) + itemCarrinho.getProduto().getValor()) * itemCarrinho.getQuantidade();
        } else {
            valorProduto = (itemCarrinho.getProduto().getValor()) * itemCarrinho.getQuantidade();
        }

        if (itemCarrinho.getProduto().isImportado()) {
            valorProduto = valorProduto + ((Impostos.IMPOSTODEIMPORATACAO.getValor() / 100) * itemCarrinho.getProduto().getValor());
        }

        return valorProduto;
    }

    private BigDecimal arredondaHalfEven(double valor, int precisao) {
        return new BigDecimal(valor).setScale(precisao, RoundingMode.HALF_EVEN);
    }

}
