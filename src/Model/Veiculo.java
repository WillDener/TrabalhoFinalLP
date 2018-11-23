package Model;

import java.util.List;

public class Veiculo extends Produto {
    private TipoCarro tipo;
    private String placa;
    private int anoLancamento;
    private double preco;

    public enum TipoCarro{
        CARRO,
        MOTOCICLETA;
    }

    public TipoCarro getTipo() {
        return tipo;
    }

    public void setTipo(TipoCarro tipo) {
        this.tipo = tipo;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public int getAnoLancamento() {
        return anoLancamento;
    }

    public void setAnoLancamento(int anoLancamento) {
        this.anoLancamento = anoLancamento;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public Veiculo(String documento, String nome, String descricao, Leilao leilao, List<Lance> lances, TipoCarro tipo, String placa, int anoLancamento, double preco) {
        super(documento, nome, descricao, leilao, lances);
        this.tipo = tipo;
        this.placa = placa;
        this.anoLancamento = anoLancamento;
        this.preco = preco;
    }

    public String toStringVeiculo() {
        return toStringProduto()+"\nTipo: "+tipo+"\nPlaca: "+placa+"\nAno: "+anoLancamento;
    }
}
