package Classes;

public class Passageiro {
    private String nome;
    private String telefone;

    public Passageiro(String nome, String telefone) {
        this.nome = nome;
        this.telefone = telefone;
    }

    public String getNome() {
        return nome;
    }

    public String getTelefone() {
        return telefone;
    }
}
