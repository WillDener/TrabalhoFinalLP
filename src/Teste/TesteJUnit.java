package Teste;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import Model.Cliente;
import Model.Data;
import Model.Endereco;
import Model.Imovel;
import Model.Imovel.TipoImovel;
import Model.Instituicao;
import Model.Lance;
import Model.Leilao;
import Model.Veiculo;
import Model.Veiculo.TipoCarro;

public class TesteJUnit {

    List<Imovel> imovels= new ArrayList<>();
    List<Veiculo> veiculos= new ArrayList<>();

    List<Lance> lances1 = new ArrayList<>();
    List<Lance> lances2 = new ArrayList<>();

    List<Lance> lances3 = new ArrayList<>();
    List<Lance> lances4 = new ArrayList<>();

    Cliente cliente1 = new Cliente("Mateus", "14725836910", "elfocus", "asda1234");
    List<Cliente> clientes = new ArrayList<Cliente>();

    Endereco enderecoImovel1 = new Endereco("Rua dos Furtadores, 157", "Atibaia", "Sao Paulo", "122355480");
    Endereco enderecoImovel2 = new Endereco("Rua dos Corruptores, 157", "Brasilia", "Sao Paulo", "122388790");

    Instituicao instituicao1 = new Instituicao("Instituto Neoliberal", "93520027000196");
    Instituicao instituicao2 = new Instituicao("Instituto Conservador", "73758166000145");

    Endereco enderecoLeilao1 = new Endereco("Rua das Acacias, 123", "Sao Jose dos Campos", "Sao Paulo", "122333470");
    Endereco enderecoLeilao2 = new Endereco("Rua dos Diamantes, 456", "Jacarei", "Sao Paulo", "122344590");

    Data dataInicioLeilao1 = new Data(13, 12, 2018, 18, 00);
    Data dataTerminoLeilao1 = new Data(13, 02, 2019, 18, 00);
    Data dataAtualLeilao1 = new Data(13, 01, 2018, 18, 00);
    Leilao leilao1 = new Leilao(instituicao1,veiculos ,imovels, dataInicioLeilao1, dataTerminoLeilao1, enderecoLeilao1, dataAtualLeilao1);

    Data dataInicioLeilao2 = new Data(01, 10, 2018, 19, 00);
    Data dataTerminoLeilao2 = new Data(01, 12, 2018, 19, 00);
    Data dataAtualLeilao2 = new Data(13, 12, 2018, 19, 00);
    Leilao leilao2 = new Leilao(instituicao2, veiculos,imovels, dataInicioLeilao2, dataTerminoLeilao2, enderecoLeilao2, dataAtualLeilao2);

    Imovel sitioDolula = new Imovel("157248", "Sitio MTST", "Sitio do ex-presidente e presidiario LILdS", leilao1, lances1, enderecoImovel1, TipoImovel.TERRENO, 1995, 2800000.00);
    Imovel triplexDoLula = new Imovel("456123", "Triplex MTST", "Apartamento do ex-presidente e presidiario LILdS", leilao2, lances2, enderecoImovel2, TipoImovel.APARTAMENTO, 2000, 1800000.00);

    Veiculo carroDoSenna = new Veiculo("147258", "Carro Senna", "Carro ex-corredor Senna", leilao1, lances3, TipoCarro.CARRO, "XPTO-4455", 1970, 4500000.00);
    Veiculo motoSerra = new Veiculo("123789", "Moto do Jose Serra", "Moto do comedor Jose Serra", leilao2, lances4, TipoCarro.MOTOCICLETA, "XYZ-0157", 1999, 4500.00);

    @Test
    public void getNome() {
        Assert.assertEquals("Mateus", cliente1.getNome());
    }

    @Test
    public void setNome() {
        cliente1.setNome("Lennon");
        Assert.assertEquals("Lennon", cliente1.getNome());
    }

    @Test
    public void getCpf() {
        Assert.assertEquals("14725836910", cliente1.getCpf());
    }

    @Test
    public void setCpf() {
        cliente1.setCpf("12378945620");
        Assert.assertEquals("12378945620", cliente1.getCpf());
    }

    @Test
    public void getLogin() {
        Assert.assertEquals("elfocus", cliente1.getLogin());
    }

    @Test
    public void setLogin() {
        cliente1.setLogin("lennon");
        Assert.assertEquals("lennon", cliente1.getLogin());
    }

    @Test
    public void getSenha() {
        Assert.assertEquals("asda1234", cliente1.getSenha());
    }

    @Test
    public void setSenha() {
        cliente1.setSenha("mts123");
        Assert.assertEquals("mts123", cliente1.getSenha());
    }

    @Test
    public void ClienteConstruct() {
        Cliente cliente2 = new Cliente("Willian", "12345678910", "wdener", "123321");
        clientes.add(cliente2);
        Assert.assertEquals(1, clientes.size());
    }

    @Test
    public void EmptyClienteConstruct() {
        Cliente clienteVazio = new Cliente();
        clientes.add(clienteVazio);
        Assert.assertEquals(1, clientes.size());
    }

    /*@Test
    public void LeilaoConstruct (){
        List<Produto> produtos = new ArrayList<Produto>();
        Leilao leilao = new Leilao(new Instituicao("Hospital", 2018),
                produtos, new Data(13, 12, 1995, 19, 30),
                new Data(23, 11, 2018, 22, 30), );
        Assert.assertEquals(leilao, null);
    }*/
}
