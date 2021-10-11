package com.tienda.mintic.service;

import java.util.Optional;
import com.tienda.mintic.models.Producto;
import org.springframework.stereotype.Service;

@Service
public interface ProductoService {

    public Iterable<Producto> findAll();
    public Optional<Producto> findById(Long id);
    public Producto save(Producto producto);
    public void delete(Long id);

}
