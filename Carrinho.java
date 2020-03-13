import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Optional;

public class Carrinho implements Iterable<Livro> {

	private BigDecimal totalDoCarrinho = new BigDecimal(0);
	public HashMap<Livro, Integer> carrinho = new HashMap<>();
	
	public boolean insere(Livros livros, String titulo) {
		Optional<Livro> optional = livros.buscaLivro(titulo);
		if (optional.isPresent()) {
			Livro livroBuscado = optional.get();
			carrinho.put(livroBuscado, this.getQuantidade(livroBuscado) + 1);
			this.totalDoCarrinho =	this.totalDoCarrinho.add(livroBuscado.getPreco());
			return true;
		}
		return false;
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
	
	@Override
    public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Item \tPreço \tQtd \tTotal\n");
		for (Livro livro : this) {
			sb.append(livro.getTitulo() + "\t");
			sb.append(livro.getPreco() + "\t");
			int quantidade = this.getQuantidade(livro);
			sb.append(quantidade + "\t");
			sb.append(livro.getPreco().multiply(new BigDecimal(quantidade)) + "\n");
		}
		sb.append("TOTAL: " + this.totalDoCarrinho);
        return sb.toString();
    }
	 
	@Override
	public Iterator<Livro> iterator() {
		return carrinho.keySet().iterator();
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
        
        carrinho.insere(livros, "meu título012"); 
        carrinho.edita(new Livro("meu título0123", "um resumo", "sumário muito lindo", new BigDecimal(30), 200, "ISBN0123", LocalDate.parse("2020-12-03"), new Categoria("minha categoria")), 3);
        System.out.println(carrinho);
        
	}
	
}
