package Teste;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import Model.Endereco;

public class TesteJUnitEndereco {
	
	Endereco endereco = new Endereco("Rua das Acacias, 147", "SJC", "SP", "14258390");
	List<Endereco> enderecos = new ArrayList<>();
	
	@Test
	public void getEnderecocompleto() {
		Assert.assertEquals("Rua das Acacias, 147", endereco.getEnderecoCompleto());
	}

	@Test
	public void setEnderecocompleto() {

	}

	@Test
	public void getCidade() {
		Assert.assertEquals("SJC", endereco.getCidade());
	}

	@Test
	public void setCidade() {
		endereco.setCidade("SJP");
		Assert.assertEquals("SJP", endereco.getCidade());
	}

	@Test
	public void getEstado() {
		Assert.assertEquals("SP", endereco.getEstado());
	}

	@Test
	public void setEstado() {
		endereco.setEstado("MG");
		Assert.assertEquals("MG", endereco.getEstado());
	}

	@Test
	public void getCep() {
		Assert.assertEquals("14258390", endereco.getCep());
	}

	@Test
	public void setCep() {
		endereco.setCep("12548970");
		Assert.assertEquals("12548970", endereco.getCep());
	}
	
	@Test
	public void construtorEndereco() {
		Endereco endereco = new Endereco("Rua das Acacias, 147", "SJC", "SP", "14258390");
		enderecos.add(endereco);
		Assert.assertEquals(1, enderecos.size());
	}
	
	@Test
	public void imprimirEndereco() {
		endereco.ImprimirEndereco();
	}

}
