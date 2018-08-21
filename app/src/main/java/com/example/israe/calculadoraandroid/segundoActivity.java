package com.example.israe.calculadoraandroid;

import android.app.Activity;
import android.content.Intent;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class segundoActivity extends AppCompatActivity {
    private EditText etNombre, etContenido;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segundo);
        etNombre=(EditText)findViewById(R.id.NombreArchivo);
        etContenido=(EditText)findViewById(R.id.textoLines);
    }
    //metodo botonregresar
    public void Anterior(View view){
        Intent anterior=new Intent(this, MainActivity.class);
        startActivity(anterior);
    }
    //meotoo para el boton guaradar
    public void guardar(View view){
        String nombreArchivo=etNombre.getText().toString();
        String contenido= etContenido.getText().toString();
        try {
            File SD= Environment.getExternalStorageDirectory();
            Toast.makeText(this,SD.getPath(),Toast.LENGTH_SHORT).show();
            File rutaArchivo=new File(SD.getPath(),nombreArchivo);
            OutputStreamWriter crearArchivo=new OutputStreamWriter(openFileOutput(nombreArchivo, Activity.MODE_PRIVATE));
            crearArchivo.write(contenido);
            crearArchivo.flush();
            crearArchivo.close();
            Toast.makeText(this,"se guardo correctamente",Toast.LENGTH_SHORT).show();
            etNombre.setText("");
            etContenido.setText("");
        }catch (IOException e){
            Toast.makeText(this,"no se pudo guardar",Toast.LENGTH_SHORT).show();
        }
    }
    //para consultar
    public void consultar(View view){
        String nombreArchivo=etNombre.getText().toString();

        try {
            File SD=Environment.getExternalStorageDirectory();
            File rutaArchivo=new File(SD.getPath(),nombreArchivo);
            InputStreamReader abrirArchivo=new InputStreamReader(openFileInput(nombreArchivo));

            BufferedReader leerArchivo=new BufferedReader(abrirArchivo);
            String linea=leerArchivo.readLine();
            String ContenidoCompleto="";
            if (linea!=null){
                ContenidoCompleto=ContenidoCompleto+linea+"\n";
                linea=leerArchivo.readLine();

            }
            leerArchivo.close();
            abrirArchivo.close();
            etContenido.setText(ContenidoCompleto);
        }catch (IOException e){
            Toast.makeText(this,"error de lectura!!",Toast.LENGTH_SHORT).show();
        }
    }
}
