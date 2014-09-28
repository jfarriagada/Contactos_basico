package com.example.konarr.contactos.util;

import android.net.Uri;

import java.net.URI;

/**
 * Created by konarr on 23-09-14.
 */
public class contacto {
    private String nombre, telefono, email, direcccion;
    private Uri image_uri;

    public contacto(String nombre, String telefono, String email, String direcccion, Uri image_uri) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.email = email;
        this.direcccion = direcccion;
        this.image_uri = image_uri;
    }

    //<editor-fold desc="GETTER METHODS">
    public String getNombre() {
        return nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getEmail() {
        return email;
    }

    public String getDirecccion() {
        return direcccion;
    }

    public Uri getImage_uri() {
        return image_uri;
    }
    //</editor-fold>


    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setDirecccion(String direcccion) {
        this.direcccion = direcccion;
    }

    public void setImage_uri(Uri image_uri) {
        this.image_uri = image_uri;
    }
}
