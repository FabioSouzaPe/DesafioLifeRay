package com.company;

import model.CarrinhoDeCompras;
import model.ItemCarrinho;
import model.Produto;
import negocio.GeraNotaFiscal;
import uteis.ArquivosTxt;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {

        ArquivosTxt arq = new ArquivosTxt();
        GeraNotaFiscal gerarNota = new GeraNotaFiscal(arq);

        try {
            List<List<String>> a = arq.lerArquivosTxt();
            CarrinhoDeCompras carrinho = new CarrinhoDeCompras();

            for (List<String> produto : a) {
                if (produto.size() < 4) {
                    System.out.println("A linha: " + (a.indexOf(produto)+1)  + " do arquivo não está com a formatação correta e será ignorada");
                    break;
                }

                Produto adas = new Produto();

                adas.setNome(produto.get(0));
                adas.setValor(Double.valueOf(produto.get(1)));
                adas.setRetemImpostoDeVenda(produto.get(2).equals("true")? true :false);
                adas.setImportado(produto.get(3).equals("true")? true :false);

                carrinho.setItem(new ItemCarrinho(1, adas));

                //System.out.println(carrinho.getItens().get(0).getProduto().getNome());

                //System.out.println(adas.getNome());
                //System.out.println(adas.getValor());
                //System.out.println(adas.isRetemImpostoDeVenda());
                //System.out.println(adas.isImportado());
            }

            gerarNota.executar(carrinho);

        } catch (IOException e) {
            e.printStackTrace();
        }

        /*Produto produto1 = new Produto("Livro", 12.49, false, false);
        Produto produto2 = new Produto("Cd", 14.99, false, true);
        Produto produto3 = new Produto("Chocolate", 0.85, false, false);
        Produto produto4 = new Produto("Chocolate Importado", 10.00, true, false);
        Produto produto5 = new Produto("Perfume Importado", 47.50, true, true); //da erro
        Produto produto6 = new Produto("Perfume Importado", 27.99, true, true);
        Produto produto7 = new Produto("Perfume", 18.99, false, true);
        Produto produto8 = new Produto("Analgésicos", 9.75, false, false);
        Produto produto9 = new Produto("Chocolate Importado", 11.25, true, false); //da erro

        CarrinhoDeCompras carrinho = new CarrinhoDeCompras();
        CarrinhoDeCompras carrinho2 = new CarrinhoDeCompras();
        CarrinhoDeCompras carrinho3 = new CarrinhoDeCompras();

        carrinho.setItem(new ItemCarrinho(1, produto1));
        carrinho.setItem(new ItemCarrinho(1, produto2));
        carrinho.setItem(new ItemCarrinho(1, produto3));

        carrinho2.setItem(new ItemCarrinho(1, produto4));
        carrinho2.setItem(new ItemCarrinho(1, produto5));

        carrinho3.setItem(new ItemCarrinho(1, produto6));
        carrinho3.setItem(new ItemCarrinho(1, produto7));
        carrinho3.setItem(new ItemCarrinho(1, produto8));
        carrinho3.setItem(new ItemCarrinho(1, produto9));


        ArquivosTxt arq = new ArquivosTxt();
        GeraNotaFiscal gerarNota = new GeraNotaFiscal(arq);

        gerarNota.executar(carrinho);
        gerarNota.executar(carrinho2);
        gerarNota.executar(carrinho3);*/


    }
}
