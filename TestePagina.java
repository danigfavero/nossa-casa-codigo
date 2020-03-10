import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Optional;

public class TestePagina {
	
	public static void main(String[] args) {
		
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
		
        Optional<Livro> optional = livros.buscaLivro("meu título0123");
        if (optional.isPresent()) {
        	Livro livroBuscado = optional.get();
        	System.out.println(livroBuscado.exibeLivro());
        }
        
		
	}
	
}
