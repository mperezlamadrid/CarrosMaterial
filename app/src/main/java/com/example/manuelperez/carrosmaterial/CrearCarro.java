package com.example.manuelperez.carrosmaterial;

import android.content.res.Resources;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

public class CrearCarro extends AppCompatActivity {
    private String [] marca, modelo, color;
    private Spinner sMarca, sModelo, sColor;
    private EditText tPlaca, tPrecio;
    private TextInputLayout cajaPlaca;
    private TextInputLayout cajaPrecio;
    private Resources res;
    private ArrayList<Integer> fotos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_carro);

        sMarca = (Spinner) findViewById(R.id.cmbMarca);
        sModelo = (Spinner) findViewById(R.id.cmbModelo);
        sColor = (Spinner) findViewById(R.id.cmbColor);

        tPlaca = (EditText)findViewById(R.id.txtPlaca);
        tPrecio = (EditText)findViewById(R.id.txtPrecio);
        cajaPlaca = (TextInputLayout) findViewById(R.id.cajaPlaca);
        cajaPrecio = (TextInputLayout)findViewById(R.id.cajaPrecio);

        res = this.getResources();

        iniciar_fotos();

        marca = res.getStringArray(R.array.arr_marca);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,marca);
        sMarca.setAdapter(adapter);

        modelo = res.getStringArray(R.array.arr_modelo);
        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,modelo);
        sModelo.setAdapter(adapter1);

        color = res.getStringArray(R.array.arr_color);
        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,color);
        sColor.setAdapter(adapter2);
    }

    public void iniciar_fotos(){
        fotos = new ArrayList<>();
        fotos.add(R.drawable.images);
        fotos.add(R.drawable.images2);
        fotos.add(R.drawable.images3);
    }

    public void guardar(View v){
        if(validar()) {
            Carro c = new Carro(tPlaca.getText().toString(), sMarca.getSelectedItemPosition(), sModelo.getSelectedItemPosition(),
                    sColor.getSelectedItemPosition(), Integer.parseInt(tPrecio.getText().toString()), Metodos.fotoAleatoria(fotos));

            c.guardar();

            Snackbar.make(v, res.getString(R.string.mensaje_guardado), Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show();
            limpiar();
        }
    }

    public void limpiar(View v){
        limpiar();
    }

    public void limpiar(){
        tPlaca.setText("");
        tPrecio.setText("");

        sMarca.setSelection(0);
        sModelo.setSelection(0);
        sColor.setSelection(0);

        tPlaca.requestFocus();
    }

    public boolean validar(){
        if (validar_aux(tPlaca, cajaPlaca)) return false;
        else  if (validar_aux(tPrecio,cajaPrecio)) return false;
        else if (Metodos.exitenciaDeCarro(Datos.obtenerCarros(), tPlaca.getText().toString())){
            tPlaca.setError(res.getString(R.string.carro_existente_error));
            tPlaca.requestFocus();
            return false;
        }
        return true;
    }

    public boolean validar_aux(TextView t, TextInputLayout ct){
        if (t.getText().toString().isEmpty()){
            t.requestFocus();
            t.setError(res.getString(R.string.no_vacio_error));
            return true;
        }
        return false;
    }
}
