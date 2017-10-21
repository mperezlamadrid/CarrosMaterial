package com.example.manuelperez.carrosmaterial;

import android.content.Context;
import android.content.res.Resources;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by manuelperez on 10/21/17.
 */

//public class AdaptadorCarro extends BaseAdapter {
public class AdaptadorCarro extends RecyclerView.Adapter<AdaptadorCarro.CarroViewHolder> {
    private ArrayList<Carro> carros;
    private Resources res;
    private OnCarroClickListener clickListener;
    private String textMarca[], textModelo[], textColor[];

    public AdaptadorCarro(Context contexto, ArrayList<Carro> carros, OnCarroClickListener clickListener){
        this.carros = carros;
        res = contexto.getResources();
        this.clickListener = clickListener;
    }

    @Override
    public CarroViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_carro, parent, false);
        return new CarroViewHolder(v);
    }

    @Override
    public void onBindViewHolder(CarroViewHolder holder, int position) {
        final Carro c = carros.get(position);

        textMarca = res.getStringArray(R.array.arr_marca);
        textModelo = res.getStringArray(R.array.arr_modelo);
        textColor = res.getStringArray(R.array.arr_color);

        holder.foto.setImageDrawable(ResourcesCompat.getDrawable(res, c.getFoto(), null));
        holder.placa.setText(c.getPlaca());
        holder.color.setText(textColor[c.getColor()]);
        holder.modelo.setText(textModelo[c.getModelo()]);
        holder.precio.setText("$ " + c.getPrecio());
        holder.marca.setText(textMarca[c.getMarca()]);

        holder.v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickListener.onPersonaClick(c);
            }
        });
    }

    @Override
    public int getItemCount() {
        return carros.size();
    }

    public static class CarroViewHolder extends RecyclerView.ViewHolder{
        private ImageView foto;
        private TextView placa;
        private TextView color;
        private TextView modelo;
        private TextView precio;
        private TextView marca;
        private View v;

        public CarroViewHolder(View itemView){
            super(itemView);
            v = itemView;

            foto = (ImageView)itemView.findViewById(R.id.imgFoto);
            placa = (TextView)itemView.findViewById(R.id.lblPlaca);
            color = (TextView)itemView.findViewById(R.id.lblColor);
            modelo = (TextView)itemView.findViewById(R.id.lblModelo);
            precio = (TextView)itemView.findViewById(R.id.lblPrecio);
            marca = (TextView)itemView.findViewById(R.id.lblMarca);
        }
    }

    public interface OnCarroClickListener{
        void onPersonaClick(Carro c);
    }
}
