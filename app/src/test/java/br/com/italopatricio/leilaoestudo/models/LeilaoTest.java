package br.com.italopatricio.leilaoestudo.models;

import org.junit.Test;

import static org.junit.Assert.*;

public class LeilaoTest {

    // Patterns utilizados
    // [nome do método][Estado de teste][resultado esperado]
    // [deve][resultado esperado][estado de teste]

    @Test
    public void deve_DevolveDescricao_QuandoRecebeDescricao() {
        // criar cenario de teste
        Leilao console = new Leilao("Console");
        // executar acao esperada
        String descricaoDevolvida = console.getDescricao();
        // testar resultado esperado
        assertEquals("Console", descricaoDevolvida);
    }

    @Test
    public void deve_DevolveMaiorLance_QuandoRecebeApenasUmLance() {
        Leilao console = new Leilao("Console");
        console.propoe(new Lance(new Usuario("Italo"), 200));

        double maiorLanceDevolvidoDoConsole = console.getMaiorLance();

        assertEquals(200.00, maiorLanceDevolvidoDoConsole, 0.0001);
    }

    @Test
    public void deve_DevolveMaiorLance_QuandoRecebeMaisDeUmLanceEmOrdemCrescente() {
        Leilao computador = new Leilao("Computador");
        computador.propoe(new Lance(new Usuario("Italo"), 100.0));
        computador.propoe(new Lance(new Usuario("Chico"), 200.0));

        double maiorLanceDevolvidoDoComputador = computador.getMaiorLance();

        assertEquals(200.0, maiorLanceDevolvidoDoComputador, 0.0001);
    }

    @Test
    public void deve_DevolveMaiorLance_QuandoRecebeMaisDeUmLanceEmOrdemDecrescente() {
        Leilao carro = new Leilao("Carro");
        carro.propoe(new Lance(new Usuario("Italo"), 10000.0));
        carro.propoe(new Lance(new Usuario("Chico"), 9000.0));

        double maiorLanceDevolvidoDoCarro = carro.getMaiorLance();

        assertEquals(10000.0, maiorLanceDevolvidoDoCarro, 0.0001);
    }

}