import java.time.LocalDate;
import org.junit.jupiter.api.Assertions;

public class Livro {
	
	private String titulo;
	private String resumo;
	private String sumario;
	private float preco;
	private int paginas;
	private String isbn;
	private LocalDate dataPublicacao;
	private Categoria categoria;
	
	
	public Livro (String titulo, String resumo, String sumario, float preco,
				  int paginas, String isbn, LocalDate data, Categoria categoria) {
		
		Assertions.assertNotNull(titulo,"Título inválido");
		this.titulo = titulo;
		
		Assertions.assertNotNull(resumo,"Resumo inválido");
		Assertions.assertTrue((resumo.length() <= 500), "Resumo inválido");
		this.resumo = resumo;
		
		this.sumario = sumario;
		
		Assertions.assertTrue((preco >= 20.0), "Preço inválido");
		this.preco = preco;
		
		Assertions.assertTrue((paginas >= 100), "Número de páginas inválido");
		this.paginas = paginas;
		
		Assertions.assertNotNull(isbn,"Isbn inválido");
		this.isbn = isbn;
		
		Assertions.assertNotNull(data,"Data inválida");
		Assertions.assertTrue(data.isAfter(LocalDate.now()), "Data inválida");
		this.dataPublicacao = data;
		
		Assertions.assertNotNull(categoria,"Categoria inválida");
		this.categoria = categoria;
	}
	
	public String getTitulo() {
		return this.titulo;
	}
	
	public String getResumo() {
		return this.resumo;
	}
	
	public String getSumario() {
		return this.sumario;
	}
	
	public float getPreco() {
		return this.preco;
	}
	
	public int getNPaginas() {
		return this.paginas;
	}
	
	public String getIsbn() {
		return this.isbn;
	}
	
	public LocalDate getDataPublicacao() {
		return this.dataPublicacao;
	}
	
	public Categoria getCategoria() {
		return this.categoria;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((isbn == null) ? 0 : isbn.hashCode());
		result = prime * result + ((titulo == null) ? 0 : titulo.hashCode());
		return result;
	}
	
	@Override
	public boolean equals (Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Livro livro = (Livro) obj;
		boolean tituloIgual = this.titulo.equals(livro.titulo);
		boolean isbnIgual = this.isbn.equals(livro.isbn);
		return tituloIgual && isbnIgual;
	}
	
}
