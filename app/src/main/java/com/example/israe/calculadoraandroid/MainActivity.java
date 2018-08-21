package com.example.israe.calculadoraandroid;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText numeroUno;
    private EditText numeroDos;
    private TextView textView;
    private RadioButton botonSumar;
    private RadioButton botonRestar;
    private Spinner spinner;


    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toast.makeText(this,"onCreate", Toast.LENGTH_SHORT).show();

        numeroUno=(EditText)findViewById(R.id.numeroUno);
        numeroDos=(EditText)findViewById(R.id.numeroDos);
        textView=findViewById(R.id.textView);
        spinner=(Spinner) findViewById(R.id.spinner1);
        String [] opciones={"sumar","restar","multiplicar","dividir"};
        ArrayAdapter<String> adapter= new ArrayAdapter<String>(this, R.layout.spinner_item_opcciones, opciones);
        spinner.setAdapter(adapter);

        //botonSumar=(RadioButton)findViewById(R.id.radioSumar);
        //botonRestar=(RadioButton)findViewById(R.id.radioRestar);
    }
    public void  Siguiente(View view){
        Intent siguiente=new Intent(this,segundoActivity.class);
        startActivity(siguiente);

    }
    public void cal(View view){
        String valorUno=numeroUno.getText().toString();
        String valorDos=numeroDos.getText().toString();
        if(!valorUno.isEmpty() && !valorDos.isEmpty()) {
            int nUno = Integer.parseInt(valorUno);
            int nDos = Integer.parseInt(valorDos);
            String seleccion=spinner.getSelectedItem().toString();
            switch (seleccion){
                case "sumar":
                    textView.setText(String.valueOf(nUno+nDos));
                    break;
                case "restar":
                    textView.setText(String.valueOf(nUno-nDos));
                    break;
                case "multiplicar":
                    textView.setText(String.valueOf(nUno*nDos));
                    break;
                case "dividir":
                    if (nUno==0 || nDos==0){
                        Toast.makeText(this,"valor no valido '0'",Toast.LENGTH_SHORT).show();
                    }else {
                        textView.setText(String.valueOf(nUno/nDos));
                    }
                    break;
                default:
                    Toast.makeText(this,"seleccione una opccion",Toast.LENGTH_SHORT).show();
            }

        }else {
            Toast.makeText(this,"pon numeros plz!!!",Toast.LENGTH_SHORT).show();
        }

    }

    public void Calcular(View view){
        String valorUno=numeroUno.getText().toString();
        String valorDos=numeroDos.getText().toString();
        if(!valorUno.isEmpty() && !valorDos.isEmpty()){
        int nUno=Integer.parseInt(valorUno);
        int nDos=Integer.parseInt(valorDos);
        if (botonSumar.isChecked()){
            int suma=nUno+nDos;
            String resultado=String.valueOf(suma);
            textView.setText(resultado);
        }else if (botonRestar.isChecked()){
            int resta=nUno-nDos;
            String resultado=String.valueOf(resta);
            textView.setText(resultado);
        }
        }else {
            Toast.makeText(this,"pon numeros plz!!!",Toast.LENGTH_SHORT).show();
        }


    }

    public void sumar(View view){
        String valorUno=numeroUno.getText().toString();
        String valorDos=numeroDos.getText().toString();
        int nUno=Integer.parseInt(valorUno);
        int nDos=Integer.parseInt(valorDos);
        int suma=nUno+nDos;
        String resultado=String.valueOf(suma);
        textView.setText(resultado);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(this,"onStart", Toast.LENGTH_SHORT).show();
        //la actividad esta a punto de hacecer visible
    }

    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(this,"onResume", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(this,"onPause", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Toast.makeText(this,"onRestart", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(this,"onDestroy", Toast.LENGTH_SHORT).show();
    }
}
