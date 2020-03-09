import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.time.LocalDate;
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
	
	public void listaLivros() throws IOException {
		OutputStream os = new FileOutputStream("ListaDeLivros.json");
		OutputStreamWriter osw = new OutputStreamWriter(os);
		BufferedWriter bw = new BufferedWriter(osw);
		
	    Gson gsonBuilder = new GsonBuilder().create();
	    String json = gsonBuilder.toJson(livros);
	    
	    bw.write(json);
	    bw.close();
	}

}
