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

@Entity
@Table(name="productos")
public class Producto {
    @Id
    private Long codigo_producto;
    @Column
    private Double iva_compra;
    @ManyToOne
    @JoinColumn(name = "nit_proveedor")
    private Proveedor nit_proveedor;
    @Column
    private String nombre_producto;
    @Column
    private Double precio_compra;
    @Column
    private Double precio_venta;

    @OneToMany(mappedBy = "codigo_producto", cascade={CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH,})
    private List<Detalles> detalles;

    public void agregarVentas(Detalles detalle){
        if(detalles == null) detalles = new ArrayList<>();
        detalles.add(detalle);
        detalle.setCodigo_producto(this);
    }
    
    public Producto(Long codigo_producto, double iva_compra, Proveedor nit_proveedor, String nombre_producto,
            Double precio_compra, Double precio_venta) {
        this.codigo_producto = codigo_producto;
        this.iva_compra = iva_compra;
        this.nit_proveedor = nit_proveedor;
        this.nombre_producto = nombre_producto;
        this.precio_compra = precio_compra;
        this.precio_venta = precio_venta;
    }

    public Producto() {
    }

    public Long getCodigo_producto() {
        return codigo_producto;
    }

    public void setCodigo_producto(Long codigo_producto) {
        this.codigo_producto = codigo_producto;
    }

    public Double getIva_compra() {
        return iva_compra;
    }

    public void setIva_compra(Double iva_compra) {
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

    public Double getPrecio_compra() {
        return precio_compra;
    }

    public void setPrecio_compra(Double precio_compra) {
        this.precio_compra = precio_compra;
    }

    public Double getPrecio_venta() {
        return precio_venta;
    }

    public void setPrecio_venta(Double precio_venta) {
        this.precio_venta = precio_venta;
    }
    
    
}
