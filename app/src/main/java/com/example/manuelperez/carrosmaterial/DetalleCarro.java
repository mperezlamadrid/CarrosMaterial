package com.example.manuelperez.carrosmaterial;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class DetalleCarro extends AppCompatActivity {
    private CollapsingToolbarLayout collapsingToolbarLayout;
    private Carro c;
    private String vPlaca, id;
    private int fot, vMarca, vModelo, vColor, vPrecio;
    private Bundle bundle;
    private Intent i;
    private ImageView foto;
    private Resources res;
    private TextView placa, precio, marca, modelo, color;
    private String [] opc;
    private String textMarca[], textModelo[], textColor[];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_carro);

        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar2);
        setSupportActionBar(toolbar);

        placa =(TextView)findViewById(R.id.lblPlaca);
        marca = (TextView)findViewById(R.id.lblMarca);
        modelo = (TextView)findViewById(R.id.lblModelo);
        color = (TextView)findViewById(R.id.lblColor);
        precio = (TextView)findViewById(R.id.lblPrecio);

        collapsingToolbarLayout = (CollapsingToolbarLayout)findViewById(R.id.collapsing_toolbar);
        foto = (ImageView) findViewById(R.id.fotoPersona);

        res = this.getResources();

        i = getIntent();
        bundle = i.getBundleExtra("datos");

        id = bundle.getString("id");
        vPlaca = bundle.getString("placa");
        vMarca = bundle.getInt("marca");
        vModelo = bundle.getInt("modelo");
        vColor = bundle.getInt("color");
        vPrecio = bundle.getInt("precio");
        fot = bundle.getInt("foto");

        textMarca = res.getStringArray(R.array.arr_marca);
        textModelo = res.getStringArray(R.array.arr_modelo);
        textColor = res.getStringArray(R.array.arr_color);

        collapsingToolbarLayout.setTitle(vPlaca +" - "+textMarca[vMarca]+" "+textModelo[vModelo]);
        foto.setImageDrawable(ResourcesCompat.getDrawable(res,fot,null));

        placa.setText(vPlaca);
        marca.setText(textMarca[vMarca]);
        modelo.setText(textModelo[vModelo]);
        color.setText(textColor[vColor]);
        precio.setText("$ " + vPrecio);
    }

    public void eliminar(View v){
        String positivo,negativo;

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(res.getString(R.string.titulo_eliminar_mensaje));
        builder.setMessage(res.getString(R.string.eliminar_mensaje));
        positivo = res.getString(R.string.si_eliminar_mensaje);
        negativo = res.getString(R.string.no_eliminar_mensaje);

        builder.setPositiveButton(positivo, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Carro p = new Carro(id);
                p.eliminar();
                onBackPressed();

            }
        });

        builder.setNegativeButton(negativo, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });

        AlertDialog dialog = builder.create();
        dialog.show();
    }

    public void editar(View v){
        Intent i = new Intent(DetalleCarro.this, EditarCarro.class);
        Bundle b2 = new Bundle();

        b2.putString("id", id);
        b2.putString("placa", vPlaca);
        b2.putInt("marca", vMarca);
        b2.putInt("modelo", vModelo);
        b2.putInt("color", vColor);
        b2.putInt("precio", vPrecio);
        b2.putInt("foto", fot);

        i.putExtra("datos", b2);

        startActivity(i);
    }

    public void onBackPressed(){
        finish();
        Intent i = new Intent(DetalleCarro.this, Principal.class);
        startActivity(i);
    }

}
