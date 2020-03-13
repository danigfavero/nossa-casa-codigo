import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Optional;

public class Carrinho implements Iterable<Livro> {

	private BigDecimal totalDoCarrinho = new BigDecimal(0);
	public HashMap<Livro, Integer> carrinho = new HashMap<>();
	
	public void insere(Livro livro) {
		Assert.isNotEmpty(livro, "Livro inválido");
		carrinho.put(livroBuscado, this.getQuantidade(livro) + 1);
		this.totalDoCarrinho =	this.totalDoCarrinho.add(livro.getPreco());
	}
	
		
	public void edita(Livro livro, int quantidade) {
	    Assert.isNotEmpty(livro, "Livro inválido");
	    Assert.assertTrue(quantidade >= 0, "Quantidade inválida");
	    
	    int quantidadeAntiga = this.getQuantidade(livro);
	    if (quantidade == 0) {
	        carrinho.remove(livro);
	    }
	    carrinho.put(livro, quantidade);
	    atualizaTotal(livro, quantidadeAntiga, quantidade);
	   
	}
	
	private void atualizaTotal(Livro livro, int quantidadeAntiga, int quantidade) {
	    BigDecimal precoAntigo = livro.getPreco().multiply(BigDecimal.valueOf(quantidadeAntiga));
	    BigDecimal precoAtual = livro.getPreco().multiply(BigDecimal.valueOf(quantidade));
        BigDecimal total = precoAtual.subtract(precoAntigo);
        this.totalDoCarrinho = totalDoCarrinho.add(total);
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
		return totalDoCarrinho;
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
			int quantidade = 1; // por enquanto
			System.out.print(livro.getTitulo() + "\t");
			System.out.print(preco + "\t");
			System.out.print(quantidade + "\t");
			System.out.println(Carrinho.totalProduto(preco, quantidade));
		}
    COMPRA:\t" + carrinho.getTotalDoCarrinho());   
	}
	
}
