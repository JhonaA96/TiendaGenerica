package com.tienda.mintic.dao;

import com.tienda.mintic.models.Ventas;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface VentasDao extends JpaRepository<Ventas, Long> {
    
}
