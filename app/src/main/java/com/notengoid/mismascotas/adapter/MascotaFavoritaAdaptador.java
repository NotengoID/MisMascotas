package com.notengoid.mismascotas.adapter;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.notengoid.mismascotas.R;
import com.notengoid.mismascotas.model.Mascota;
import com.squareup.picasso.Picasso;

import java.util.List;

import static android.support.v7.widget.RecyclerView.Adapter;

/**
 * Created by Asus on 3/09/2016.
 */
public class MascotaFavoritaAdaptador extends Adapter<MascotaFavoritaAdaptador.MascotaFavoritaViewHolder> {

    List<Mascota> mascotas;
    Activity activity;

    public MascotaFavoritaAdaptador(List<Mascota> mascotas, Activity activity){
        this.mascotas = mascotas;
        this.activity = activity;
    }

    public static class MascotaFavoritaViewHolder extends RecyclerView.ViewHolder{

        private ImageView imgFotoCVFav;
        private TextView tvNombreCVFav;
        private TextView tvLikesCVFav;

        public MascotaFavoritaViewHolder(View itemView) {
            super(itemView);
            imgFotoCVFav = (ImageView) itemView.findViewById(R.id.imgFotoCVFav);
            tvNombreCVFav = (TextView) itemView.findViewById(R.id.tvNombreCVFav);
            tvLikesCVFav = (TextView) itemView.findViewById(R.id.tvLikesCVFav);
        }
    }

    @Override
    public MascotaFavoritaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_mascota_favorita,parent,false);
        return new MascotaFavoritaViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final MascotaFavoritaViewHolder holder, final int position) {
        final Mascota mascota = mascotas.get(position);
        Picasso.with(activity)
                .load(mascota.getUrlFoto())
                .placeholder(R.drawable.shock_rave_bonus_icon)
                .into(holder.imgFotoCVFav);
        holder.tvNombreCVFav.setText(mascota.getNombreCompleto());
        holder.tvLikesCVFav.setText("" + mascota.getLikes());
    }

    @Override
    public int getItemCount() {
        return mascotas.size();
    }

}
