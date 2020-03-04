import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TesteAutor {
	
	private Autores autores;
	
	public TesteAutor() {
		autores = new Autores();
        StringBuilder email = new StringBuilder();
        for (int i = 0; i < 5; i++) {
            email.append("a");
            Autor autor = new Autor("nome", email.toString() + "@email.com", "descrição");
            autores.add(autor);
        }
	}
	
	@Test
	public void autorDuplicado() {
        try {
            Autor autor = new Autor("nome", "a@email.com", "descrição");
            autores.add(autor);
        } catch (IllegalArgumentException e) {
            Assertions.assertEquals("Email duplicado", e.getMessage());
        }
	}
	
	@Test
	public void verificaInsercao() {
        StringBuilder email = new StringBuilder();
	    for (Autor autor : autores) {
	    	email.append("a");
	        Assertions.assertEquals("nome", autor.getNome());
	        Assertions.assertEquals(email + "@email.com", autor.getEmail());
	        Assertions.assertEquals("descrição", autor.getDescricao());
	    }
	}

}
