package Model;

import java.util.List;

public class Leilao {

    private Instituicao inst;
    private List<Produto> produtos;
    private Data dataInicio;
    private Data dataTermino;
    private Endereco endereco;
    private StatusLeilao status;

    public enum StatusLeilao {
        ABERTO,
        ANDAMENTO,
        FINALIZADO;
    }

    public Instituicao getInst() {
        return inst;
    }

    public void setInst(Instituicao inst) {
        this.inst = inst;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }

    public Data getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(Data dataInicio) {
        this.dataInicio = dataInicio;
    }

    public Data getDataTermino() {
        return dataTermino;
    }

    public void setDataTermino(Data dataTermino) {
        this.dataTermino = dataTermino;
    }

    public StatusLeilao getStatus() {
        return status;
    }

    public void setStatus(StatusLeilao status) {
        this.status = status;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public Leilao(Instituicao inst, List<Produto> produtos, Data dataInicio,Data dataTermino, Endereco endereco,StatusLeilao status,Data dataAtual) {
        this.inst = inst;
        this.produtos = produtos;
        this.dataInicio = dataInicio;
        this.dataTermino = dataTermino;
        this.endereco = endereco;
        this.status = setarStatus(dataAtual);
    }

    public String toStringLeilao(){
        return inst.toStringInstituicao()+endereco.ImprimirEndereco()+"\nData Inicio:"+ dataInicio.imprimirData()+
                "Data Termino:"+dataTermino.imprimirData()+"\nStatus: "+status+ListarProdutosDoLeilao();
    }

    public String ListarProdutosDoLeilao (){
        for (Produto produto:produtos){
            produto.toStringProduto();
        }
        return null;
    }

    public double calcularFatura(){
        double cont = 0.0;
        for (Produto produto:produtos){
            cont = cont + produto.calcularLances();
        }
        return cont;
    }

    public StatusLeilao setarStatus(Data data){
        if (data == dataInicio.Comparar(data,dataInicio)&&
                data != dataTermino.Comparar(dataTermino,data)){
            return Leilao.StatusLeilao.ANDAMENTO;
        }
        if (data != dataInicio.Comparar(dataInicio,data) &&
                data != dataTermino.Comparar(dataTermino,data)){
            return Leilao.StatusLeilao.ABERTO;
        }
        if (data == dataInicio.Comparar(dataInicio,data) &&
                data == dataTermino.Comparar(dataTermino,data)){
            return Leilao.StatusLeilao.FINALIZADO;
        }
        return null;
    }

    public Leilao(){ }
}

