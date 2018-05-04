package com.cosw.eci.brothergames_android.brothergames_android.entity;



public class User {

    private byte[] bytes;
    private String id, correo, password, nombre ,description;
    private boolean active;

    public byte[] getBytes() {
        return bytes;
    }

    public void setBytes(byte[] bytes) {
        this.bytes = bytes;
    }


    public User() {
    }

    public User(boolean active) {
        this.active = active;
    }

    public User(String id, String correo, String password, String nombre, String description) {
        this.id = id;
        this.correo = correo;
        this.password = password;
        this.nombre = nombre;
        this.description=description;
    }

    public User(String id, String correo, String password,byte[] bytes, String nombre, String description) {
        this.bytes = bytes;
        this.id = id;
        this.correo = correo;
        this.password = password;
        this.nombre = nombre;
        this.description=description;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public void setPassword(String pass) {
        this.password = pass;
    }

    public String getId() {
        return id;
    }

    public String getCorreo() {
        return correo;
    }

    public String getPassword() {
        return password;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}
