package com.example.manuelperez.carrosmaterial;

import android.content.Intent;
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

public class EditarCarro extends AppCompatActivity {
    private EditText txtPlacaE, txtPrecioE;
    private TextInputLayout cajaPlacaE, cajaPrecioE;
    private Resources res;
    private Spinner marcaE, modeloE, colorE;
    private int foto, precio, marca, modelo, color;
    private ArrayAdapter<String> adapter, adapter1, adapter2;
    private String[] marcaOpcE, modeloOpcE, colorOpcE;
    private Bundle bundle;
    private Intent i;
    private String placa, id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar_carro);

        txtPlacaE = (EditText) findViewById(R.id.txtPlacaE);
        txtPrecioE = (EditText) findViewById(R.id.txtPrecioE);
        cajaPlacaE = (TextInputLayout) findViewById(R.id.cajaPlacaE);
        cajaPrecioE = (TextInputLayout) findViewById(R.id.cajaPrecioE);

        res = this.getResources();

        marcaE = (Spinner) findViewById(R.id.cmbMarcaE);
        modeloE = (Spinner) findViewById(R.id.cmbModeloE);
        colorE = (Spinner) findViewById(R.id.cmbColorE);

        marcaOpcE = res.getStringArray(R.array.arr_marca);
        adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,marcaOpcE);
        marcaE.setAdapter(adapter);

        modeloOpcE = res.getStringArray(R.array.arr_modelo);
        adapter1 = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,modeloOpcE);
        modeloE.setAdapter(adapter1);

        colorOpcE = res.getStringArray(R.array.arr_color);
        adapter2 = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,colorOpcE);
        colorE.setAdapter(adapter2);

        i = getIntent();
        bundle = i.getBundleExtra("datos");

        id = bundle.getString("id");
        placa = bundle.getString("placa");
        marca = bundle.getInt("marca");
        modelo = bundle.getInt("modelo");
        color = bundle.getInt("color");
        precio = bundle.getInt("precio");
        foto = bundle.getInt("foto");

        txtPlacaE.setText(placa);
        marcaE.setSelection(marca);
        modeloE.setSelection(modelo);
        colorE.setSelection(color);
        txtPrecioE.setText("" + precio);
    }

    public void editar(View v){
        String pla = txtPlacaE.getText().toString();
        String pre = txtPrecioE.getText().toString();

        if (validarE()){
            Carro c = new Carro(id, pla, marcaE.getSelectedItemPosition(), modeloE.getSelectedItemPosition(),
                    colorE.getSelectedItemPosition(), Integer.parseInt(pre), foto);
            c.editar();
            Snackbar.make(v, res.getString(R.string.carro_editada_correctamente), Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show();
            onBackPressedE();
        }
    }

    public boolean validarE(){
        if (validarAuxE(txtPlacaE, cajaPrecioE)) return false;
        else if (validarAuxE(txtPrecioE, cajaPrecioE)) return false;
        else if (Metodos.existenciaDeCarroE(Datos.obtenerCarros(), txtPlacaE.getText().toString(), placa)) {
            txtPlacaE.setError(res.getString(R.string.carro_existente_error));
            txtPlacaE.requestFocus();
            return false;
        }

        return true;
    }

    public boolean validarAuxE(TextView t, TextInputLayout ct){
        if (t.getText().toString().isEmpty()){
            t.requestFocus();
            t.setError(getString(R.string.no_vacio));
            return true;
        }

        return false;
    }

    public void limpiar(View v){
        limpiar();
    }

    public void limpiar(){
        txtPlacaE.setText("");
        txtPrecioE.setText("");

        marcaE.setSelection(0);
        modeloE.setSelection(0);
        colorE.setSelection(0);

        txtPlacaE.requestFocus();
    }

    public void onBackPressedE(){
        Intent i = new Intent(this, DetalleCarro.class);
        Bundle b3 = new Bundle();

        b3.putString("id", id);
        b3.putInt("foto", foto);
        b3.putString("placa", txtPlacaE.getText().toString());
        b3.putInt("marca", marcaE.getSelectedItemPosition());
        b3.putInt("modelo", modeloE.getSelectedItemPosition());
        b3.putInt("color", colorE.getSelectedItemPosition());
        b3.putInt("precio", Integer.parseInt(txtPrecioE.getText().toString()));

        i.putExtra("datos", b3);
        startActivity(i);
    }
}
