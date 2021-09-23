package com.tienda.mintic.seed;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
/* import org.springframework.boot.CommandLineRunner; */
import org.springframework.stereotype.Component;
import com.tienda.mintic.dao.UsuarioDao;
import com.tienda.mintic.models.Usuarios;

@Component
public class UserDataLoader implements ApplicationRunner{
    @Autowired
    UsuarioDao usuarioDao;

    public UserDataLoader(UsuarioDao usuarioDao){
        this.usuarioDao = usuarioDao;
    }    
    @Override
    public void run(ApplicationArguments args)throws Exception{
        if(usuarioDao.count() == 0){
            Usuarios usuario1 = new Usuarios(111111111, "correo@correo.com", "admininicial", "admin123456", "admininicial");
            usuarioDao.save(usuario1);
        }
    }
}