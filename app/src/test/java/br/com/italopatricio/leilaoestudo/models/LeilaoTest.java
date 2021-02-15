package br.com.italopatricio.leilaoestudo.models;

import org.junit.Test;

import static org.junit.Assert.*;

public class LeilaoTest {

    @Test
    public void getDescricao() {
        // criar cenario de teste
        Leilao console = new Leilao("Console");
        // executar acao esperada
        String descricaoDevolvida = console.getDescricao();
        // testar resultado esperado
        assertEquals("Console", descricaoDevolvida);
    }

    @Test
    public void getMaiorLance() {
        // verifica se devolve maior lance com apenas um lance
        Leilao console = new Leilao("Console");
        console.propoe(new Lance(new Usuario("Italo"), 200));

        double maiorLanceDevolvidoDoConsole = console.getMaiorLance();

        assertEquals(200.00, maiorLanceDevolvidoDoConsole, 0.0001);

        // verifica se devolve mior lance com mais de um lance em ordem cerescente
        Leilao computador = new Leilao("Computador");
        computador.propoe(new Lance(new Usuario("Italo"), 100.0));
        computador.propoe(new Lance(new Usuario("Chico"), 200.0));

        double maiorLanceDevolvidoDoComputador = computador.getMaiorLance();

        assertEquals(200.0, maiorLanceDevolvidoDoComputador, 0.0001);

        // verifica se devolve maior lance com mais de um lance me ordem descrecente
        Leilao carro = new Leilao("Carro");
        carro.propoe(new Lance(new Usuario("Italo"), 10000.0));
        carro.propoe(new Lance(new Usuario("Chico"), 9000.0));

        double maiorLanceDevolvidoDoCarro = carro.getMaiorLance();

        assertEquals(10000.0, maiorLanceDevolvidoDoCarro, 0.0001);
    }

}