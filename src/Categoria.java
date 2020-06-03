public class Categoria {
    private String nome;
    
    public Categoria(String nome) {
        if (nomeInvalido(nome)) {
            throw new IllegalArgumentException("Categoria inválida");
        }
        this.nome = nome;
    }

    public String getNome() {
        return this.nome;
    }
    
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Categoria other = (Categoria) obj;
        return this.getNome().equals(other.getNome());
    }
    
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((nome == null) ? 0 : nome.hashCode());
        return result;
    }
    
    private boolean nomeInvalido(String nome) {
        return (nome == null) || (nome.equals(""));
    }
    
}
