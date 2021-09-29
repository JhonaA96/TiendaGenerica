package com.tienda.mintic.service;

import java.util.Optional;
import com.tienda.mintic.models.Proveedor;

import org.springframework.stereotype.Service;

@Service
public interface ProveedorService {

    public Iterable<Proveedor> findAll();
    public Optional<Proveedor> findById(Long id);
    public Proveedor save(Proveedor usuario);
    public void delete(Long id);

}
