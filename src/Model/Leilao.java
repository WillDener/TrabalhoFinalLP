package Model;

import java.util.List;

public class Leilao {

    private Instituicao inst;
    private List<Veiculo> veiculos;
    private List<Imovel> imovels;
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

    public List<Veiculo> getVeiculos() {
        return veiculos;
    }

    public void setVeiculos(List<Veiculo> veiculos) {
        this.veiculos = veiculos;
    }

    public List<Imovel> getImovels() {
        return imovels;
    }

    public void setImovels(List<Imovel> imovels) {
        this.imovels = imovels;
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

    public Leilao(Instituicao inst, List<Veiculo> veiculos,List<Imovel> imovels, Data dataInicio,Data dataTermino, Endereco endereco,Data dataAtual) {
        this.inst = inst;
        this.veiculos = veiculos;
        this.imovels = imovels;
        this.dataInicio = dataInicio;
        this.dataTermino = dataTermino;
        this.endereco = endereco;
        this.status = setarStatus(dataAtual);
    }

    public String toStringLeilao(){
        return inst.toStringInstituicao()+endereco.ImprimirEndereco()+"\nData Inicio:"+ dataInicio.imprimirData()+
                "Data Termino:"+dataTermino.imprimirData()+"\nStatus: "+status+ListarImovelsDoLeilao()+ListarVeiculosDoLeilao();
    }

    public String ListarVeiculosDoLeilao (){
        for (Veiculo veiculo:veiculos){
            veiculo.toStringVeiculo();
        }
        return null;
    }


    public String ListarImovelsDoLeilao (){
        for (Imovel imovel:imovels){
            imovel.toStringImovel();
        }
        return null;
    }

    public double calcularFatura(Leilao leilao){
        double cont = 0.0;
        if (leilao.equals(StatusLeilao.FINALIZADO))
            for (Imovel imovel:leilao.imovels){ cont = cont + imovel.GanhadorImovel(imovel).getValor(); }
            for (Veiculo veiculo:leilao.veiculos) {cont = cont + veiculo.GanhadorVeiculo(veiculo).getValor();}
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

