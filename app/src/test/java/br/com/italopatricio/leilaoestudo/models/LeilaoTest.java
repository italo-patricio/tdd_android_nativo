package br.com.italopatricio.leilaoestudo.models;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class LeilaoTest {

    public static final double DELTA = 0.0001;
    private final Leilao CONSOLE = new Leilao("Console");
    private final Usuario ITALO = new Usuario("ITALO");


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

        assertEquals(200.00, maiorLanceDevolvido, DELTA);
    }

    @Test
    public void deve_DevolveMaiorLance_QuandoRecebeMaisDeUmLanceEmOrdemCrescente() {
        CONSOLE.propoe(new Lance(ITALO, 100.0));
        CONSOLE.propoe(new Lance(new Usuario("Chico"), 200.0));

        double maiorLanceDevolvido = CONSOLE.getMaiorLance();

        assertEquals(200.0, maiorLanceDevolvido, DELTA);
    }

    @Test
    public void deve_DevolveMenorLance_QuandoRecebeApenasUmLance() {
        CONSOLE.propoe(new Lance(ITALO, 200));

        double menorLanceDevolvido = CONSOLE.getMenorLance();

        assertEquals(200.00, menorLanceDevolvido, DELTA);
    }

    @Test
    public void deve_DevolveMenorLance_QuandoRecebeMaisDeUmLanceEmOrdemCrescente() {
        CONSOLE.propoe(new Lance(ITALO, 100.0));
        CONSOLE.propoe(new Lance(new Usuario("Chico"), 200.0));

        double menorLanceDevolvido = CONSOLE.getMenorLance();

        assertEquals(100.0, menorLanceDevolvido, DELTA);
    }

    @Test
    public void deve_DevolvevorTresMaioresLances_QuandoRecebeExatosTresLances() {
        CONSOLE.propoe(new Lance(ITALO, 200.0));
        CONSOLE.propoe(new Lance(new Usuario("Chico"), 300.0));
        CONSOLE.propoe(new Lance(ITALO, 400.0));

        List<Lance> tresMaioresLancesDevolvidos = CONSOLE.treMaioresLances();

        assertEquals(3, tresMaioresLancesDevolvidos.size());
        assertEquals(400.0, tresMaioresLancesDevolvidos.get(0).getValor(), DELTA);
        assertEquals(300.0, tresMaioresLancesDevolvidos.get(1).getValor(), DELTA);
        assertEquals(200.0, tresMaioresLancesDevolvidos.get(2).getValor(), DELTA);
    }

    @Test
    public void deve_DevolvevorTresMaioresLances_QuandoRecebeDoisLances() {
        CONSOLE.propoe(new Lance(ITALO, 200.0));
        CONSOLE.propoe(new Lance(new Usuario("Chico"), 300.0));

        List<Lance> tresMaioresLancesDevolvidos = CONSOLE.treMaioresLances();

        assertEquals(2, tresMaioresLancesDevolvidos.size());
        assertEquals(300.0, tresMaioresLancesDevolvidos.get(0).getValor(), DELTA);
        assertEquals(200.0, tresMaioresLancesDevolvidos.get(1).getValor(), DELTA);
    }

    @Test
    public void deve_DevolvevorTresMaioresLances_QuandoRecebeSomenteUmLance() {
        CONSOLE.propoe(new Lance(ITALO, 200.0));

        List<Lance> tresMaioresLancesDevolvidos = CONSOLE.treMaioresLances();

        assertEquals(1, tresMaioresLancesDevolvidos.size());
        assertEquals(200.0, tresMaioresLancesDevolvidos.get(0).getValor(), DELTA);
    }

    @Test
    public void deve_DevolvevorTresMaioresLances_QuandoRecebeMaisDeTresLances() {
        CONSOLE.propoe(new Lance(ITALO, 200.0));
        CONSOLE.propoe(new Lance(new Usuario("Chico"), 300.0));
        CONSOLE.propoe(new Lance(ITALO, 400.0));
        CONSOLE.propoe(new Lance(new Usuario("Chico"), 500.0));

        List<Lance> tresMaioresLancesDevolvidos = CONSOLE.treMaioresLances();

        assertEquals(3, tresMaioresLancesDevolvidos.size());
        assertEquals(500.0, tresMaioresLancesDevolvidos.get(0).getValor(), DELTA);
        assertEquals(400.0, tresMaioresLancesDevolvidos.get(1).getValor(), DELTA);
        assertEquals(300.0, tresMaioresLancesDevolvidos.get(2).getValor(), DELTA);

        CONSOLE.propoe(new Lance(ITALO, 700.0));

        final List<Lance> tresMaioresLancesDevolvidosParaCincoLances = CONSOLE.treMaioresLances();

        assertEquals(3, tresMaioresLancesDevolvidosParaCincoLances.size());
        assertEquals(700.0, tresMaioresLancesDevolvidosParaCincoLances.get(0).getValor(), DELTA);
        assertEquals(500.0, tresMaioresLancesDevolvidosParaCincoLances.get(1).getValor(), DELTA);
        assertEquals(400.0, tresMaioresLancesDevolvidosParaCincoLances.get(2).getValor(), DELTA);

    }
    @Test
    public void deve_DevolvevorZeroParaMaiorLance_QuandoNaoRecebeLance() {
        double maiorLanceDevolvido = CONSOLE.getMaiorLance();

        assertEquals(0, maiorLanceDevolvido, 0.00001);
    }

    @Test
    public void deve_DevolverValorZeroParaMenorLance_QuandoNaoTiverLances() {
        double menorLanceDevolvido = CONSOLE.getMenorLance();

        assertEquals(0, menorLanceDevolvido, 0.00001);
    }

    @Test
    public void naoDeve_AdicionarLance_QuandoForMenorQueOMaiorLance() {
        CONSOLE.propoe(new Lance(ITALO, 530.0));
        CONSOLE.propoe(new Lance(new Usuario("Chico"), 400.0));

        int quantidadeLancesDevolvida = CONSOLE.quantidadeLances();

        assertEquals(1, quantidadeLancesDevolvida);
    }

    @Test
    public void naoDeve_AdicionarLance_QuandoForOMesmoUsuarioDoUltimoLance() {
        CONSOLE.propoe(new Lance(ITALO, 530.0));
        CONSOLE.propoe(new Lance(new Usuario("ITALO"), 580.0));

        int quantidadeLancesDevolvida = CONSOLE.quantidadeLances();

        assertEquals(1, quantidadeLancesDevolvida);
    }


}