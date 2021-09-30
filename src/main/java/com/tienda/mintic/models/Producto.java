package com.tienda.mintic.models;

import java.util.List;
import java.util.ArrayList;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;
import javax.persistence.CascadeType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
@Table(name="productos")
public class Producto {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    @Column
    private Long codigo_producto;
    @Column
    private double iva_compra;
    @ManyToOne(cascade={CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH,})
    @JoinColumn(name = "nit_proveedor")
    private Proveedor nit_proveedor;
    @Column
    private String nombre_producto;
    @Column
    private double precio_compra;
    @Column
    private double precio_venta;

    @OneToMany(mappedBy = "codigo_producto", cascade={CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH,})
    private List<Detalles> detalles;

    public void agregarVentas(Detalles detalle){
        if(detalles == null) detalles = new ArrayList<>();
        detalles.add(detalle);
        detalle.setCodigo_producto(this);
    }
    
    public Producto(Long codigo_producto, double iva_compra, Proveedor nit_proveedor, String nombre_producto,
            double precio_compra, double precio_venta) {
        this.codigo_producto = codigo_producto;
        this.iva_compra = iva_compra;
        this.nit_proveedor = nit_proveedor;
        this.nombre_producto = nombre_producto;
        this.precio_compra = precio_compra;
        this.precio_venta = precio_venta;
    }

    public Producto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCodigo_producto() {
        return codigo_producto;
    }

    public void setCodigo_producto(Long codigo_producto) {
        this.codigo_producto = codigo_producto;
    }

    public double getIva_compra() {
        return iva_compra;
    }

    public void setIva_compra(double iva_compra) {
        this.iva_compra = iva_compra;
    }

    public Proveedor getProveedor() {
        return nit_proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.nit_proveedor = proveedor;
    }

    public String getNombre_producto() {
        return nombre_producto;
    }

    public void setNombre_producto(String nombre_producto) {
        this.nombre_producto = nombre_producto;
    }

    public double getPrecio_compra() {
        return precio_compra;
    }

    public void setPrecio_compra(double precio_compra) {
        this.precio_compra = precio_compra;
    }

    public double getPrecio_venta() {
        return precio_venta;
    }

    public void setPrecio_venta(double precio_venta) {
        this.precio_venta = precio_venta;
    }
    
    
}
