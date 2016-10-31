package com.notengoid.mismascotas;

import android.content.ContentValues;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.notengoid.mismascotas.commons.Constants;
import com.notengoid.mismascotas.commons.MailSender;
import com.notengoid.mismascotas.db.BaseDatos;

public class ConfiguracionActivity extends AppCompatActivity {

    private EditText etUsuarioConfiguracion;
    private Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_configuracion);
        Toolbar toolbar = (Toolbar) findViewById(R.id.appBar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        etUsuarioConfiguracion = (EditText) findViewById(R.id.etUsuarioConfiguracion);
    }

    public void cambiarUsuario(View view){
        String usuario = etUsuarioConfiguracion.getText().toString().trim().toLowerCase();
        this.context = view.getContext();
        switch (usuario){
            case "usuario1": cambiarToken(1);
                Log.e("ConfiguracionActivity", "usuario1");
                            break;
            case "usuario2": cambiarToken(2);
                Log.e("ConfiguracionActivity", "usuario2");
                            break;
        }

    }

    private void cambiarToken(int idtoken){

        BaseDatos db = new BaseDatos(this.context);
        ContentValues contentValues = new ContentValues();
        contentValues.put("id","1");
        contentValues.put("foto","1");

        if(idtoken == 1){
            contentValues.put("nombre","323216765.a94a053.fc442c9cc030426098487d879ad05d32");
        }else{
            contentValues.put("nombre","3259702353.aa0d0f4.e61865afc9144ecc8ffc8f6dc84aa17b");
        }

        db.updateMascota(contentValues);

    }
}
