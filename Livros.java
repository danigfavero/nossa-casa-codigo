import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.util.Optional;

public class Livros implements Iterable<Livro> {
	
	public HashSet<Livro> livros = new HashSet<>();
	
	public void adiciona(Livro livro) {
        if (!livros.add(livro)) {
            throw new IllegalArgumentException("Livro duplicado");
        }
    }

	@Override
	public Iterator<Livro> iterator() {
		return livros.iterator();
	}

	public boolean contains(Object obj) {
		return livros.contains(obj);
	}
	
	public String listaLivros() throws IOException {
		Gson gsonBuilder = new GsonBuilder().create();
	    return gsonBuilder.toJson(livros);    
	}

	public Optional<Livro> buscaLivro(String titulo) {
		Assert.isNotEmpty(titulo, "Título pesquisado inválido");
		for (Livro livro : livros) {
			if (titulo.equals(livro.getTitulo()))
				return Optional.of(livro);
		}
		return Optional.empty();
	}

}
