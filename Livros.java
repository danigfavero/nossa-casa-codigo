import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

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

}
