package com.tienda.mintic.models;

import java.util.List;
import java.util.ArrayList;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.CascadeType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
@Table(name="usuarios")
public class Usuario {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    @Column
    private Long cedula_usuario;
    @Column
    private String email_usuario;
    @Column
    private String nombre_usuario;
    @Column
    private String password;
    @Column
    private String usuario;
    @Column
    private boolean enabled = true;

    @OneToMany(mappedBy = "cedula_cliente", cascade={CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH,})
    private List<Ventas> ventas;

    public void agregarVentas(Ventas venta){
        if(ventas == null) ventas = new ArrayList<>();
        ventas.add(venta);
        venta.setCedula_usuario(this);
    }

    public Usuario(Long cedula_usuario, String email_usuario, String nombre_usuario, String password, String usuario) {
        this.cedula_usuario = cedula_usuario;
        this.email_usuario = email_usuario;
        this.nombre_usuario = nombre_usuario;
        this.password = password;
        this.usuario = usuario;
    }
    public Usuario(){

    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Long getCedula_usuario() {
        return cedula_usuario;
    }
    public void setCedula_usuario(Long cedula_usuario) {
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
    public boolean isEnabled() {
        return enabled;
    }
    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

/*     @Override
    public String toString() {
        return "Usuarios [authority=" + authority + ", cedula_usuario=" + cedula_usuario + ", email_usuario="
                + email_usuario + ", enabled=" + enabled + ", id=" + id + ", nombre_usuario=" + nombre_usuario
                + ", password=" + password + ", usuario=" + usuario + "]";
    } */

    /*     @Override
    public String toString() {
        return "User [id=" + id + ", username=" + usuario + ", password=" + password + "]";
    }
 */

}