package br.com.italopatricio.leilaoestudo.models;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class LeilaoTest {

    private final Leilao CONSOLE = new Leilao("Console");
    private final Usuario ITALO = new Usuario("Italo");

    // Patterns utilizados
    // [nome do método][Estado de teste][resultado esperado]
    // [deve][resultado esperado][estado de teste]
    // fonte https://dzone.com/articles/7-popular-unit-test-naming

    @Test
    public void deve_DevolveDescricao_QuandoRecebeDescricao() {
        // executar acao esperada
        String descricaoDevolvida = CONSOLE.getDescricao();

        // testar resultado esperado
        assertEquals("Console", descricaoDevolvida);
    }

    @Test
    public void deve_DevolveMaiorLance_QuandoRecebeApenasUmLance() {
        CONSOLE.propoe(new Lance(ITALO, 200));

        double maiorLanceDevolvido = CONSOLE.getMaiorLance();

        assertEquals(200.00, maiorLanceDevolvido, 0.0001);
    }

    @Test
    public void deve_DevolveMaiorLance_QuandoRecebeMaisDeUmLanceEmOrdemCrescente() {
        CONSOLE.propoe(new Lance(ITALO, 100.0));
        CONSOLE.propoe(new Lance(new Usuario("Chico"), 200.0));

        double maiorLanceDevolvido = CONSOLE.getMaiorLance();

        assertEquals(200.0, maiorLanceDevolvido, 0.0001);
    }

    @Test
    public void deve_DevolveMaiorLance_QuandoRecebeMaisDeUmLanceEmOrdemDecrescente() {
        CONSOLE.propoe(new Lance(ITALO, 10000.0));
        CONSOLE.propoe(new Lance(new Usuario("Chico"), 9000.0));

        double maiorLanceDevolvido = CONSOLE.getMaiorLance();

        assertEquals(10000.0, maiorLanceDevolvido, 0.0001);
    }

    @Test
    public void deve_DevolveMenorLance_QuandoRecebeApenasUmLance() {
        CONSOLE.propoe(new Lance(ITALO, 200));

        double menorLanceDevolvido = CONSOLE.getMenorLance();

        assertEquals(200.00, menorLanceDevolvido, 0.0001);
    }

    @Test
    public void deve_DevolveMenorLance_QuandoRecebeMaisDeUmLanceEmOrdemCrescente() {
        CONSOLE.propoe(new Lance(ITALO, 100.0));
        CONSOLE.propoe(new Lance(new Usuario("Chico"), 200.0));

        double menorLanceDevolvido = CONSOLE.getMenorLance();

        assertEquals(100.0, menorLanceDevolvido, 0.0001);
    }

    @Test
    public void deve_DevolveMenorLance_QuandoRecebeMaisDeUmLanceEmOrdemDecrescente() {
        CONSOLE.propoe(new Lance(ITALO, 10000.0));
        CONSOLE.propoe(new Lance(new Usuario("Chico"), 9000.0));

        double menorLanceDevolvido = CONSOLE.getMenorLance();

        assertEquals(9000.0, menorLanceDevolvido, 0.0001);
    }

    @Test
    public void deve_DevolvevorTresMaioresLances_QuandoRecebeExatosTresLances() {
        CONSOLE.propoe(new Lance(ITALO, 200.0));
        CONSOLE.propoe(new Lance(new Usuario("Chico"), 300.0));
        CONSOLE.propoe(new Lance(ITALO, 400.0));

        List<Lance> tresMaioresLancesDevolvidos = CONSOLE.treMaioresLances();

        assertEquals(3, tresMaioresLancesDevolvidos.size());
    }
}