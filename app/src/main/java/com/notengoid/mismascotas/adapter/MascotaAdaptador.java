package com.notengoid.mismascotas.adapter;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.notengoid.mismascotas.model.ConstructorMascotas;
import com.notengoid.mismascotas.model.Mascota;
import com.notengoid.mismascotas.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import static android.support.v7.widget.RecyclerView.*;

/**
 * Created by Asus on 3/09/2016.
 */
public class MascotaAdaptador extends RecyclerView.Adapter<MascotaAdaptador.MascotaViewHolder> {

    List<Mascota> mascotas;
    Activity activity;

    public MascotaAdaptador(List<Mascota> mascotas, Activity activity){
        this.mascotas = mascotas;
        this.activity = activity;

        if(mascotas == null){
            this.mascotas = new ArrayList<>();
        }
    }

    public static class MascotaViewHolder extends ViewHolder{

        private ImageView imgFoto;
        private TextView tvLikes;

        public MascotaViewHolder(View itemView) {
            super(itemView);
            imgFoto = (ImageView) itemView.findViewById(R.id.imgFoto);
            tvLikes = (TextView) itemView.findViewById(R.id.tvLikes);
        }
    }

    @Override
    public MascotaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_grid_mascota,parent,false);
        return new MascotaViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final MascotaViewHolder holder, final int position) {
        final Mascota mascota = mascotas.get(position);
        Picasso.with(activity)
                .load(mascota.getUrlFoto())
                .placeholder(R.drawable.shock_rave_bonus_icon)
                .into(holder.imgFoto);
        holder.tvLikes.setText("" + mascota.getLikes());

        //holder.imgFoto.setOnClickListener((v)-> {
            //Intent intent = new Intent(activity, DetalleMascota.class);
            //intent.putExtra("url", mascota.getUrlFoto());
            //intent.putExtra("like", mascota.getLikes());
            //activity.startActivity(intent);
        //});
    }

    @Override
    public int getItemCount() {
        return mascotas.size();
    }

}
