import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Iterator;

public class Carrinho implements Iterable<Item> {

    public HashMap<String, Item> carrinho = new HashMap<>();
    
    public void insere(Livro livro) {
        Assert.isNotEmpty(livro, "Livro inválido");
        Item itemAntigo = carrinho.get(livro.getTitulo());
        
        if (itemAntigo == null) {
            carrinho.put(livro.getTitulo(), new Item(livro, 1));
        } else {
            itemAntigo.incrementaQuantidade();
        } 
    }
        
    public void edita(Livro livro, int quantidade) {
        Assert.isNotEmpty(livro, "Livro inválido");
        Assert.assertTrue(quantidade >= 0, "Quantidade inválida");
        if (quantidade == 0) {
            carrinho.remove(livro.getTitulo());
        }
        Item item = carrinho.get(livro.getTitulo());
        item.setQuantidade(quantidade);
    }

    public BigDecimal getTotalDoCarrinho() {
        BigDecimal total = new BigDecimal(0);
        for (Item item : this) {
            total = total.add(item.getPrecoTotal());
        }
        return total;
    }
     
    @Override
    public Iterator<Item> iterator() {
        return carrinho.values().iterator();
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
        for (Item item : carrinho) {
            System.out.print(item.getTitulo() + "\t");
            System.out.print(item.getPrecoUnidade() + "\t");
            System.out.print(item.getQuantidade() + "\t");
            System.out.println(item.getPrecoTotal());
        }
        System.out.println("TOTAL DA COMPRA:\t" + carrinho.getTotalDoCarrinho());   
    }
    
}
