package Model;

public class Instituicao {
    private String nome;
    private int cnpj;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCnpj() {
        return cnpj;
    }

    public void setCnpj(int cnpj) {
        this.cnpj = cnpj;
    }

    public Instituicao(String nome, int cnpj) {
        this.nome = nome;
        this.cnpj = cnpj;
    }

    public String toStringInstituicao(){
        return "\nNome Instituicao: "+nome+"\nCNPJ: "+cnpj;
    }
}
