import java.util.HashSet;
import java.util.Iterator;

public class Categorias implements Iterable<Categoria> {
    
    public HashSet<Categoria> categorias;
    
    public Categorias() {
        this.categorias = new HashSet<>();
    }
    
    public void adiciona(Categoria categoria) {
        if (!categorias.add(categoria)) {
            throw new IllegalArgumentException("Categoria duplicada");
        }
    }

    @Override
    public Iterator<Categoria> iterator() {
        return categorias.iterator();
    }

    public boolean contains(Object obj) {
        return categorias.contains(obj);
    }
    
}
