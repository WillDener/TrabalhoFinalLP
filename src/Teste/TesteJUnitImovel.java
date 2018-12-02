package Teste;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import Model.Data;
import Model.Endereco;
import Model.Imovel;
import Model.Instituicao;
import Model.Lance;
import Model.Leilao;
import Model.Veiculo;

public class TesteJUnitImovel {
	
    List<Veiculo> veiculos = new ArrayList<>();
    List<Imovel> imoveis = new ArrayList<>();
    List<Lance> lances = new ArrayList<>();
    Endereco endereco = new Endereco("Prof Terezinha", "SJC", "SP", "1234");
	Leilao leilao = new Leilao(new Instituicao("Hospital", "1234566"), veiculos, imoveis,
            new Data(21, 03, 2017, 14, 30), new Data(30, 03, 2017, 14, 30),
            new Endereco("Prof Terezinha", "SJC", "SP", "1234"),
            new Data(22,03,2017,14,30));
	Imovel imovel = new Imovel("147258630", "Triplex do Lula", 
			"Apartamento comprado de forma honesta e trabalhadora", leilao, lances, endereco, 
			Imovel.TipoImovel.APARTAMENTO, 2008, 4800000.00);
	
	@Test
	public void getEndereco() {

	}

	@Test
	public void setEndereco() {

	}

	@Test
	public void getTipo() {

	}

	@Test
	public void setTipo() {

	}

	@Test
	public void getAnoconstrucao() {

	}

	@Test
	public void setAnoconstrucao() {

	}

	@Test
	public void getPreco() {

	}

	@Test
	public void setPreco() {

	}

}
