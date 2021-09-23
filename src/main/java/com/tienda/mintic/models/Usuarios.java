package com.tienda.mintic.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;


@Entity
@Table(name="usuarios")
public class Usuarios {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    @Column
    private int cedula_usuario;
    @Column
    private String email_usuario;
    @Column
    private String nombre_usuario;
    @Column
    private String password;
    @Column
    private String usuario;

    public Usuarios(int cedula_usuario, String email_usuario, String nombre_usuario, String password, String usuario) {
        this.cedula_usuario = cedula_usuario;
        this.email_usuario = email_usuario;
        this.nombre_usuario = nombre_usuario;
        this.password = password;
        this.usuario = usuario;
    }

    public Usuarios(){

    }

    public int id() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCedula_usuario() {
        return cedula_usuario;
    }

    public void setCedula_usuario(int cedula_usuario) {
        this.cedula_usuario = cedula_usuario;
    }

    public String getEmail_usuario() {
        return email_usuario;
    }

    public void setEmail_usuario(String email_usuario) {
        this.email_usuario = email_usuario;
    }

    public String getNombre_usuario() {
        return nombre_usuario;
    }

    public void setNombre_usuario(String nombre_usuario) {
        this.nombre_usuario = nombre_usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
}
