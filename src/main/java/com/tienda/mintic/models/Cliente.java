package com.tienda.mintic.models;

import java.util.List;
import java.util.ArrayList;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.CascadeType;

@Entity
@Table(name="clientes")
public class Cliente {
    @Id
    @Column
    private Long cedula_cliente;
    @Column
    private String direccion_cliente;
    @Column
    private String email_cliente;
    @Column
    private String nombre_cliente;
    @Column
    private String telefono_cliente;

    @OneToMany(mappedBy = "cedula_cliente", cascade={CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH,})
    private List<Ventas> ventas;

    public void agregarVentas(Ventas venta){
        if(ventas == null) ventas = new ArrayList<>();
        ventas.add(venta);
        venta.setCedula_cliente(this);
    }

    public Cliente(Long cedula_cliente, String direccion_cliente, String email_cliente, String nombre_cliente,
            String telefono_cliente) {
        this.cedula_cliente = cedula_cliente;
        this.direccion_cliente = direccion_cliente;
        this.email_cliente = email_cliente;
        this.nombre_cliente = nombre_cliente;
        this.telefono_cliente = telefono_cliente;
    }

    public Cliente(){

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

    public String getTelefono() {
        return telefono_cliente;
    }

    public void setTelefono(String telefono_cliente) {
        this.telefono_cliente = telefono_cliente;
    }
    
}
