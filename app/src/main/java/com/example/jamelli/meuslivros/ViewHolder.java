package com.example.jamelli.meuslivros;

import android.view.View;
import android.widget.TextView;

/**
 * Created by Aluno on 13/09/2017.
 */

public class ViewHolder {
    final TextView textViewTitulo;
    final TextView textViewAutor;
    final TextView textViewNota;
    final TextView textViewAno;
    public ViewHolder(View v) {
        textViewTitulo = (TextView) v.findViewById(R.id.titulo);
        textViewAutor = (TextView) v.findViewById(R.id.autor);
        textViewNota = (TextView) v.findViewById(R.id.nota);
        textViewAno = (TextView) v.findViewById(R.id.ano);
    }
}
