package casaDoCodigo;

import java.util.LinkedList;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TesteCategoria {
	@Test
	public void testeCategoria() {
		LinkedList<Categoria> categorias = new Categorias();
        StringBuilder nome = new StringBuilder();
        for (int i = 0; i < 5; i++) {
            nome.append("a");
            categorias.add(new Categoria(nome.toString()));
        }

        try {
        	categorias.add(new Categoria("a"));
        } catch (IllegalArgumentException e) {
            Assertions.assertEquals("Categoria duplicada", e.getMessage());
        }

        nome = new StringBuilder();
	    for (Categoria categoria : categorias) {
	    	nome.append("a");
	        Assertions.assertEquals(nome.toString(), categoria.getNome());
	    }
	    
	    LinkedList<Categoria> categorias2 = new Categorias();
	    
	    categorias2.add(new Categoria("aa"));
	    try {
	    	categorias2.addAll(0, categorias);
	    } catch (IllegalArgumentException e) {
	    	Assertions.assertEquals("Categoria duplicada", e.getMessage());
	    }
	    
	    nome = new StringBuilder();
	    for (Categoria categoria : categorias2) {
	    	nome.append("a");
	    	Assertions.assertEquals(nome.toString(), categoria.getNome());
	    }
		
	}
}
