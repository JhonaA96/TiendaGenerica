package com.tienda.mintic.controllers;

import java.util.List;
import com.tienda.mintic.dao.UsuarioDao;
import com.tienda.mintic.models.Usuarios;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
public class userController {
    @Autowired
    private UsuarioDao usuarioDao;

    @PostMapping("/usuarios/create")
    public void create(@RequestBody Usuarios usuario){
        usuarioDao.save(usuario);
        
    }

    @GetMapping("/usuarios/listar")
    public List<Usuarios> listar(){
        return usuarioDao.findAll();
    }

    @DeleteMapping("/usuarios/delete/{id}")
    public void delete(@PathVariable("id") Integer id){
        usuarioDao.deleteById(id);
    }

    @PutMapping("/usuarios/update/{id}")
    public void update(@PathVariable("id") Integer id, @RequestBody Usuarios usuario){
        if(usuarioDao.existsById(id)){
            usuarioDao.deleteById(id);
            usuarioDao.save(usuario);
        }else{
            System.out.println("Usuario no encontrado");
        }
    }
}