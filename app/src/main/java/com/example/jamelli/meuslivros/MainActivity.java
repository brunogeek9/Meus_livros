package com.example.jamelli.meuslivros;

import android.content.Intent;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    final static int request_one = 1;
    ConstraintLayout constraint;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        constraint = (ConstraintLayout) findViewById(R.id.laranja);
        Button btn_cadastrar = (Button) findViewById(R.id.button);
        btn_cadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,Main2Activity.class);
                startActivityForResult(intent,request_one);
            }
        });

        Button btn_listar = (Button) findViewById(R.id.button2);
        btn_listar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,Main3Activity.class);
                startActivity(intent);
            }
        });
    }
    public void callSnack(String message){
        Snackbar snack = Snackbar.make(constraint, message, Snackbar.LENGTH_LONG)
                .setAction("cancelar", new View.OnClickListener(){
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(MainActivity.this, "Vc clicou", Toast.LENGTH_SHORT).show();
                    }
                });
        snack.show();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == 1){
            if(resultCode == RESULT_OK)
                callSnack("CADASTRO REALIZADO COM SUCESSO!!");

            /*else if(requestCode == RESULT_CANCELED){

            }*/

        }else {
            if(requestCode == RESULT_CANCELED)
                callSnack("VC CANCELOU A OPERAÇÃO!!");
        }
    }
}
