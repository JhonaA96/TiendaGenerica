package com.tienda.mintic.models;

import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
@Table(name="clientes")
public class Cliente {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    @Column
    private Long cedula_cliente;
    @Column
    private String direccion_cliente;
    @Column
    private String email_cliente;
    @Column
    private String nombre_cliente;
    @Column
    private Long telefono_cliente;
    @Column
    private boolean enabled = true;

    public Cliente(Long cedula_cliente, String direccion_cliente, String email_cliente, String nombre_cliente,
            Long telefono_cliente) {
        this.cedula_cliente = cedula_cliente;
        this.direccion_cliente = direccion_cliente;
        this.email_cliente = email_cliente;
        this.nombre_cliente = nombre_cliente;
        this.telefono_cliente = telefono_cliente;
    }

    public Cliente(){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCedula_cliente() {
        return cedula_cliente;
    }

    public void setCedula_cliente(Long cedula_cliente) {
        this.cedula_cliente = cedula_cliente;
    }

    public String getDireccion_cliente() {
        return direccion_cliente;
    }

    public void setDireccion_cliente(String direccion_cliente) {
        this.direccion_cliente = direccion_cliente;
    }

    public String getEmail_cliente() {
        return email_cliente;
    }

    public void setEmail_cliente(String email_cliente) {
        this.email_cliente = email_cliente;
    }

    public String getNombre_cliente() {
        return nombre_cliente;
    }

    public void setNombre_cliente(String nombre_cliente) {
        this.nombre_cliente = nombre_cliente;
    }

    public Long getTelefono() {
        return telefono_cliente;
    }

    public void setTelefono(Long telefono_cliente) {
        this.telefono_cliente = telefono_cliente;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    
}
