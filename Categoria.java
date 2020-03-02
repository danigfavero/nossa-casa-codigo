package casaDoCodigo;

public class Categoria {
	private String nome;
	
	public Categoria(String nome) {
		if (nomeInvalido(nome)) {
			throw new IllegalArgumentException("Categoria duplicada");
		}
		this.nome = nome;
	}

	public String getNome() {
		return this.nome;
	}
	
	@Override
	public boolean equals(Object categoria) {
		Categoria outraCategoria = (Categoria) categoria;
		return this.getNome().equals(outraCategoria.getNome());
	}
	
	private boolean nomeInvalido(String nome) {
        return (nome == null) || (nome.equals(""));
    } 
	
}
