package Repositorio;

import Model.Endereco;
import Model.Imovel;

import java.util.ArrayList;
import java.util.List;

public class ImovelRepositorio {

    private List<Imovel> imovels = new ArrayList<>();

    public void AdicionarRegistro(Imovel imovel){
        if (imovel.getLeilao() != null) imovels.add(imovel);
        else System.out.println("Falta de associaçao ao respectivo leilao");
    }

    public String ListarTodosImoveis(){
        for (Imovel imovel:imovels){ return imovel.toStringImovel(); }
        return null;
    }

    public Imovel ConsultarPorDoc (String documento){
        for (Imovel imovel: imovels){
            if (imovel.getDocumento().equals(documento)){
                return imovel;
            }
        }
        return null;
    }

    public Imovel ConsultarPorTipo (String tipo){
        for (Imovel imovel: imovels){
            if (imovel.getTipo().equals(Imovel.TipoImovel.valueOf(tipo))){
                return imovel;
            }
        }
        return null;
    }

    public Imovel AlteracaoDeImovel(String documento,String endereco,String cidade, String estado,String cep,String tipo,int ano){
        for (Imovel imovel:imovels){
            if (imovel.getDocumento().equals(documento)){
                imovel.setAnoConstrucao(ano);
                imovel.setEndereco(new Endereco(endereco,cidade,estado,cep));
                imovel.setTipo(Imovel.TipoImovel.valueOf(tipo));
                return imovel;
            }
        }
        return null;
    }

    public void RemoverimovelPorDoc(String doc){
        Imovel aux = ConsultarPorDoc(doc);
        imovels.remove(aux);
    }
    public String ApresentacaoListaDeImovel(){
        Imovel aux;
        for (int k=0; k < imovels.size(); k++){
            for (int j=k+1; j<= imovels.size();j++)
                if (imovels.get(k).getNome().compareTo(imovels.get(j).getNome()) < 1) {
                    aux = imovels.get(k);
                    imovels.get(k).equals(imovels.get(j));
                    imovels.get(j).equals(aux);
                }
        }
        for (Imovel imovel: imovels){
            return "\nNome: "+imovel.getNome()+"\nInstituicao responsavel pelo leilao: "+imovel.getLeilao().getInst()
                    +"\nQuantidade de Produtos:\n "+
                    "Quantidade de Imoveis: "+ imovel.getLeilao().getImovels().size()+
                    "\nQuantidade de Veiculos: "+imovel.getLeilao().getVeiculos().size()
                    +"\nDados Leiloes"+"\nData: "+imovel.getLeilao().getDataInicio().imprimirData()+
                    "\nEndereco: "+imovel.getLeilao().getEndereco().ImprimirEndereco()+
                    "\nStatus Leilao: "+imovel.getLeilao().getStatus()+
                    "\nDados Produto: "+imovel.toStringProduto()+
                    "\nDados Veiculo: "+imovel.toStringImovel();
        }
        return null;
    }

    public Imovel FiltroPreco(double min, double max){
        for (Imovel imovel: imovels){
            if (imovel.getPreco() >= min && imovel.getPreco()<=max){
                return imovel;
            }
        }
        return null;
    }

    public String BuscaPorDescricao (String descricao){
        for (Imovel imovel:imovels){
            if (imovel.getDescricao().equals(descricao)){
                return imovel.toStringImovel();
            }
        }
        return null;
    }

}
