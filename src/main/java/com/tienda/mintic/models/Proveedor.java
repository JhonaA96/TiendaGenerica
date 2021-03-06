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
@Table(name="proveedores")
public class Proveedor {
    @Id
    private Long nit_proveedor;
    @Column
    private String ciudad_proveedor;
    @Column
    private String direccion_proveedor;
    @Column
    private String nombre_proveedor;
    @Column
    private String telefono_proveedor;
    @OneToMany(mappedBy = "nit_proveedor", cascade={CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH,})
    private List<Producto> productos;

    public void agregarProducto(Producto producto){
        if(productos == null) productos = new ArrayList<>();
        productos.add(producto);
        producto.setProveedor(this);
    }

    public Proveedor(Long nit_proveedor, String ciudad_proveedor, String direccion_proveedor, String nombre_proveedor,
            String telefono_proveedor) {
        this.nit_proveedor = nit_proveedor;
        this.ciudad_proveedor = ciudad_proveedor;
        this.direccion_proveedor = direccion_proveedor;
        this.nombre_proveedor = nombre_proveedor;
        this.telefono_proveedor = telefono_proveedor;
    }

    public Proveedor(){

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

    public String getTelefono_proveedor() {
        return telefono_proveedor;
    }

    public void setTelefono_proveedor(String telefono_proveedor) {
        this.telefono_proveedor = telefono_proveedor;
    }
    
    
}
