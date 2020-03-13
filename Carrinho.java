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
	
	public boolean insere(Livros livros, String titulo) {
		Optional<Livro> optional = livros.buscaLivro(titulo);
		if (optional.isPresent()) {
			Livro livroBuscado = optional.get();
			carrinho.add(livroBuscado);
			this.totalDoCarrinho =	this.totalDoCarrinho.add(livroBuscado.getPreco());
			return true;
		}
		return false;
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
		
		// CRIANDO COLEÇÃO DE LIVROS
		Livros livros = new Livros();
		StringBuilder titulo = new StringBuilder();
		titulo.append("meu título");
    	StringBuilder isbn = new StringBuilder();
    	isbn.append("ISBN");

        for (int i = 0; i < 5; i++) {
        	titulo.append(Integer.toString(i));
            isbn.append(Integer.toString(i));
			Livro livro = new Livro(titulo.toString(), "um resumo", "sumário muito lindo", new BigDecimal(30), 200, isbn.toString(), LocalDate.parse("2020-12-03"), new Categoria("minha categoria"));
            livros.adiciona(livro);
        } 	
        
        // TESTE DO CARRINHO
        Carrinho carrinho = new Carrinho();
        carrinho.insere(livros, "meu título0123");
        carrinho.insere(livros, "meu título012");
		
		for (Livro livro : carrinho) {
			BigDecimal preco = livro.getPreco();
			int quantidade = 1; // por enquanto
			System.out.println(livro.getTitulo() + "\t");
			System.out.println(preco + "\t");
			System.out.println(quantidade + "\t");
			System.out.println(Carrinho.totalProduto(preco, quantidade) + "\n");
		}

        System.out.println(carrinho.getTotalDoCarrinho());
	}
	
}
