package com.tienda.mintic.service;

import java.util.Optional;
import com.tienda.mintic.models.Ventas;

import org.springframework.stereotype.Service;

@Service
public interface VentasService {

    public Iterable<Ventas> findAll();
    public Optional<Ventas> findById(Long id);
    public Ventas save(Ventas usuario);
    public void delete(Long id);

}
