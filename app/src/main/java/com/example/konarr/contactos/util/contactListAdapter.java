package com.example.konarr.contactos.util;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.konarr.contactos.R;

import java.util.List;

/**
 * Created by konarr on 23-09-14.
 */
public class contactListAdapter extends ArrayAdapter<contacto>{
    private Activity ctx;

    public contactListAdapter(Activity context, List<contacto> contactos) {
        super(context, R.layout.listview_item, contactos);
        this.ctx = context;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        if ( view == null)
            view = ctx.getLayoutInflater().inflate(R.layout.listview_item,parent, false);

        contacto actual = this.getItem(position);
        inicializarCamposDeTexto(view, actual);
        return view;

    }

    private void inicializarCamposDeTexto(View view, contacto actual) {
        TextView txt = (TextView) view.findViewById(R.id.txt_nombre);
        txt.setText(actual.getNombre());
        txt = (TextView) view.findViewById(R.id.txt_telefono);
        txt.setText(actual.getTelefono());
        txt = (TextView) view.findViewById(R.id.txt_email);
        txt.setText(actual.getEmail());
        txt = (TextView) view.findViewById(R.id.txt_direccion);
        txt.setText(actual.getDirecccion());
    }
}
