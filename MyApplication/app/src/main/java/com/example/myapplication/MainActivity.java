package com.example.myapplication;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;


public class MainActivity extends AppCompatActivity {
    private EditText edtNum1, edtNum2;
    private TextView txtResult;
    private Button btnSoma, btnSubtrai, btnDiv,btnMulti, btnLimpa;

    private char op;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtNum1 = findViewById(R.id.edtNum1);
        edtNum2 = findViewById(R.id.edtNum2);
        txtResult = findViewById(R.id.txtResult);
        btnSoma = findViewById(R.id.btnSoma);
        btnSubtrai = findViewById(R.id.btnSubtrai);
        btnMulti = findViewById(R.id.btnMulti);
        btnDiv = findViewById(R.id.btnDiv);
        btnLimpa = findViewById(R.id.btnLimpar);

        btnSoma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                   op='+';
                   calcula();
            }
        });
        btnSubtrai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                op='-';
                calcula();
            }
        });

        btnMulti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                op='*';
                calcula();
            }
        });

        btnDiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                op='/';
                calcula();
            }
        });
    }

    private void calcula() {
        try {
            double valor1 = Double.parseDouble(edtNum1.getText().toString());
            double valor2 = Double.parseDouble(edtNum2.getText().toString());
            double result =0.0;
            DecimalFormat df = new  DecimalFormat();
            df.applyLocalizedPattern("#,##0.00");
            switch (op){
                case '+':
                    result =valor1+valor2;
                    break;
                case '-':
                    result=valor1-valor2;
                    break;
                case'*':
                    result=valor1*valor2;
                    break;
                case '/':
                    result=valor1/valor2;
                    break;
                default:
                    result=0.0;
                    break;
            }
            txtResult.setText(df.format(result));
        }catch (Exception e){
            AlertDialog.Builder dlg = new AlertDialog.Builder(MainActivity.this);
            dlg.setMessage("Preencha o campo");
            dlg.setNeutralButton("OK",null);
            dlg.show();
        }

    }
}