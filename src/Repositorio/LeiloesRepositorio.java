package Repositorio;

import Model.*;

import java.util.ArrayList;
import java.util.List;

public class LeiloesRepositorio {

    private List<Leilao> leilaos = new ArrayList<>();

    public void ListarTodosLeiloes(){
        for (Leilao leilao: leilaos){
            leilao.toStringLeilao();
        }
    }

    public Leilao ConsultarDataInicio(Data data){
        for (Leilao leilao: leilaos){
            if (leilao.getDataInicio().getDia() == data.getDia()
                    &&leilao.getDataInicio().getMes() == data.getMes()&&
                    leilao.getDataInicio().getAno() == data.getAno() &&
            leilao.getDataInicio().getHora() == data.getHora() && leilao.getDataInicio().getMinuto() == data.getMinuto() ){
                return leilao;
            }
        }
        return null;
    }

    public void AdicionarLeilao (Leilao leilao){
        leilaos.add(leilao);
    }

    public void RemoverLeilaoPorData(Data data){
        Leilao aux = ConsultarDataInicio(data);
        leilaos.remove(aux);
    }
    public List<Leilao> ListarRepositorioLista(){
        return leilaos;
    }

    public double CalcularFatura(Data data){
        Leilao leilao = ConsultarDataInicio(data);
        double aux = 0.0;
        if (leilao.getStatus().equals(Leilao.StatusLeilao.FINALIZADO)){
            aux = leilao.calcularFatura(leilao);
        }
        return aux;
    }

    public void VerificacaoInstituicao() {
        for (Leilao leilao : leilaos) {
            System.out.println("\nInstituiçao vinculada com o leilao: ");
            leilao.getInst().toStringInstituicao();
            System.out.println("\nLeilao da Data: "); leilao.getDataInicio().imprimirData();
        }
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

    public void ApresentacaoLeilao (){
        for (Leilao leilao:leilaos){
            leilao.toStringLeilao();
        }
    }

}
