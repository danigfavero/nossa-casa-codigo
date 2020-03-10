import java.math.BigDecimal;
import java.time.LocalDate;

public class Livro {
	
	private String titulo;
	private String resumo;
	private String sumario;
	private BigDecimal preco;
	private int paginas;
	private String isbn;
	private LocalDate dataPublicacao;
	private Categoria categoria;
	
	
	public Livro (String titulo, String resumo, String sumario, BigDecimal preco,
				  int paginas, String isbn, LocalDate data, Categoria categoria) {
		
		Assert.isNotEmpty(titulo, "Título inválido");
		this.titulo = titulo;
		
		Assert.isNotEmpty(resumo,"Resumo inválido");
		Assert.assertTrue((resumo.length() <= 500), "Resumo inválido");
		this.resumo = resumo;
		
		this.sumario = sumario;
		
		Assert.assertTrue((preco.compareTo(new BigDecimal(20.0)) == 1), "Preço inválido");
		this.preco = preco;
		
		Assert.assertTrue((paginas >= 100), "Número de páginas inválido");
		this.paginas = paginas;
		
		Assert.isNotEmpty(isbn, "Isbn inválido");
		this.isbn = isbn;
		
		Assert.isNotEmpty(data, "Data inválida");
		Assert.assertTrue(data.isAfter(LocalDate.now()), "Data inválida");
		this.dataPublicacao = data;
		
		Assert.isNotEmpty(categoria, "Categoria inválida");
		this.categoria = categoria;
	}

	public String getTitulo() {
		return this.titulo;
	}

	public String exibeLivro() {
		return this.titulo + "\n" +
			   this.preco + "\n" +
			   this.resumo + "\n" +
			   this.sumario + "\n" +
			   this.paginas + "\n" +
			   this.isbn;   
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
