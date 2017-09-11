package com.example.jamelli.meuslivros;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class Main4Activity extends AppCompatActivity {
    private String[] livros;
    private ArrayList<Livro> listaLivros = new ArrayList();
    private ArrayAdapter<String> adaptador;
    private String titulo;
    protected Livro livro = new Livro();

    TextView tv_titulo;
    TextView tv_autor;
    TextView tv_ano;
    TextView tv_nota;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        BancoHelper bh = new BancoHelper(this);
        tv_titulo = (TextView) findViewById(R.id.textView16);
        tv_autor = (TextView) findViewById(R.id.textView17);
        tv_ano = (TextView) findViewById(R.id.textView18);
        tv_nota = (TextView) findViewById(R.id.textView19);

        listaLivros = (ArrayList<Livro>) bh.findAll();
        AutoCompleteTextView auto = (AutoCompleteTextView) findViewById(R.id.autoComplete);
        pegaLivros();
        adaptador = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,livros);

        auto.setAdapter(adaptador);
        auto.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                titulo = adaptador.getItem(i).toString();
                buscaLivro(titulo);
            }
        });

    }

    public void pegaLivros(){
        livros = new String[listaLivros.size()];
        for(int i = 0;i<listaLivros.size();i++){
            livros[i] = listaLivros.get(i).getTitulo();
        }
    }

    public void buscaLivro(String titulo){
        BancoHelper bh = new BancoHelper(this);
        livro = bh.findByTitulo(titulo);
        Toast.makeText(Main4Activity.this,
                livro.toString(),
                Toast.LENGTH_SHORT).show();
        Log.i("livro",livro.getTitulo());
        tv_titulo.setText(livro.getTitulo());
        tv_autor.setText(livro.getAutor());
        tv_ano.setText(String.valueOf(livro.getAno()));
        tv_nota.setText(String.valueOf(livro.getNota()));
    }

}
