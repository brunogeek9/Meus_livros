package com.example.jamelli.meuslivros;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;

public class Main2Activity extends AppCompatActivity {
    final static int result_code = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        final EditText tv_titulo = (EditText) findViewById(R.id.editText);
        final EditText tv_autor = (EditText) findViewById(R.id.editText2);
        final EditText tv_ano = (EditText) findViewById(R.id.editText3);
        final RatingBar rt_nota = (RatingBar) findViewById(R.id.ratingBar);

        Button btn_salvar = (Button) findViewById(R.id.button3);
        btn_salvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String titulo = tv_titulo.getText().toString();
                String autor = tv_autor.getText().toString();
                int ano = Integer.valueOf( tv_ano.getText().toString());
                double nota = rt_nota.getRating() ;

                Livro livro = new Livro(titulo,autor,ano,nota);
                BancoHelper bh = new BancoHelper(Main2Activity.this);
                bh.save(livro);


                Intent intent = new Intent();
                setResult(RESULT_OK,intent);
                finish();


            }
        });
        Button bnt_cancelar = (Button) findViewById(R.id.button4);
        bnt_cancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                setResult(RESULT_CANCELED,intent);
                finish();
            }
        });




    }
}
