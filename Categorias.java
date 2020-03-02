package casaDoCodigo;

import java.util.Collection;
import java.util.LinkedList;

public class Categorias extends LinkedList<Categoria> {
	
	@Override
	public void add(int index, Categoria categoria) {
		for (Categoria c : this) {
            if (c.equals(categoria))
                throw new IllegalArgumentException("Categoria duplicada");
		}
		super.add(index, categoria);
	}
	
	@Override
	public boolean add(Categoria categoria) {
		for (Categoria c : this) {
            if (c.equals(categoria))
                throw new IllegalArgumentException("Categoria duplicada");
		}
		return super.add(categoria);
    }
	
	@Override
	public boolean addAll(int index, java.util.Collection<? extends Categoria> categorias) {
		for (Categoria categoria : categorias) {
			this.add(index, categoria);
		}
		return true;
	}
	
	@Override
	public boolean addAll(Collection<? extends Categoria> categorias) {
		for (Categoria categoria : categorias) {
			this.add(categoria);
		}
		return true;
	}
	
}
