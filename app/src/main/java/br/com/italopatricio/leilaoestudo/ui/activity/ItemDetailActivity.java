package br.com.italopatricio.leilaoestudo.ui.activity;

import android.content.Intent;
import android.os.Bundle;

import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import br.com.italopatricio.leilaoestudo.R;
import br.com.italopatricio.leilaoestudo.models.Leilao;

public class ItemDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.item_detail);
        Intent dadosRecebidos = getIntent();
        if(dadosRecebidos.hasExtra("leilao")){
            Leilao leilao = (Leilao) dadosRecebidos.getSerializableExtra("leilao");
            TextView descricao = findViewById(R.id.text_description_item_detail);
            descricao.setText(leilao.getDescricao());
            TextView maiorLance = findViewById(R.id.text_max_value_item_detail);
            maiorLance.setText(String.valueOf(leilao.getMaiorLance()));
            TextView menorLance = findViewById(R.id.text_min_value_item_detail);
            menorLance.setText(String.valueOf(leilao.getMenorLance()));
        }
    }
}
