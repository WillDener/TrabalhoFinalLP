package Repositorio;

import Model.Data;
import Model.Leilao;
import Model.Produto;

import java.util.ArrayList;
import java.util.List;

public class LeiloesRepositorio {

    private List<Leilao> leilaos = new ArrayList<>();

    public String ListarTodosLeiloes(){
        for (Leilao leilao: leilaos){
            return leilao.toStringLeilao();
        }
        return null;
    }

    public Leilao Consultar(int dia,int mes, int ano){
        for (Leilao leilao: leilaos){
            if (leilao.getDataInicio().getDia() == dia &&leilao.getDataInicio().getMes() == mes &&leilao.getDataInicio().getAno() == ano){
                return leilao;
            }
        }
        return null;
    }

    public void AdicionarLeilao (Leilao leilao){
        leilaos.add(leilao);
    }

    public void RemoverLeilaoPorData(int dia,int mes, int ano){
        Leilao aux = Consultar(dia,mes,ano);
        leilaos.remove(aux);
    }

    public String  CalcularFatura(){
        double aux = 0.0;
        for (Leilao leilao: leilaos){
            if (leilao.getStatus().equals(Leilao.StatusLeilao.FINALIZADO)){
                aux = leilao.calcularFatura();
                return leilao.toStringLeilao()+"n\nLeilao rendeu de fattura: "+aux;
            }
            aux =0;
        }
        return null;
    }

    public String VerificacaoInstituicao() {
        for (Leilao leilao : leilaos) {
            return "\nInstituiçao vinculada com o leilao: " + leilao.getInst()
                    + "\nLeilao da Data: " + leilao.getDataInicio().imprimirData();
        }
        return null;
    }

    public void OrdenacaoLista() {
        Leilao temp;
        for (int i=0; i < leilaos.size()-1;i++){
            if(leilaos.get(i).equals(leilaos.get(i).getDataInicio().Comparar(leilaos.get(i).getDataInicio(),leilaos.get(i+1).getDataInicio()))){
                temp = leilaos.get(i);
                leilaos.get(i+1).equals(leilaos.get(i));
                leilaos.get(i).equals(temp);
            }
        }
    }

    public void SetarStatusPorDataAtual(Data dataAtual){
        for (Leilao leilao:leilaos){
            if (dataAtual == leilao.getDataInicio().Comparar(leilao.getDataInicio(),dataAtual) &&
            dataAtual != leilao.getDataTermino().Comparar(leilao.getDataTermino(),dataAtual)){
                leilao.setStatus(Leilao.StatusLeilao.ANDAMENTO);
            }
            if (dataAtual != leilao.getDataInicio().Comparar(leilao.getDataInicio(),dataAtual) &&
                    dataAtual != leilao.getDataTermino().Comparar(leilao.getDataTermino(),dataAtual)){
                leilao.setStatus(Leilao.StatusLeilao.ABERTO);
            }
            if (dataAtual == leilao.getDataInicio().Comparar(leilao.getDataInicio(),dataAtual) &&
                    dataAtual == leilao.getDataTermino().Comparar(leilao.getDataTermino(),dataAtual)){
                leilao.setStatus(Leilao.StatusLeilao.FINALIZADO);
            }
        }
    }

    public String ApresentacaoLeilao (Data dataAtual, String status){
        //SetarStatusPorDataAtual(dataAtual);
        for (Leilao leilao:leilaos){
            if (leilao.getStatus().equals(status)&& status.equals(Leilao.StatusLeilao.ABERTO)){
                leilao.toStringLeilao();
                for (Produto produto:leilao.getProdutos()) {
                    return produto.toStringProduto()+"\nGanhador: "+"N/A";
                }
            }
            if (leilao.getStatus().equals(status)&& status.equals(Leilao.StatusLeilao.FINALIZADO)){
                leilao.toStringLeilao();
                for (Produto produto:leilao.getProdutos()){
                    return produto.toStringProduto() + produto.Ganhador().toStringLance();
                }
            }
            if (leilao.getStatus().equals(status)&& status.equals(Leilao.StatusLeilao.ANDAMENTO)){
                leilao.toStringLeilao();
                for (Produto produto: leilao.getProdutos()){
                    return produto.toStringProduto()+"\nGanhador: "+"N/A";
                }
            }
        }
        return null;
    }



}
