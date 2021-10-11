package com.tienda.mintic.dao;

import com.tienda.mintic.models.Producto;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface ProductoDao extends JpaRepository<Producto, Long> {
    
}
