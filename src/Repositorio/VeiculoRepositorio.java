package Repositorio;

import Model.Veiculo;

import java.util.ArrayList;
import java.util.List;

public class VeiculoRepositorio {

    private List<Veiculo> veiculos = new ArrayList<>();

    public void AdicionarVeiculo(Veiculo veiculo){
        veiculos.add(veiculo);
    }

    public void ListarVeiculosPorTipoCarro() {
        for (Veiculo aux : veiculos) {
            if (aux.getPlaca().equals(Veiculo.TipoCarro.CARRO) ) {
                aux.toStringVeiculo();
            }
        }
    }

    public void ListarVeiculosPorTipoMoto() {
        for (Veiculo aux : veiculos) {
            if (aux.getPlaca().equals(Veiculo.TipoCarro.MOTOCICLETA) ) {
                aux.toStringVeiculo();
            }
        }
    }

    public Veiculo buscarPorDocumentoVeiculo(String veiculo){
        for (Veiculo veiculo1:veiculos){
            if (veiculo1.equals(veiculo)){
                return veiculo1;
            }
        }
        return null;
    }

    public void AlteracaoDeRegistro (String documento,String tipo, String placa, int ano){
        Veiculo aux = buscarPorDocumentoVeiculo(documento);
        aux.setTipo(Veiculo.TipoCarro.valueOf(tipo));
        aux.setAnoLancamento(ano);
        aux.setPlaca(placa);
    }

    public void RemocaoDeVeiculoPorDocumento (String documento){
        for (Veiculo veiculo:veiculos){
            if (veiculo.getDocumento().equals(documento)){
                veiculos.remove(veiculo);
            }
        }
    }

    public String ApresentacaoListaDeVeiculos(){
        Veiculo temp;
        for (int i=0; i < veiculos.size(); i++){
            for (int j=i+1; j<= veiculos.size();j++){
                if (veiculos.get(i).getNome().compareTo(veiculos.get(j).getNome()) < 1 ){
                    temp = veiculos.get(i);
                    veiculos.get(i).equals(veiculos.get(j));
                    veiculos.get(j).equals(temp);
                }
            }
        }
        for (Veiculo veiculo: veiculos){
            return "\nNome: "+veiculo.getNome()+"\nInstituicao responsavel pelo leilao: "+veiculo.getLeilao().getInst()
                    +"\nQuantidade de Produtos: "+ veiculo.getLeilao().getProdutos().size()
                    +"\nDados Leiloes"+"\nData: "+veiculo.getLeilao().getDataInicio().imprimirData()+
                    "\nEndereco: "+veiculo.getLeilao().getEndereco().ImprimirEndereco()+
                    "\nStatus Leilao: "+veiculo.getLeilao().getStatus()+
                    "\nDados Produto: "+veiculo.toStringProduto()+
                    "\nDados Veiculo: "+veiculo.toStringVeiculo();
        }
        return null;
    }

    public Veiculo FiltroPorPreco (double min, double max){
        for (Veiculo veiculo: veiculos){
            if (veiculo.getPreco() >= min && veiculo.getPreco() <= max){
                return veiculo;
            }
        }
        return null;
    }

    public String BuscaPorDescricao(String descricao){
        for (Veiculo veiculo: veiculos){
            if (veiculo.getDescricao().equals(descricao)){
                return veiculo.toStringVeiculo();
            }
        }
        return null;
    }



}
