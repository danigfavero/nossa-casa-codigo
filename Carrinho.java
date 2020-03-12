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
	 
	@Override
    public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Item \tPreço \tQtd \tTotal\n");
		for (Livro livro : carrinho) {
			sb.append(livro.getTitulo() + "\t");
			sb.append(livro.getPreco() + "\t");
			sb.append("1\t");
			sb.append(livro.getPreco().multiply(BigDecimal.ONE) + "\n");
		}
		sb.append("TOTAL: " + this.totalDoCarrinho);
        return sb.toString();
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
        
        System.out.println(carrinho);
	}
	
}
