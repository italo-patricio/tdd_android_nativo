package br.com.italopatricio.leilaoestudo.models;

import org.junit.Test;

import static org.junit.Assert.*;

public class LeilaoTest {

    private Leilao console = new Leilao("Console");
    private Usuario italo = new Usuario("Italo");
    private Usuario chico = new Usuario("Chico");

    // Patterns utilizados
    // [nome do método][Estado de teste][resultado esperado]
    // [deve][resultado esperado][estado de teste]
    // fonte https://dzone.com/articles/7-popular-unit-test-naming

    @Test
    public void deve_DevolveDescricao_QuandoRecebeDescricao() {
        // executar acao esperada
        String descricaoDevolvida = console.getDescricao();

        // testar resultado esperado
        assertEquals("Console", descricaoDevolvida);
    }

    @Test
    public void deve_DevolveMaiorLance_QuandoRecebeApenasUmLance() {
        console.propoe(new Lance(italo, 200));

        double maiorLanceDevolvido = console.getMaiorLance();

        assertEquals(200.00, maiorLanceDevolvido, 0.0001);
    }

    @Test
    public void deve_DevolveMaiorLance_QuandoRecebeMaisDeUmLanceEmOrdemCrescente() {
        console.propoe(new Lance(italo, 100.0));
        console.propoe(new Lance(chico, 200.0));

        double maiorLanceDevolvido = console.getMaiorLance();

        assertEquals(200.0, maiorLanceDevolvido, 0.0001);
    }

    @Test
    public void deve_DevolveMaiorLance_QuandoRecebeMaisDeUmLanceEmOrdemDecrescente() {
        console.propoe(new Lance(italo, 10000.0));
        console.propoe(new Lance(chico, 9000.0));

        double maiorLanceDevolvido = console.getMaiorLance();

        assertEquals(10000.0, maiorLanceDevolvido, 0.0001);
    }

    @Test
    public void deve_DevolveMenorLance_QuandoRecebeApenasUmLance() {
        console.propoe(new Lance(italo, 200));

        double menorLanceDevolvido = console.getMenorLance();

        assertEquals(200.00, menorLanceDevolvido, 0.0001);
    }

    @Test
    public void deve_DevolveMenorLance_QuandoRecebeMaisDeUmLanceEmOrdemCrescente() {
        console.propoe(new Lance(italo, 100.0));
        console.propoe(new Lance(chico, 200.0));

        double menorLanceDevolvido = console.getMenorLance();

        assertEquals(100.0, menorLanceDevolvido, 0.0001);
    }

    @Test
    public void deve_DevolveMenorLance_QuandoRecebeMaisDeUmLanceEmOrdemDecrescente() {
        console.propoe(new Lance(italo, 10000.0));
        console.propoe(new Lance(chico, 9000.0));

        double menorLanceDevolvido = console.getMenorLance();

        assertEquals(9000.0, menorLanceDevolvido, 0.0001);
    }
}