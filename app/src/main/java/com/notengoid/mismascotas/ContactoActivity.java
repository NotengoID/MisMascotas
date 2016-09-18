package com.notengoid.mismascotas;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.notengoid.mismascotas.commons.Constants;
import com.notengoid.mismascotas.commons.MailSender;

public class ContactoActivity extends AppCompatActivity {

    private EditText etContactoEmail;
    private EditText etContactoNombre;
    private EditText etContactoMensaje;

    private Button btnEnviarMail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacto);

        etContactoEmail = (EditText) findViewById(R.id.etContactoEmail);
        etContactoNombre = (EditText) findViewById(R.id.etContactoNombre);
        etContactoMensaje = (EditText) findViewById(R.id.etContactoMensaje);

    }

    public void sendEmail(View view) {
        String email = etContactoEmail.getText().toString().trim();
        String nombre = Constants.SUBJECT + etContactoNombre.getText().toString().trim();
        String message = etContactoMensaje.getText().toString().trim();
        MailSender sm = new MailSender(this, email, nombre, message);
        sm.execute();
    }
}
