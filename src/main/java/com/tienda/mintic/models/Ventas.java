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
@Table(name="ventas")
public class Ventas {
    @Id
    private Long codigo_venta;
    @ManyToOne(cascade={CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH,})
    @JoinColumn(name = "cedula_cliente")
    private Cliente cedula_cliente;
    @ManyToOne(cascade={CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH,})
    @JoinColumn(name = "cedula_usuario")
    private Usuario cedula_usuario;
    @Column
    private Double iva_venta;
    @Column
    private Double total_venta;
    @Column
    private Double valor_venta;

    @OneToMany(mappedBy = "codigo_venta", cascade={CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH,})
    private List<Detalles> detalles;

    public void agregarVentas(Detalles detalle){
        if(detalles == null) detalles = new ArrayList<>();
        detalles.add(detalle);
        detalle.setCodigo_venta(this);
    }
    
    public Ventas(Long codigo_venta, Cliente cedula_cliente, Usuario cedula_usuario, Double iva_venta,
            Double total_venta, Double valor_venta) {
        this.codigo_venta = codigo_venta;
        this.cedula_cliente = cedula_cliente;
        this.cedula_usuario = cedula_usuario;
        this.iva_venta = iva_venta;
        this.total_venta = total_venta;
        this.valor_venta = valor_venta;
    }

    public Ventas() {
    }

    public Long getCodigo_venta() {
        return codigo_venta;
    }

    public void setCodigo_venta(Long codigo_venta) {
        this.codigo_venta = codigo_venta;
    }

    public Cliente getCedula_cliente() {
        return cedula_cliente;
    }

    public void setCedula_cliente(Cliente cedula_cliente) {
        this.cedula_cliente = cedula_cliente;
    }

    public Usuario getCedula_usuario() {
        return cedula_usuario;
    }

    public void setCedula_usuario(Usuario cedula_usuario) {
        this.cedula_usuario = cedula_usuario;
    }

    public Double getIva_venta() {
        return iva_venta;
    }

    public void setIva_venta(Double iva_venta) {
        this.iva_venta = iva_venta;
    }

    public Double getTotal_venta() {
        return total_venta;
    }

    public void setTotal_venta(Double total_venta) {
        this.total_venta = total_venta;
    }

    public Double getValor_venta() {
        return valor_venta;
    }

    public void setValor_venta(Double valor_venta) {
        this.valor_venta = valor_venta;
    }
}