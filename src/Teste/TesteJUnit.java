package Teste;

import Model.Data;
import Model.Instituicao;
import Model.Leilao;
import Model.Produto;
import org.junit.Assert;
import org.junit.Test;

import java.util.*;

public class TesteJUnit {

    @Test
    public void LeilaoConstruct (){
        List<Produto> produtos = new ArrayList<Produto>()
        Leilao leilao = new Leilao(new Instituicao("Hospital", 2018),
                produtos, new Data(13, 12, 1995, 19, 30),
                new Data(23, 11, 2018, 22, 30), );
        Assert.assertEquals(leilao, null);
    }
}
