package com.tienda.mintic.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
/* import org.springframework.web.bind.annotation.RequestMapping; */
import org.springframework.web.bind.annotation.RestController;


import com.tienda.mintic.models.Usuarios;
import com.tienda.mintic.dao.UsuarioDao;

@RestController
public class appController {
    @Autowired
    private UsuarioDao usuarioDao;

    @PostMapping("/create")
    public void create(@RequestBody Usuarios usuario){
        usuarioDao.save(usuario);
    }

    @GetMapping("/listar")
    public List<Usuarios> listar(){
        return usuarioDao.findAll();
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable("id") Integer id){
        usuarioDao.deleteById(id);
    }

    @PutMapping("/update")
    public void update(@RequestBody Usuarios usuario){
        usuarioDao.save(usuario);
    }

}
