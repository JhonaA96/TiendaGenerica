package com.tienda.mintic.service;

import java.util.Optional;
import com.tienda.mintic.dao.UsuarioDao;
import com.tienda.mintic.models.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioServiceImpl implements UsuarioService{

    @Autowired
    private UsuarioDao usuarioDao;

    @Override
    public Iterable<Usuario> findAll() {

        return usuarioDao.findAll();
    }

    @Override
    public Optional<Usuario> findById(Long id) {

        return usuarioDao.findById(id);
    }

    @Override
    public Usuario save(Usuario usuario) {

        return usuarioDao.save(usuario);
    }

    @Override
    public void delete(Long id) {

        usuarioDao.deleteById(id);
    }
    
}
