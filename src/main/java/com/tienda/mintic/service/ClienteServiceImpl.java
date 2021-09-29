package com.tienda.mintic.service;

import java.util.Optional;
import com.tienda.mintic.dao.ClienteDao;
import com.tienda.mintic.models.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteServiceImpl implements ClienteService{

    @Autowired
    private ClienteDao clienteDao;

    @Override
    public Iterable<Cliente> findAll() {

        return clienteDao.findAll();
    }

    @Override
    public Optional<Cliente> findById(Long id) {

        return clienteDao.findById(id);
    }

    @Override
    public Cliente save(Cliente usuario) {

        return clienteDao.save(usuario);
    }

    @Override
    public void delete(Long id) {

        clienteDao.deleteById(id);
    }
    
}
