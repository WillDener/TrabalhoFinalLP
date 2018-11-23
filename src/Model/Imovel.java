package Model;

import java.util.List;

public class Imovel extends Produto {

    private Endereco endereco;
    private TipoImovel tipo;
    private int anoConstrucao;
    private double preco;

    public enum TipoImovel{
        APARTAMENTO,
        TERRENO,
        CASA,
        EDIFICIO;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public TipoImovel getTipo() {
        return tipo;
    }

    public void setTipo(TipoImovel tipo) {
        this.tipo = tipo;
    }

    public int getAnoConstrucao() {
        return anoConstrucao;
    }

    public void setAnoConstrucao(int anoConstrucao) {
        this.anoConstrucao = anoConstrucao;
    }

    public Endereco getEndereco() { return endereco; }

    public void setEndereco(Endereco endereco) { this.endereco = endereco; }

    public Imovel(String documento, String nome, String descricao, Leilao leilao, List<Lance> lances, Endereco endereco, TipoImovel tipo, int anoConstrucao, double preco) {
        super(documento, nome, descricao, leilao, lances);
        this.endereco = endereco;
        this.tipo = tipo;
        this.anoConstrucao = anoConstrucao;
        this.preco = preco;
    }

    public String toStringImovel(){
        return toStringProduto()+endereco.ImprimirEndereco()+"\nTipo: "+tipo+"\nAno Construcao: "+anoConstrucao;
    }
}
