package com.tienda.mintic.dao;

import com.tienda.mintic.models.Cliente;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface ClienteDao extends JpaRepository <Cliente, Long> {

}
