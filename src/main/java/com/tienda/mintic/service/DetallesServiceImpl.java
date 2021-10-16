package com.tienda.mintic.service;

import java.util.Optional;
import com.tienda.mintic.dao.DetallesDao;
import com.tienda.mintic.models.Detalles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DetallesServiceImpl implements DetallesService{

    @Autowired
    private DetallesDao detallesDao;

    @Override
    public Iterable<Detalles> findAll() {

        return detallesDao.findAll();
    }

    @Override
    public Optional<Detalles> findById(Long id) {

        return detallesDao.findById(id);
    }

    @Override
    public Detalles save(Detalles detalle) {

        return detallesDao.save(detalle);
    }

    @Override
    public void delete(Long id) {

        detallesDao.deleteById(id);
    }
    
}
