package Model;

import java.util.List;

public class Produto {
    private String documento;
    private String nome;
    private String descricao;
    private Leilao leilao;
    private List<Lance> lances;

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Leilao getLeilao() {
        return leilao;
    }

    public void setLeilao(Leilao leilao) {
        this.leilao = leilao;
    }

    public List<Lance> getLances() {
        return lances;
    }

    public void setLances(List<Lance> lances) {
        this.lances = lances;
    }

    public Produto(String documento, String nome, String descricao, Leilao leilao, List<Lance> lances) {
        this.documento = documento;
        this.nome = nome;
        this.descricao = descricao;
        this.leilao = leilao;
        this.lances = lances;
    }

    public void ListarLancesProduto(){
        for (Lance lance:lances){
            lance.toStringLance();
        }
    }

    public double calcularLances(){
        double cont= 0.0;
        for (Lance lance:lances){
            cont = cont + lance.getValor();
        }
        return cont;
    }

    public void toStringProduto() {
        System.out.println("\nNome: "+nome+"\nDocumento: "+documento+"\nDescricao: "+descricao+"\nLances feito:\n");
        ListarLancesProduto();
    }

    public double GanhadorImovel (Imovel imovel){
        double valor = 0.0;
        for (Lance lance:imovel.getLances()){
            if (lance.getValor() > valor){
                valor = lance.getValor();
            }
        }
        return valor;
    }

    public double GanhadorVeiculo (Veiculo veiculo){
        double valor = 0.0;
        for (Lance lance:veiculo.getLances()){
            if (lance.getValor() > valor){
                valor = lance.getValor();
            }
        }
        return valor;
    }

    public Produto(){}
}
