import java.time.LocalDate;

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
		if (tituloInvalido(titulo)) {
			throw new IllegalArgumentException("Título inválido");
		}
		this.titulo = titulo;
		if (resumoInvalido(resumo)) {
			throw new IllegalArgumentException("Resumo inválido");
		}
		this.resumo = resumo;
		this.sumario = sumario;
		if (precoInvalido(preco)) {
			throw new IllegalArgumentException("Preço inválido");
		}
		this.preco = preco;
		if (nPaginasInvalido(paginas)) {
			throw new IllegalArgumentException("Número de páginas inválido");
		}
		this.paginas = paginas;
		if (isbnInvalido(isbn)) {
			throw new IllegalArgumentException("Isbn inválido");
		} 
		this.isbn = isbn;
		if (dataInvalida(data)) {
			throw new IllegalArgumentException("Data inválida");
		}
		this.dataPublicacao = data;
		if (categoriaInvalida(categoria)) {
			throw new IllegalArgumentException("Categoria inválida");
		}
		this.categoria = categoria;
	}
	
	private boolean tituloInvalido (String titulo) {
		return (titulo == null) || (titulo.equals(""));
	}
	
	private boolean resumoInvalido (String resumo) {
		if (resumo == null || resumo.equals("")) {
            return true;
        }
        return resumo.length() > 500;
	}

	private boolean precoInvalido (float preco) {
        return preco < 20.0;
	}
	
	private boolean nPaginasInvalido (int paginas) {
		return paginas < 100;
	}

	private boolean isbnInvalido (String isbn) {
		return (isbn == null) || (isbn.equals(""));
	}
	
	private boolean dataInvalida (LocalDate data) {
		return data.isBefore(LocalDate.now());
	}
	
	private boolean categoriaInvalida (Categoria categoria) {
		return categoria == null;
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
