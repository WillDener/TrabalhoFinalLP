package Repositorio;

import Model.Instituicao;
import Model.Leilao;

import java.util.ArrayList;
import java.util.List;

public class InstituicaoRepositorio {

    private List<Instituicao> instituicaos = new ArrayList<>();

    public void AdicionarInstituicao (Instituicao instituicao){ instituicaos.add(instituicao); }

    public Instituicao Consultainstituicao (String cnpj){
        for (Instituicao instituicao:instituicaos){
            if (instituicao.getCnpj().equals(cnpj)){
                return instituicao;
            }
        }
        return null;
    }

    public void AtualizacaoRegistro (String nome, String cnpj, String newcnpj){
        for (Instituicao instituicao:instituicaos){
            if (instituicao.getCnpj().equals(cnpj)){
                instituicao.setCnpj(newcnpj);
                instituicao.setNome(nome);
            }
        }
    }

    public void removerInstituicao (String cnpj){
        Instituicao aux = Consultainstituicao(cnpj);
        instituicaos.remove(aux);
    }
}
