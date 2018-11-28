package Teste;
import java.util.ArrayList;
import java.util.List;

import Repositorio.LeiloesRepositorio;
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

public class TesteJUnitLeilao {

    List<Veiculo> veiculoList = new ArrayList<>();
    List<Imovel> imovelList = new ArrayList<>();
    List<Lance>lanceList = new ArrayList<>();

    Leilao leilaotest = new Leilao(new Instituicao("Hospital","1234566"),veiculoList,imovelList,
            new Data(21,03,2017,14,30),new Data(30,03,2017,14,30),
            new Endereco("Prof TErezinha","SJC","SP","1234"),
            new Data(22,03,2017,14,30));
    Leilao leilaotest2 = new Leilao(new Instituicao("Shopping","1234"),veiculoList,imovelList,
            new Data(21,03,2017,14,30),new Data(30,03,2017,14,30),
            new Endereco("Madruva","SJC","SP","12345"),
            new Data(22,01,2017,14,30));
    Leilao leilaotest3 = new Leilao(new Instituicao("Mercado","1234567"),veiculoList,imovelList,
            new Data(21,03,2017,14,30),new Data(30,03,2017,14,30),
            new Endereco("Manguaba","SJC","SP","123456"),
            new Data(22,04,2017,14,30));

    Imovel CasaPraia = new Imovel("12345","Casa da Praia","Frente ao Mar",leilaotest3,
            lanceList,new Endereco("MArtin de Sá","Guaraguatatuba","SP","1234567"),TipoImovel.CASA,
            2018,100000.00);
    Imovel Sitio = new Imovel("456123", "Sitio", "SitioTop", leilaotest3, lanceList,
            new Endereco("Guararema","I dont know","SP","212112"), TipoImovel.CASA, 2000, 250000.00);

    Veiculo carroDoSenna = new Veiculo("147258", "Carro Senna", "Carro ex-corredor Senna", leilaotest3, lanceList, TipoCarro.CARRO, "XPTO-4455", 1970, 4500000.00);
    Veiculo motoSerra = new Veiculo("123789", "Moto do Jose Serra", "Moto do comedor Jose Serra", leilaotest3, lanceList, TipoCarro.MOTOCICLETA, "XYZ-0157", 1999, 4500.00);

    Cliente will = new Cliente("willian","123456","wdener8","asdasd");
    Cliente will2 = new Cliente("william","1234567","wdener8@","asdasda");
    Lance lance1 = new Lance(12500.00,CasaPraia,will,new Data(25,03,2017,14,30));
    List<Leilao>leilaoList = new ArrayList<>();
    LeiloesRepositorio leiloesRepositorio = new LeiloesRepositorio();
    @Test
    public void LeilaoConstruct (){
        leilaoList.add(leilaotest);
        leilaoList.add(leilaotest2);
        leilaoList.add(leilaotest3);
        Assert.assertEquals(3,leilaoList.size());
    }

    @Test
    public void LeilaoGetStatusAndamento (){
        leilaoList.add(leilaotest);
        Assert.assertEquals(Leilao.StatusLeilao.ANDAMENTO,leilaoList.get(0).getStatus());
    }

    @Test
    public void LeilaoGetStatusAberto(){
        leilaoList.add(leilaotest2);
        Assert.assertEquals(Leilao.StatusLeilao.ABERTO,leilaoList.get(0).getStatus());
    }

    @Test
    public void LeilaoGetStatusFechado(){
        leilaoList.add(leilaotest3);
        Assert.assertEquals(Leilao.StatusLeilao.FINALIZADO,leilaoList.get(0).getStatus());
    }

    @Test
    public void LeilaoGetInstituicao(){
        leilaoList.add(leilaotest3);
        Assert.assertEquals("Mercado",leilaotest3.getInst().getNome());
        Assert.assertEquals("1234567",leilaotest3.getInst().getCnpj());
    }

    @Test
    public void LeilaoGetDataInicio (){
        leilaoList.add(leilaotest3);
        Assert.assertEquals(21,leilaoList.get(0).getDataInicio().getDia());
        Assert.assertEquals(03,leilaoList.get(0).getDataInicio().getMes());
        Assert.assertEquals(2017,leilaoList.get(0).getDataInicio().getAno());
        Assert.assertEquals(14,leilaoList.get(0).getDataInicio().getHora());
        Assert.assertEquals(30,leilaoList.get(0).getDataInicio().getMinuto());
    }

    @Test
    public void LeilaoGetDataTermino(){
        leilaoList.add(leilaotest3);
        Assert.assertEquals(30,leilaoList.get(0).getDataTermino().getDia());
        Assert.assertEquals(03,leilaoList.get(0).getDataTermino().getMes());
        Assert.assertEquals(2017,leilaoList.get(0).getDataTermino().getAno());
        Assert.assertEquals(14,leilaoList.get(0).getDataTermino().getHora());
        Assert.assertEquals(30,leilaoList.get(0).getDataTermino().getMinuto());
    }

    @Test
    public void LeilaoEndereco (){
        leilaoList.add(leilaotest3);
        Assert.assertEquals("Manguaba",leilaoList.get(0).getEndereco().getEnderecoCompleto());
        Assert.assertEquals("SJC",leilaoList.get(0).getEndereco().getCidade());
        Assert.assertEquals("SP",leilaoList.get(0).getEndereco().getEstado());
        Assert.assertEquals("123456",leilaoList.get(0).getEndereco().getCep());
    }

    @Test
    public void CalcularFatura(){
        leilaoList.add(leilaotest3);
        imovelList.add(CasaPraia);
        lanceList.add(lance1);
        Assert.assertEquals(12500.00,leilaotest3.getImovels().get(0).getLances().get(0).getValor(),0.0);
        Assert.assertEquals(12500.00,leilaoList.get(0).calcularFatura(leilaotest3),0.0);
    }

    @Test
    public void RepositorioLeilao(){
        leiloesRepositorio.AdicionarLeilao(leilaotest3);
        Assert.assertEquals(1,leiloesRepositorio.ListarRepositorioLista().size());
        leiloesRepositorio.RemoverLeilaoPorData(new Data(21,03,2017,14,30));
        Assert.assertEquals(0,leiloesRepositorio.ListarRepositorioLista().size());
        leiloesRepositorio.AdicionarLeilao(leilaotest3);
        imovelList.add(CasaPraia);
        lanceList.add(lance1);
        veiculoList.add(motoSerra);
        Assert.assertEquals(12500.0,leiloesRepositorio.CalcularFatura(new Data(21,03,2017,14,30)),0.0);
        //leiloesRepositorio.ApresentacaoLeilao();
        veiculoList.add(carroDoSenna);
        leiloesRepositorio.AdicionarLeilao(leilaotest2);
        leiloesRepositorio.AdicionarLeilao(leilaotest);
        leiloesRepositorio.OrdenacaoLista();
        leiloesRepositorio.ApresentacaoLeilao();
    }
}
