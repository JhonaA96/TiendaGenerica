package com.tienda.mintic.models;

import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
@Table(name="proveedor")
public class Proveedor {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    @Column
    private Long nit_proveedor;
    @Column
    private String ciudad_proveedor;
    @Column
    private String direccion_proveedor;
    @Column
    private String nombre_proveedor;
    @Column
    private int telefono_proveedor;

    public Proveedor(Long nit_proveedor, String ciudad_proveedor, String direccion_proveedor, String nombre_proveedor,
            int telefono_proveedor) {
        this.nit_proveedor = nit_proveedor;
        this.ciudad_proveedor = ciudad_proveedor;
        this.direccion_proveedor = direccion_proveedor;
        this.nombre_proveedor = nombre_proveedor;
        this.telefono_proveedor = telefono_proveedor;
    }

    public Proveedor(){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getNit_proveedor() {
        return nit_proveedor;
    }

    public void setNit_proveedor(Long nit_proveedor) {
        this.nit_proveedor = nit_proveedor;
    }

    public String getCiudad_proveedor() {
        return ciudad_proveedor;
    }

    public void setCiudad_proveedor(String ciudad_proveedor) {
        this.ciudad_proveedor = ciudad_proveedor;
    }

    public String getDireccion_proveedor() {
        return direccion_proveedor;
    }

    public void setDireccion_proveedor(String direccion_proveedor) {
        this.direccion_proveedor = direccion_proveedor;
    }

    public String getNombre_proveedor() {
        return nombre_proveedor;
    }

    public void setNombre_proveedor(String nombre_proveedor) {
        this.nombre_proveedor = nombre_proveedor;
    }

    public int getTelefono_proveedor() {
        return telefono_proveedor;
    }

    public void setTelefono_proveedor(int telefono_proveedor) {
        this.telefono_proveedor = telefono_proveedor;
    }
    
    
}
