package Main;

import Utils.CsvToArray;

import java.io.IOException;
import java.util.ArrayList;

public class Estoque {

    private static int id = 1;
    private static final ArrayList<Produto> listaDeProdutos = new ArrayList();

    public static void inicializaEstoque() {
        try {
            ArrayList<String[]> listaAuxiliar = CsvToArray.csvToArrayList("ListaDeProdutos.CSV");
            for (String[] produto : listaAuxiliar.subList(1, listaAuxiliar.size())) {
                String nome = produto[0];
                double preco = Double.parseDouble(produto[1]);
                int quantidade = Integer.parseInt(produto[2]);
                cadastraProduto(new Produto(id++, nome, preco, quantidade));
            }
        } catch (IOException e) {
            System.out.println("Arquivo nao encontrado, o catalogo inicializara vazio");
        }
    }

    public static Produto encontraProduto(String nome) {
        for (Produto produto : getListaDeProdutos()) {
            if (produto.getNome().equalsIgnoreCase(nome)) {
                return produto;
            }
        }
        return null;
    }

    public static Produto encontraProduto(int id) {
        for (Produto produto : getListaDeProdutos()) {
            if (produto.getId() == id) {
                return produto;
            }
        }
        return null;
    }

    public static boolean cadastraProduto(Produto produto) {
        if (encontraProduto(produto.getNome()) == null) {
            listaDeProdutos.add(produto);
            return true;
        } else {
            return false;
        }
    }

    public static void imprimeCatalagoDoEstoque() {
        System.out.println("                              CATALOGO");
        System.out.println("________________________________________________________________________");
        System.out.printf("ID       |NOME                       |PRECO              |QUANTIDADE \n");
        for (Produto produto : listaDeProdutos) {
            System.out.printf("%-8d | %-25s | R$%-15.2f | %d\n"
                    , produto.getId(), produto.getNome(), produto.getPreco(), produto.getQuantidadeEmEstoque());
        }
        System.out.println("________________________________________________________________________");
    }

    public static boolean darBaixaEmEstoque(String nome, int quantidadeParaDarBaixa) {
        Produto produto = encontraProduto(nome);
        if (produto != null) {
            if (temEstoqueOuNao(produto, quantidadeParaDarBaixa)) {
                listaDeProdutos.get(getPosicaoDoProdutoNaLista(produto)).setQuantidadeEmEstoque(getQuantidadeAtualEmEstoque(produto) - quantidadeParaDarBaixa);
                return true;
            } else {
                System.out.println("Nao tem quantidade o suficiente de " + produto.getNome());
                return false;
            }
        } else {
            System.out.println("Produto nao encontrado para dar baixa no estoque");
            return false;
        }
    }

    public static void darBaixaEmEstoque(int id, int quantidadeParaDarBaixa) {
        Produto produto = encontraProduto(id);
        if (!produto.equals(null)) {
            if (temEstoqueOuNao(produto, quantidadeParaDarBaixa)) {
                getListaDeProdutos().get(getPosicaoDoProdutoNaLista(produto)).setQuantidadeEmEstoque(getQuantidadeAtualEmEstoque(produto) - quantidadeParaDarBaixa);
            } else {
                System.out.println("Nao tem quantidade o suficiente de " + produto.getNome());
            }
        } else {
            System.out.println("Produto nao encontrado para dar baixa no estoque");
           
        }
    }

    public static int getQuantidadeAtualEmEstoque(Produto produto) {
        return listaDeProdutos.get(getPosicaoDoProdutoNaLista(produto)).getQuantidadeEmEstoque();
    }

    public static int getPosicaoDoProdutoNaLista(Produto produto) {
        return getListaDeProdutos().indexOf(produto);
    }

    public static boolean temEstoqueOuNao(Produto produto, int quantidadeParaDarBaixa) {
        int posicaoDoProdutoNaLista, quantidadeAtualEmEstoque;
        posicaoDoProdutoNaLista = getListaDeProdutos().indexOf(produto);
        quantidadeAtualEmEstoque = getListaDeProdutos().get(posicaoDoProdutoNaLista).getQuantidadeEmEstoque();
        if (quantidadeAtualEmEstoque >= quantidadeParaDarBaixa) {
            return true;
        }  else {
        return false;
    }
    }

    public static ArrayList<Produto> getListaDeProdutos() {
        return listaDeProdutos;
    }
}
