package com.tienda.mintic.dao;

import com.tienda.mintic.models.Proveedor;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface ProveedorDao extends JpaRepository <Proveedor, Long> {

}
