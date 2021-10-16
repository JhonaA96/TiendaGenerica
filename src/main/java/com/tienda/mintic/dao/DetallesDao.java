package com.tienda.mintic.dao;

import com.tienda.mintic.models.Detalles;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface DetallesDao extends JpaRepository<Detalles, Long> {
    
}
