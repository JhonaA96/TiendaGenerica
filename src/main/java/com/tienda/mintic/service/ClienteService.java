package com.tienda.mintic.service;

import java.util.Optional;
import com.tienda.mintic.models.Cliente;

import org.springframework.stereotype.Service;

@Service
public interface ClienteService {

    public Iterable<Cliente> findAll();
    public Optional<Cliente> findById(Long id);
    public Cliente save(Cliente usuario);
    public void delete(Long id);

}
