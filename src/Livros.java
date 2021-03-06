import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Optional;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Livros implements Iterable<Livro> {
    
    public HashMap<String, Livro> livros = new HashMap<>();
    
    public void adiciona(Livro livro) {
        if (livros.containsKey(livro.getTitulo())) {
            throw new IllegalArgumentException("Livro duplicado");
        }
        livros.put(livro.getTitulo(), livro);
    }

    @Override
    public Iterator<Livro> iterator() {
        return livros.values().iterator();
    }

    public boolean contains(Livro livro) {
        return livros.containsKey(livro.getTitulo());
    }
    
    
    public String listaLivros() throws IOException {
        Gson gsonBuilder = new GsonBuilder().create();
        return gsonBuilder.toJson(livros.values());    
    }
    
    public Optional<Livro> buscaLivro(String titulo) {
        Assert.isNotEmpty(titulo, "Título pesquisado inválido");
        Livro livro = livros.get(titulo);
        if (livro != null) {
            return Optional.of(livro);
        }
        return Optional.empty();
    }
    
}
