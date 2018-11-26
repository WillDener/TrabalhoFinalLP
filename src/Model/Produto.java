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

    public String ListarLancesProduto(){
        for (Lance lance:lances){
            if (lance.getProduto().getDocumento().equals(documento)){
                return lance.toStringLance();
            }
        }
        return null;
    }

    public double calcularLances(){
        double cont= 0.0;
        for (Lance lance:lances){
            cont = cont + lance.getValor();
        }
        return cont;
    }

    public String toStringProduto() {
        return "\nNome: "+nome+"\nDocumento: "+documento+"\nDescricao: "+descricao+"\nLeilao: "+leilao+"\nLances feito:\n"+ListarLancesProduto();
    }

    public Lance GanhadorImovel (Imovel imovel){
        Lance maiorLance = new Lance();
        for (Lance lance:imovel.getLances()){
            if (lance.getValor() > maiorLance.getValor()){
                maiorLance.equals(lance);
            }
        }
        return maiorLance;
    }

    public Lance GanhadorVeiculo (Veiculo veiculo){
        Lance maiorLance = new Lance();
        for (Lance lance:veiculo.getLances()){
            if (lance.getValor() > maiorLance.getValor()){
                maiorLance.equals(lance);
            }
        }
        return maiorLance;
    }

    public Produto(){}
}
