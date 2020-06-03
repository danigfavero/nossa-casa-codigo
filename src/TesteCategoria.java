import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TesteCategoria {
    
    private Categorias categorias;
    
    public TesteCategoria() {
        categorias = new Categorias();
    }
    
    @Test
    public void entradaNula() {   
        try {
            categorias.adiciona(new Categoria(null));
        } catch (IllegalArgumentException e) {
            Assertions.assertEquals("Categoria inválida", e.getMessage());
        }
    }
    
    @Test
    public void entradaVazia() {
        try {
            categorias.adiciona(new Categoria(""));
        } catch (IllegalArgumentException e) {
            Assertions.assertEquals("Categoria inválida", e.getMessage());
        }
    }
    
    @Test
    public void entradaDuplicada() {
        try {
            categorias.adiciona(new Categoria("a"));
        } catch (IllegalArgumentException e) {
            Assertions.assertEquals("Categoria duplicada", e.getMessage());
        }
    }

    @Test
    public void verificaInsercao() {
        StringBuilder nome = new StringBuilder();
        for (int i = 0; i < 5; i++) {
            nome.append("a");
            categorias.adiciona(new Categoria(nome.toString()));
        } 
        
        nome = new StringBuilder();
        for (int i = 0; i < 5; i++) {
            nome.append("a");
            Assertions.assertTrue(categorias.contains(new Categoria(nome.toString())));
        }	
    }
    
}
