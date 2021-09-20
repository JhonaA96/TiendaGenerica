package com.tienda.mintic.dao;

/* import org.springframework.data.repository.CrudRepository; */
import org.springframework.data.jpa.repository.JpaRepository;
import com.tienda.mintic.models.Usuarios;

public interface UsuarioDao extends JpaRepository<Usuarios, Integer> {

}
