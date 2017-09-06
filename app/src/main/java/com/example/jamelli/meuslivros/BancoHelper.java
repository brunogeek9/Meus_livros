package com.example.jamelli.meuslivros;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;


import java.util.ArrayList;
import java.util.List;


/**
 * Created by Aluno on 06/09/2017.
 */
//String auxiliares


public class BancoHelper extends SQLiteOpenHelper {
    private static final String TAG = "sql";
    private static final String TEXT_TYPE = " TEXT";
    private static final String NUMBER_TYPE = " INTEGER";
    private static final String VIRGULA = ",";

    // Nome do banco
    private static final String DATABASE_NAME = "banco_exemplo.sqlite";
    //versão do banco
    private static final int DATABASE_VERSION = 1;
    private static final String SQL_CREATE_TABLE =
            ("CREATE TABLE " + contratoLivro.livroEntry.TABLE_NAME +
                    "("+
                    contratoLivro.livroEntry._ID + NUMBER_TYPE+  " PRIMARY KEY"+ VIRGULA+
                    contratoLivro.livroEntry.TITULO + TEXT_TYPE + VIRGULA+
                    contratoLivro.livroEntry.AUTOR + TEXT_TYPE + VIRGULA+
                    contratoLivro.livroEntry.ANO + NUMBER_TYPE + VIRGULA+
                    contratoLivro.livroEntry.NOTA + NUMBER_TYPE+
                    ");"
            );



    public BancoHelper(Context context) {
        // context, nome do banco, factory, versão
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    private static final String SQL_DROP_TABLE =
            ("DROP TABLE "+ contratoLivro.livroEntry.TABLE_NAME+";"
            );



    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_TABLE);
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Caso mude a versãoo do banco de dados, podemos executar um SQL aqui
        if (oldVersion != newVersion) {
            // Execute o script para atualizar a versão...
            Log.d(TAG, "Foi detectada uma nova versão do banco, aqui deverão ser executados os scripts de update.");
            db.execSQL(SQL_DROP_TABLE);
            this.onCreate(db);
        }
    }
    @Override
    public void  onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion){
        if (oldVersion != newVersion) {
            // Execute o script para atualizar a versão...
            Log.d(TAG, "Foi detectada uma nova versão do banco, aqui deverão ser executados os scripts de downgrade.");
            db.execSQL(SQL_DROP_TABLE);
            this.onCreate(db);
        }
    }


    public long save(Livro livro){
        long id = livro.getId();
        SQLiteDatabase db = getWritableDatabase();

        try {
            ContentValues values = new ContentValues();
            values.put(contratoLivro.livroEntry.TITULO,livro.getTitulo());
            values.put(contratoLivro.livroEntry.AUTOR,livro.getAutor());
            values.put(contratoLivro.livroEntry.ANO,livro.getAno());
            values.put(contratoLivro.livroEntry.NOTA,livro.getNota());

            id = db.insert(contratoLivro.livroEntry.TABLE_NAME, null, values);
            Log.i(TAG, "Inseriu id [" + id + "] no banco.");
            return id;

        }finally {
            db.close();
        }
    }

    private List<Livro> toList(Cursor c) {

        List<Livro> livros = new ArrayList<>();

        if (c.moveToFirst()) {
            do {
                Livro livro = new Livro();
                livros.add(livro);

                // recupera os atributos de carro
                livro.setId(c.getInt(c.getColumnIndex(contratoLivro.livroEntry._ID)));
                livro.setAutor(c.getString(c.getColumnIndex(contratoLivro.livroEntry.AUTOR)));
                livro.setTitulo(c.getString(c.getColumnIndex(contratoLivro.livroEntry.TITULO)));
                livro.setAno(c.getInt(c.getColumnIndex(contratoLivro.livroEntry.ANO)));
                livro.setNota(c.getInt(c.getColumnIndex(contratoLivro.livroEntry.NOTA)));

            } while (c.moveToNext());
        }

        return livros;
    }

    public List<Livro> findAll() {
        SQLiteDatabase db = getReadableDatabase();
        try {
            // select * from carro
            Cursor c = db.query(contratoLivro.livroEntry.TABLE_NAME, null, null, null, null, null, null, null);
            Log.i(TAG, "Listou todos os registros");
            return toList(c);
        } finally {
            db.close();
        }
    }




}
