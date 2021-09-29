package com.tienda.mintic.service;

import java.util.Optional;
import com.tienda.mintic.dao.ProveedorDao;
import com.tienda.mintic.models.Proveedor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProveedorServiceImpl implements ProveedorService{

    @Autowired
    private ProveedorDao proveedorDao;

    @Override
    public Iterable<Proveedor> findAll() {

        return proveedorDao.findAll();
    }

    @Override
    public Optional<Proveedor> findById(Long id) {

        return proveedorDao.findById(id);
    }

    @Override
    public Proveedor save(Proveedor usuario) {

        return proveedorDao.save(usuario);
    }

    @Override
    public void delete(Long id) {

        proveedorDao.deleteById(id);
    }
    
}
