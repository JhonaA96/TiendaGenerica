package com.tienda.mintic.service;

import java.util.Optional;
import com.tienda.mintic.dao.VentasDao;
import com.tienda.mintic.models.Ventas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VentasServiceImpl implements VentasService{

    @Autowired
    private VentasDao ventasDao;

    @Override
    public Iterable<Ventas> findAll() {

        return ventasDao.findAll();
    }

    @Override
    public Optional<Ventas> findById(Long id) {

        return ventasDao.findById(id);
    }

    @Override
    public Ventas save(Ventas venta) {

        return ventasDao.save(venta);
    }

    @Override
    public void delete(Long id) {

        ventasDao.deleteById(id);
    }
    
}
