package com.example.konarr.contactos;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TabHost;
import android.widget.Toast;

import com.example.konarr.contactos.util.contactListAdapter;
import com.example.konarr.contactos.util.textChangedListener;
import com.example.konarr.contactos.util.contacto;

import java.util.ArrayList;
import java.util.List;

//toda info de contacto se agrega al adapter
public class MainActivity extends Activity {

    private EditText txt_nombre, txt_telefono, txt_email, txt_direccion;
    private ArrayAdapter<contacto> adapter;
    private ImageView img_contacto;
    private ListView contactsListView;
    private Button btn_agregar;
    private int request_code = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //alt+enter para crear el metodo
        inicializarComponentesUI();
        inicializarListaContactos();
        inicializarTabs();
    }

    private void inicializarListaContactos() {
        adapter = new contactListAdapter(this, new ArrayList<contacto>());
        contactsListView.setAdapter(adapter);
    }

    private void inicializarTabs() {
        TabHost th = (TabHost) findViewById(R.id.tabHost);
        th.setup();

        TabHost.TabSpec spec = th.newTabSpec("tab1");
        spec.setContent(R.id.tab1);
        spec.setIndicator("Crear");
        th.addTab(spec);

        spec = th.newTabSpec("tab2");
        spec.setContent(R.id.tab2);
        spec.setIndicator("Lista");
        th.addTab(spec);
    }

    private void inicializarComponentesUI() {
        txt_nombre = (EditText) findViewById(R.id.txt_nombre);
        txt_telefono = (EditText) findViewById(R.id.txt_telefono);
        txt_email = (EditText) findViewById(R.id.txt_email);
        txt_direccion = (EditText) findViewById(R.id.txt_direccion);
        img_contacto = (ImageView) findViewById(R.id.img_contacto);
        //se ejecuta cada vez que el user escribe o realiza algo
        txt_nombre.addTextChangedListener(new textChangedListener(){
            @Override
            public void onTextChanged(CharSequence seq, int i, int i2, int i3) {
                btn_agregar = (Button) findViewById(R.id.btn_agregar);
                btn_agregar.setEnabled(!seq.toString().trim().isEmpty());
            }
        });
        contactsListView = (ListView) findViewById(R.id.listView);
    }

    public void onClick(View view) {
        agregarContactos(
          txt_nombre.getText().toString(),
          txt_telefono.getText().toString(),
            txt_email.getText().toString(),
            txt_direccion.getText().toString(),
            //obtenemos el atributo TAG con la Uri de la imagen
            //TAG es un object y puede almacenar cualquier cosa
            (Uri) img_contacto.getTag()
        );
        String msg = String.format("%s ha sido agregado.", txt_nombre.getText());
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
        btn_agregar.setEnabled(false);
        limpiarCampos();
    }

    private void agregarContactos(String nombre, String telefono, String email, String direcccion, Uri image_uri) {
        contacto c = new contacto(nombre, telefono, email, direcccion, image_uri);
        adapter.add(c);
    }

    private void limpiarCampos() {
        txt_nombre.getText().clear();
        txt_telefono.getText().clear();
        txt_email.getText().clear();
        txt_direccion.getText().clear();
        //reestablecer la imagen predeterminada del contacto
        img_contacto.setImageResource(R.drawable.ic_imgcontacto);
        txt_nombre.requestFocus();
    }

    public void onImgClick(View view) {
        Intent intent = null;
        //verificando la version de la plataforma
        if(Build.VERSION.SDK_INT < 19){
            //android JellyBean 4.3 y anteriores
            intent = new Intent();
            intent.setAction(Intent.ACTION_GET_CONTENT);
        }else {
            //android kitkat 4.4 o superior
        }
        intent.setType("image/*");
        startActivityForResult(intent, request_code);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(resultCode == RESULT_OK && requestCode == request_code){
            img_contacto.setImageURI(data.getData());
            //utilizamos el atributo TAG para almacenar la Uri al archivo seleccionado
            img_contacto.setTag(data.getData());
        }
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
