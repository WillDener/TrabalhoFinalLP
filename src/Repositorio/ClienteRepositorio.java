package Repositorio;

import Model.Cliente;

import java.util.ArrayList;
import java.util.List;

public class ClienteRepositorio {

    private List<Cliente> clientes = new ArrayList<>();

    public void AdiconarCliente (Cliente cliente){ clientes.add(cliente);}

    public String ListarClientescadastrados(){
        for (Cliente cliente: clientes){
            return cliente.toStringClienteLance();
        }
        return null;
    }

    public Cliente Consultar (String login, String senha){
        for (Cliente cliente:clientes){
            if(cliente.getLogin().equals(login) && cliente.getSenha().equals(senha)){
                return cliente;
            }
        }
        return null;
    }

    public void AtualizarCliente(String nome, String cpf, String login, String senha, String newlogin, String newsenha){
        for (Cliente cliente:clientes){
            if (cliente.getSenha().equals(senha) && cliente.getLogin().equals(login)){
                cliente.setCpf(cpf);
                cliente.setLogin(newlogin);
                cliente.setSenha(newsenha);
                cliente.setNome(nome);
            }
        }
    }

    public void RemoverCliente (String login, String senha){
        Cliente aux = Consultar(login,senha);
        clientes.remove(aux);
    }
}
