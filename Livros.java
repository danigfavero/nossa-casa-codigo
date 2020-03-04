import java.util.HashSet;
import java.util.Iterator;

public class Livros implements Iterable<Livro> {
	
	public HashSet<Livro> livros;
	
	public Livros() {
		this.livros = new HashSet<>();
	}
	
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
	
}
