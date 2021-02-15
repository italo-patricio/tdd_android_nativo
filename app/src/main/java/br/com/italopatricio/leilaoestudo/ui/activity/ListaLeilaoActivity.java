package br.com.italopatricio.leilaoestudo.ui.activity;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import br.com.italopatricio.leilaoestudo.R;
import br.com.italopatricio.leilaoestudo.models.Lance;
import br.com.italopatricio.leilaoestudo.models.Leilao;
import br.com.italopatricio.leilaoestudo.models.Usuario;
import br.com.italopatricio.leilaoestudo.ui.recyclerview.adapter.ListaLeilaoAdapter;

public class ListaLeilaoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_leilao);
        ListaLeilaoAdapter adapter = new ListaLeilaoAdapter(this, leiloesDeExemplo());
        RecyclerView recyclerView = findViewById(R.id.list_recycler_view);
        recyclerView.setAdapter(adapter);
        adapter.setOnItemClickListener(leilao -> {
            Intent vaiParaLancesLeilao = new Intent(ListaLeilaoActivity.this, ItemDetailActivity.class);
            vaiParaLancesLeilao.putExtra("leilao", leilao);
            startActivity(vaiParaLancesLeilao);
        });
    }

    private List<Leilao> leiloesDeExemplo() {
        Leilao console = new Leilao("Console");
        console.propoe(new Lance(new Usuario("Chixo"), 300.00));
        console.propoe(new Lance(new Usuario("Italo"), 200.0));

        Leilao computador = new Leilao("Computador");
        computador.propoe(new Lance(new Usuario("João"), 1000.0));

        Leilao carro = new Leilao("Carro");
        carro.propoe(new Lance(new Usuario("Joana"), 10000.0));
        carro.propoe(new Lance(new Usuario("Maria"), 15000.0));
        carro.propoe(new Lance(new Usuario("Mario"), 17000.0));


        return new ArrayList<>(Arrays.asList(
                console,
                computador,
                carro
        ));
    }

}
