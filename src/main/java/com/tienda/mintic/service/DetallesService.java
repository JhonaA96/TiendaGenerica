package com.tienda.mintic.service;

import java.util.Optional;
import com.tienda.mintic.models.Detalles;

import org.springframework.stereotype.Service;

@Service
public interface DetallesService {

    public Iterable<Detalles> findAll();
    public Optional<Detalles> findById(Long id);
    public Detalles save(Detalles detalle);
    public void delete(Long id);

}
