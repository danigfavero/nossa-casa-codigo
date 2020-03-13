import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Optional;

public class Carrinho implements Iterable<Livro> {

	private BigDecimal totalDoCarrinho;
	private ArrayList<Livro> carrinho; 
	
	public Carrinho() {
		totalDoCarrinho = new BigDecimal(0);
		carrinho = new ArrayList<>();
	}

	public void insere(Livro livro) {
		Assert.isNotEmpty(livro, "Livro inválido");
		carrinho.add(livro);
		this.totalDoCarrinho =	this.totalDoCarrinho.add(livro.getPreco());
	}
	
	public static BigDecimal totalProduto(BigDecimal preco, int quantidade) {
		return preco.multiply(new BigDecimal(quantidade));
	}

	public BigDecimal getTotalDoCarrinho() {
		return totalDoCarrinho;
	}
	 
	@Override
	public Iterator<Livro> iterator() {
		return carrinho.iterator();
	}
	
	public static void main(String[] args) {
		
		Livro livro1 = new Livro("meu título", "um resumo", "sumário muito lindo", new BigDecimal(30), 200, "ISBN", LocalDate.parse("2020-12-03"), new Categoria("minha categoria"));
		Livro livro2 = new Livro("meu título2", "um resumo", "sumário muito lindo", new BigDecimal(30), 200, "ISBN2", LocalDate.parse("2020-12-03"), new Categoria("minha categoria"));
		
		Carrinho carrinho = new Carrinho();
        carrinho.insere(livro1);
        carrinho.insere(livro2);
		
		System.out.println("Título \tPreço \tQtd \tTotal");
		for (Livro livro : carrinho) {
			BigDecimal preco = livro.getPreco();
			int quantidade = 1; // por enquanto
			System.out.print(livro.getTitulo() + "\t");
			System.out.print(preco + "\t");
			System.out.print(quantidade + "\t");
			System.out.println(Carrinho.totalProduto(preco, quantidade));
		}

        System.out.println("TOTAL DA COMPRA:\t" + carrinho.getTotalDoCarrinho());
	}
	
}
