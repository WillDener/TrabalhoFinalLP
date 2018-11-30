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

    public Veiculo buscarPorDocumentoVeiculo(String documento){
        for (Veiculo veiculo:veiculos){
            if (veiculo.getDocumento().equals(documento)){
                return veiculo;
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

    public void ApresentacaoListaDeVeiculos(){
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
        for (Veiculo veiculo: veiculos) {
            System.out.println("\nNome: ");
            veiculo.getNome();
            System.out.println("\nInstituicao responsavel pelo leilao: ");
            veiculo.getLeilao().getInst().toStringInstituicao();
            System.out.println("\nQuantidade de Produtos:\n ");
            System.out.println("Quantidade de Imoveis: " + veiculo.getLeilao().getImovels().size() +
                    "\nQuantidade de Veiculos: " + veiculo.getLeilao().getVeiculos().size());
            System.out.println("\nDados Leiloes" + "\nData: ");
            veiculo.getLeilao().getDataInicio().imprimirData();
            System.out.println("\nEndereco: ");
            veiculo.getLeilao().getEndereco().ImprimirEndereco();
            System.out.println("\nStatus Leilao: " + veiculo.getLeilao().getStatus());
            System.out.println("\nDados Produto: ");
            veiculo.toStringProduto();
            System.out.println("\nDados Veiculo: ");
            veiculo.toStringVeiculo();
        }
    }

    public Veiculo FiltroPorPreco (double min, double max){
        for (Veiculo veiculo: veiculos){
            if (veiculo.getPreco() >= min && veiculo.getPreco() <= max){
                return veiculo;
            }
        }
        return null;
    }

    public void BuscaPorDescricao(String descricao){
        for (Veiculo veiculo: veiculos){
            if (veiculo.getDescricao().equals(descricao)){
                veiculo.toStringVeiculo();
            }
        }
    }
}
