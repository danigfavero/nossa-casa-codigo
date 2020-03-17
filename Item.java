import java.math.BigDecimal;

public class Item {
    
    private Livro livro;
    private int quantidade;
    
    public Item(Livro livro, int quantidade) {
        this.livro = livro;
        this.quantidade = quantidade;
    }
    
    public String getTitulo() {
        return livro.getTitulo();
    }
    
    public BigDecimal getPrecoUnidade() {
        return this.livro.getPreco();
    }
    
    public BigDecimal getPrecoTotal() {
        return getPrecoUnidade().multiply(new BigDecimal(getQuantidade()));
    }

    public int getQuantidade() {
        return quantidade;
    }   
    
    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
    
}
