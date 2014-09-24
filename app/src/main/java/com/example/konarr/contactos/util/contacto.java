package com.example.konarr.contactos.util;

/**
 * Created by konarr on 23-09-14.
 */
public class contacto {
    private String nombre, telefono, email, direcccion;

    public contacto(String nombre, String telefono, String email, String direcccion) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.email = email;
        this.direcccion = direcccion;
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
}
