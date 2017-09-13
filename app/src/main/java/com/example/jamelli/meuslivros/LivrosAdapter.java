package com.example.jamelli.meuslivros;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;

/**
 * Created by Aluno on 13/09/2017.
 */

public class LivrosAdapter extends BaseAdapter{
    Context context;
    List<Livro> livros;

    public LivrosAdapter(Context context, List<Livro> livros) {
        this.context = context;
        this.livros = livros;
    }

    @Override
    public int getCount() {
        return livros != null ? livros.size() : 0;
    }

    @Override
    public Object getItem(int i) {
        return livros.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View convertView, ViewGroup viewGroup) {
        View view;
        ViewHolder holder;

        if(convertView == null){
            view = LayoutInflater.from(context).inflate(R.layout.layout_inflado, viewGroup, false);
            holder = new ViewHolder(view);
            view.setTag(holder);

        }else{
            view = convertView;
            holder = (ViewHolder) view.getTag();
        }
        //Preenche os dados do livro
        Livro livroescolhido = livros.get(i);
        holder.textViewTitulo.setText(livroescolhido.getTitulo());
        holder.textViewAutor.setText(livroescolhido.getAutor());
        holder.textViewNota.setText(""+livroescolhido.getNota());
        holder.textViewAno.setText(""+livroescolhido.getAno());

        return view;
    }
}
