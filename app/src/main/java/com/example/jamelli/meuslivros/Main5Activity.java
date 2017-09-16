package com.example.jamelli.meuslivros;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class Main5Activity extends AppCompatActivity {
    protected ListView lv;
    protected List<Livro> lista;
    protected Livro livro;
    protected BancoHelper bh = new BancoHelper(this);
    EditText et_titulo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);

        lv = (ListView) findViewById(R.id.listBooks);
        lista = new ArrayList<Livro>();


        lista = (ArrayList<Livro>) bh.findAll();
        lv.setAdapter(new LivrosAdapter(this,lista));

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                //fazendo uso do metodo do livro adapter
                livro = (Livro) adapterView.getAdapter().getItem(i);
                Log.i("livro",livro.toString());

                Intent it = new Intent(Main5Activity.this,Main2Activity.class);

                //criando um bundle e colocando os valores do objeto livro clicado
                Bundle pacote = new Bundle();
                pacote.putString("titulo",livro.getTitulo());
                pacote.putString("autor",livro.getAutor());
                pacote.putInt("ano",livro.getAno());
                pacote.putDouble("nota",livro.getNota());
                pacote.putLong("id",livro.getId());
                it.putExtras(pacote);
                startActivity(it);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("livro","onResume");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i("livro","onRestart");
        lista = (ArrayList<Livro>) bh.findAll();
        lv.setAdapter(new LivrosAdapter(this,lista));
    }
}
