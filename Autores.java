import java.util.Collection;
import java.util.LinkedList;

public class Autores extends LinkedList<Autor> {

    @Override
	public void add(int index, Autor autor) {
		for (Autor a : this) {
            if (a.equals(autor))
                throw new IllegalArgumentException("Email duplicado");
		}
		super.add(index, autor);
	}
	
	@Override
	public boolean add(Autor autor) {
		for (Autor a : this) {
            if (a.equals(autor))
                throw new IllegalArgumentException("Email duplicado");
		}
		return super.add(autor);
    }
	
	@Override
	public boolean addAll(int index, java.util.Collection<? extends Autor> autores) {
		for (Autor autor : autores) {
			this.add(index, autor);
		}
		return true;
	}
	
	@Override
	public boolean addAll(Collection<? extends Autor> autores) {
		for (Autor autor : autores) {
			this.add(autor);
		}
		return true;
	}
}
