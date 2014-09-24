package com.example.konarr.contactos;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.konarr.contactos.util.textChangedListener;


public class MainActivity extends Activity {

    private EditText txt_nombre, txt_telefono, txt_email, txt_direccion;
    private Button btn_agregar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //alt+enter para crear el metodo
        inicializarComponentesUI();
    }

    private void inicializarComponentesUI() {
        txt_nombre = (EditText) findViewById(R.id.txt_nombre);
        txt_telefono = (EditText) findViewById(R.id.txt_telefono);
        txt_email = (EditText) findViewById(R.id.txt_email);
        txt_direccion = (EditText) findViewById(R.id.txt_direccion);

        //se ejecuta cada vez que el user escribe o realiza algo
        txt_nombre.addTextChangedListener(new textChangedListener(){
            @Override
            public void onTextChanged(CharSequence seq, int i, int i2, int i3) {
                btn_agregar = (Button) findViewById(R.id.btn_agregar);
                btn_agregar.setEnabled(!seq.toString().trim().isEmpty());
            }
        });
    }

    public void onClick(View view) {
        String msg = String.format("%s ha sido agregado.", txt_nombre.getText());
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
        btn_agregar.setEnabled(false);
        limpiarCampos();
    }

    private void limpiarCampos() {
        txt_nombre.getText().clear();
        txt_telefono.getText().clear();
        txt_email.getText().clear();
        txt_direccion.getText().clear();
        txt_nombre.requestFocus();
    }







    /*@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }*/
}