import java.io.IOException;
import java.time.LocalDate;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TesteLivro {
    
    private static Livros livros = new Livros();
    
    @Test
	public void livroDuplicado() {
    	Livro livro = new Livro("titulo", "resumo", "sumerio", (float) 30, 200, "isbn", LocalDate.parse("2020-12-03"), new Categoria("ux"));
        livros.adiciona(livro);
        try {
        	Livro livro2 = new Livro("titulo", "resumo", "sumerio", (float) 30, 200, "isbn", LocalDate.parse("2020-12-03"), new Categoria("ux"));
            livros.adiciona(livro2);
        } catch (IllegalArgumentException e) {
            Assertions.assertEquals("Livro duplicado", e.getMessage());
        }
	}
    
    @Test
    public void verificaInsercao() {
    	StringBuilder nome = new StringBuilder();
        StringBuilder isbn = new StringBuilder();
        for (int i = 0; i < 5; i++) {
            nome.append("a");
            isbn.append("1");
            Livro livro = new Livro(nome.toString(), "resumo", "sumerio", (float) 30, 200, isbn.toString(), LocalDate.parse("2020-12-03"), new Categoria("ux"));
            livros.adiciona(livro);
        } 
        
    	nome = new StringBuilder();
    	isbn = new StringBuilder();
    	for (int i = 0; i < 5; i++) {
	    	nome.append("a");
            isbn.append("1");
            Livro outro = new Livro(nome.toString(), "resumo", "sumerio", (float) 30, 200, isbn.toString(), LocalDate.parse("2020-12-03"), new Categoria("ux"));
            Assertions.assertTrue(livros.contains(outro));
	    }
    }
    
    @Test
    public void testaJson() {
    	
		Livros livros = new Livros();
		StringBuilder titulo = new StringBuilder();
		titulo.append("meu título");
    	StringBuilder isbn = new StringBuilder();
    	isbn.append("ISBN");
    	
        for (int i = 0; i < 5; i++) {
        	titulo.append(Integer.toString(i));
            isbn.append(Integer.toString(i));
            Livro livro = new Livro(titulo.toString(), "um resumo", "sumário muito lindo", (float) 30, 200, isbn.toString(), LocalDate.parse("2020-12-03"), new Categoria("minha categoria"));
            livros.adiciona(livro);
        } 
        
        try {
			livros.listaLivros();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
    
}