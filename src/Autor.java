import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.LinkedList;


public class Autor {

    private String nome;
    private String email;
    private String descricao;
    private LocalDateTime instante;

    public Autor(String nome, String email, String descricao) {
        if (nomeInvalido(nome)) {
            throw new IllegalArgumentException("Nome inválido");
        }    
        this.nome = nome;
        if (emailInvalido(email)) {
            throw new IllegalArgumentException("Email inválido");
        }    
        this.email = email;
        if (descricaoInvalida(descricao)) {
            throw new IllegalArgumentException("Descrição inválida");
        }    
        this.descricao = descricao;
        this.instante = LocalDateTime.now();
    }

    private boolean nomeInvalido(String nome) {
        return (nome == null) || (nome.equals(""));
    } 
    
    private boolean emailInvalido(String email) {
        if (email == null) {
            return true;
        }
        String definicaoDoPadrao = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@" +
        "((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}" +
        "\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+" +
        "[a-zA-Z]{2,}))$";
        java.util.regex.Pattern padrao = java.util.regex.Pattern.compile(definicaoDoPadrao);
        java.util.regex.Matcher comparador = padrao.matcher(email);
        return !comparador.matches();
    }
    
    public String getNome() {
        return this.nome;
      }

      public String getEmail() {
          return this.email;
      }
    
    public String getDescricao() {
          return this.descricao;
      }

    private boolean descricaoInvalida(String descricao) {
        if (descricao == null || descricao.equals("")) {
            return true;
        }
        return descricao.length() > 400;
    }

    @Override
    public boolean equals(Object outroAutor) {
        Autor autor = (Autor) outroAutor;
        return this.getEmail().equals(autor.getEmail());
    }
    
    @Override
    public String toString() {
        DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String dataFormatada = this.instante.format(formatador);
        return "Autor: " + this.getNome() 
               + "\nEmail: " + this.getEmail()
               + "\nDescrição: " + this.getDescricao()
               + "\nCadastro feito em " + dataFormatada;
    }   
    
}
