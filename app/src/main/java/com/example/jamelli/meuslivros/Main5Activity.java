package com.example.jamelli.meuslivros;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class Main5Activity extends AppCompatActivity {
    ListView lv;
    List<Livro> lista;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);

        lv = (ListView) findViewById(R.id.listBooks);
        lista = new ArrayList<Livro>();
        BancoHelper bh = new BancoHelper(this);

        lista = (ArrayList<Livro>) bh.findAll();
        lv.setAdapter(new LivrosAdapter(this,lista));

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

            }
        });
    }

}
