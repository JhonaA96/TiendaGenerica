package com.tienda.mintic.service;

import java.util.Optional;
import com.tienda.mintic.dao.ProductoDao;
import com.tienda.mintic.models.Producto;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;


@Service
public class ProductoServiceImpl implements ProductoService{

    @Autowired
    private ProductoDao productoDao;

    @Override
    public Iterable<Producto> findAll() {

        return productoDao.findAll();
    }

    @Override
    public Optional<Producto> findById(Long id) {

        return productoDao.findById(id);
    }

    @Override
    public Producto save(Producto producto) {

        return productoDao.save(producto);
    }

    @Override
    public void delete(Long id) {

        productoDao.deleteById(id);
    }
    
}
