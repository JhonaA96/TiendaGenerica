package com.tienda.mintic.models;

import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;
import javax.persistence.CascadeType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
@Table(name="detalle_ventas")
public class Detalles {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    @Column
    private Long codigo_detalle_venta;
    @Column
    private int cantidad_producto;
    @ManyToOne(cascade={CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH,})
    @JoinColumn(name = "codigo_producto")
    private Producto codigo_producto;
    @ManyToOne(cascade={CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH,})
    @JoinColumn(name = "codigo_venta")
    private Ventas codigo_venta;
    @Column
    private double valor_total;
    @Column
    private double valor_venta;
    @Column
    private double iva_venta;
    
    public Detalles(Long codigo_detalle_venta, int cantidad_producto, Producto codigo_producto, Ventas codigo_venta,
            double valor_total, double valor_venta, double iva_venta) {
        this.codigo_detalle_venta = codigo_detalle_venta;
        this.cantidad_producto = cantidad_producto;
        this.codigo_producto = codigo_producto;
        this.codigo_venta = codigo_venta;
        this.valor_total = valor_total;
        this.valor_venta = valor_venta;
        this.iva_venta = iva_venta;
    }

    public Detalles() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCodigo_detalle_venta() {
        return codigo_detalle_venta;
    }

    public void setCodigo_detalle_venta(Long codigo_detalle_venta) {
        this.codigo_detalle_venta = codigo_detalle_venta;
    }

    public int getCantidad_producto() {
        return cantidad_producto;
    }

    public void setCantidad_producto(int cantidad_producto) {
        this.cantidad_producto = cantidad_producto;
    }

    public Producto getCodigo_producto() {
        return codigo_producto;
    }

    public void setCodigo_producto(Producto codigo_producto) {
        this.codigo_producto = codigo_producto;
    }

    public Ventas getCodigo_venta() {
        return codigo_venta;
    }

    public void setCodigo_venta(Ventas codigo_venta) {
        this.codigo_venta = codigo_venta;
    }

    public double getValor_total() {
        return valor_total;
    }

    public void setValor_total(double valor_total) {
        this.valor_total = valor_total;
    }

    public double getValor_venta() {
        return valor_venta;
    }

    public void setValor_venta(double valor_venta) {
        this.valor_venta = valor_venta;
    }

    public double getIva_venta() {
        return iva_venta;
    }

    public void setIva_venta(double iva_venta) {
        this.iva_venta = iva_venta;
    }

    

}