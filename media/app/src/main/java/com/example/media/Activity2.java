package com.example.media;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Activity2 extends AppCompatActivity {
    private TextView txtNome, txtResultado;
    private EditText edtTrabalho1,edtTrabalho2, edtTrabalho3, edtFalta;

    private Button btnCalcula;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        txtNome = findViewById(R.id.txtNome);

        edtFalta = findViewById(R.id.edtFalta);
        edtTrabalho1 = findViewById(R.id.edtTrabalho1);
        edtTrabalho2 = findViewById(R.id.edtTrabalho2);
        edtTrabalho3 = findViewById(R.id.edtTrabalho3);
        btnCalcula = findViewById(R.id.btnCalcula);
        txtResultado  = findViewById(R.id.txtResultado);

        Intent intent = getIntent();
        String nome = intent.getStringExtra("chave_nome");

        if(nome!=null){
            txtNome.setText(nome);
        }

        btnCalcula.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    int Faltas = Integer.parseInt(edtFalta.getText().toString());
                    double trab1 = Double.parseDouble(edtTrabalho1.getText().toString());
                    double trab2 = Double.parseDouble(edtTrabalho2.getText().toString());
                    double trab3 = Double.parseDouble(edtTrabalho3.getText().toString());

                    double porcentagem = 1 - ((double) Faltas/68.0);



                    if(porcentagem<0.75){
                        txtResultado.setText("Aluno reprovado por Falta");
                    }else{
                        float media = (float) (trab1*0.3f+trab2*0.3f+trab3*0.4f);
                        if(media>=6){
                            txtResultado.setText("Aluno aprovado com média:" + media);
                        }else{
                            txtResultado.setText("Aluno reprovado, nota final: "+media);
                        }
                    }


                }catch (Exception e){
                    AlertDialog.Builder dlg = new AlertDialog.Builder(Activity2.this);
                    dlg.setMessage("Complete os campos");
                    dlg.setNeutralButton("ok",null);
                    dlg.show();
                }

            }
        });
    }
}