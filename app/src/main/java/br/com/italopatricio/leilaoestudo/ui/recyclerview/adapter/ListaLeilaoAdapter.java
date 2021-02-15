package br.com.italopatricio.leilaoestudo.ui.recyclerview.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import br.com.italopatricio.leilaoestudo.R;
import br.com.italopatricio.leilaoestudo.models.Leilao;


public class ListaLeilaoAdapter extends RecyclerView.Adapter<ListaLeilaoAdapter.ViewHolder> {

    private final List<Leilao> leiloes;
    private final Context context;
    private OnItemClickListener onItemClickListener;

    public ListaLeilaoAdapter(Context context, List<Leilao> leiloes) {
        this.context = context;
        this.leiloes = leiloes;
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View viewCriada = LayoutInflater.from(context).inflate(R.layout.list_item, parent, false);
        return new ViewHolder(viewCriada);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Leilao leilao = pegaLeilaoPorPosicao(position);
        holder.vincula(leilao);
    }

    @Override
    public int getItemCount() {
        return leiloes.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        private final TextView descricao;
        private Leilao leilao;

        ViewHolder(View itemView) {
            super(itemView);
            descricao = itemView.findViewById(R.id.text_description_list_item);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onItemClickListener.onItemClick(leilao);
                }
            });
        }

        void vincula(Leilao leilao) {
            this.leilao = leilao;
            descricao.setText(leilao.getDescricao());
        }

    }

    public Leilao pegaLeilaoPorPosicao(int posicao) {
        return this.leiloes.get(posicao);
    }

    public interface OnItemClickListener {
        void onItemClick(Leilao leilao);
    }

}
