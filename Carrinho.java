import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Iterator;

public class Carrinho implements Iterable<Livro> {

    public HashMap<Livro, Integer> carrinho = new HashMap<>();

    public void insere(Livro livro) {
        Assert.isNotEmpty(livro, "Livro inválido");
        carrinho.put(livro, this.getQuantidade(livro) + 1);
    }

    public void edita(Livro livro, int quantidade) {
        Assert.isNotEmpty(livro, "Livro inválido");
        Assert.assertTrue(quantidade >= 0, "Quantidade inválida");
        if (quantidade == 0) {
            carrinho.remove(livro);
        }
        carrinho.put(livro, quantidade);

    }

    public int getQuantidade(Livro livro) {
        Assert.isNotEmpty(livro, "Livro inválido");
        if (carrinho.get(livro) == null) {
            return 0;
        }
        return carrinho.get(livro);
    }

    public static BigDecimal totalProduto(BigDecimal preco, int quantidade) {
        return preco.multiply(new BigDecimal(quantidade));
    }

    public BigDecimal getTotalDoCarrinho() {
        BigDecimal total = new BigDecimal(0);
        for (Livro livro : this) {
            BigDecimal totalParcial = totalProduto(livro.getPreco(), this.getQuantidade(livro));
            total = total.add(totalParcial);
        }
        return total;
    }

    @Override
    public Iterator<Livro> iterator() {
        return carrinho.keySet().iterator();
    }

    public static void main(String[] args) {

        Livro livro1 = new Livro("meu título", "um resumo", "sumário muito lindo", new BigDecimal(30), 200, "ISBN", LocalDate.parse("2020-12-03"), new Categoria("minha categoria"));
        Livro livro2 = new Livro("meu título2", "um resumo", "sumário muito lindo", new BigDecimal(30), 200, "ISBN2", LocalDate.parse("2020-12-03"), new Categoria("minha categoria"));

        Carrinho carrinho = new Carrinho();
        carrinho.insere(livro1);
        carrinho.insere(livro1);
        carrinho.insere(livro2);
        carrinho.edita(livro2, 3);

        System.out.println("Título \tPreço \tQtd \tTotal");
        for (Livro livro : carrinho) {
            BigDecimal preco = livro.getPreco();
            int quantidade = carrinho.getQuantidade(livro);
            System.out.print(livro.getTitulo() + "\t");
            System.out.print(preco + "\t");
            System.out.print(quantidade + "\t");
            System.out.println(Carrinho.totalProduto(preco, quantidade));
        }
        System.out.println("TOTAL DA COMPRA:\t" + carrinho.getTotalDoCarrinho());
    }

}