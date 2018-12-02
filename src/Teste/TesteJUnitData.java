package Teste;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import Model.Data;

public class TesteJUnitData {
	
	Data data = new Data(13, 12, 1995, 20, 00);
	List<Data> datas = new ArrayList<>();
	
	@Test
	public void getDia() {
		Assert.assertEquals(13, data.getDia());
	}

	@Test
	public void setDia() {
		data.setDia(8);
		Assert.assertEquals(8, data.getDia());
	}

	@Test
	public void getMes() {
		Assert.assertEquals(12, data.getMes());
	}

	@Test
	public void setMes() {
		data.setMes(3);
		Assert.assertEquals(3, data.getMes());
	}

	@Test
	public void getAno() {
		Assert.assertEquals(1995, data.getAno());
	}

	@Test
	public void setAno() {
		data.setAno(1996);
		Assert.assertEquals(1996, data.getAno());
	}

	@Test
	public void getHora() {
		Assert.assertEquals(20, data.getHora());
	}

	@Test
	public void setHora() {
		data.setHora(12);
		Assert.assertEquals(12, data.getHora());
	}

	@Test
	public void getMinuto() {
		Assert.assertEquals(0, data.getMinuto());
	}

	@Test
	public void setMinuto() {
		data.setMinuto(30);
		Assert.assertEquals(30, data.getMinuto());
	}

	@Test
	public void construtorData() {
		Data data = new Data(13, 12, 1995, 20, 00);
		datas.add(data);
		Assert.assertEquals(1, datas.size());
    }

	@Test
    public void imprimirData() {
        data.imprimirData();
    }

	@Test
    public void Comparar (){
    	Data data1 = new Data(13, 12, 1995, 20, 00);
    	Data data2 = new Data(8, 3, 1996, 20, 00);
    	Assert.assertEquals(data2, data1.Comparar(data1, data2));
    }
}
