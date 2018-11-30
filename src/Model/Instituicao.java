package Model;

public class Instituicao {
    private String nome;
    private String cnpj;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public Instituicao(String nome, String cnpj) {
        this.nome = nome;
        this.cnpj = cnpj;
    }

    public void toStringInstituicao(){
        System.out.println("\nNome Instituicao: "+nome+"\nCNPJ: "+cnpj);
    }

    public Instituicao(){
    }
}
