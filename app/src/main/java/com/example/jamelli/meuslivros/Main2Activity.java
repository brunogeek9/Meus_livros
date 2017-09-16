package com.example.jamelli.meuslivros;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;

public class Main2Activity extends AppCompatActivity {
    final static int result_code = 1;
    protected Bundle args = new Bundle();
    protected BancoHelper bh = new BancoHelper(Main2Activity.this);
    protected Livro livro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        args = getIntent().getExtras();

        final EditText et_titulo = (EditText) findViewById(R.id.editText);
        final EditText et_autor = (EditText) findViewById(R.id.editText2);
        final EditText et_ano = (EditText) findViewById(R.id.editText3);
        final RatingBar rt_nota = (RatingBar) findViewById(R.id.ratingBar);

        if(args != null){
            Log.i("livro","bundle com dados");
            //mudando os editTexts
            et_titulo.setText(args.getString("titulo"));
            et_autor.setText(args.getString("autor"));
            et_ano.setText(String.valueOf(args.getInt("ano")));
            rt_nota.setRating((float) args.getDouble("nota"));
        }else {
            Log.i("livro","bundle vazio");

        }

        Button btn_salvar = (Button) findViewById(R.id.button3);
        btn_salvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String titulo = et_titulo.getText().toString();
                String autor = et_autor.getText().toString();
                int ano = Integer.valueOf( et_ano.getText().toString());
                double nota = rt_nota.getRating() ;
                livro = new Livro(titulo,autor,ano,nota);
                if(args != null){
                    livro.setId(args.getLong("id"));
                }
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
