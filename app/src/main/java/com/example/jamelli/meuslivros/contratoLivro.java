package com.example.jamelli.meuslivros;

import android.provider.BaseColumns;

/**
 * Created by Aluno on 06/09/2017.
 */

public final class contratoLivro {

    private contratoLivro() {
    }
    public static class livroEntry implements BaseColumns{

        public static final String TABLE_NAME = "Livro";
        public static final String TITULO = "titulo";
        public static final String AUTOR = "autor";
        public static final String ANO = "ano";
        public static final String NOTA= "nota";

    }


}
