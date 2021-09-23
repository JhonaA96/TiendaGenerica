package com.tienda.mintic.controllers;

import java.util.List;
import com.tienda.mintic.dao.UsuarioDao;
import com.tienda.mintic.models.Usuarios;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class appController {

    @Autowired
    private UsuarioDao usuarioDao;

    public List<Usuarios> data(){
        return usuarioDao.findAll();
    }

    @GetMapping("/")
    public String index(){
        return "index";
    }

    @GetMapping("/menu")
    public String menu(){
        return "menu";
    }

    @GetMapping("/usuarios")
    public String usuarios(){
        return "usuarios";
    }
    
    @RequestMapping("/menu")
    public String validar(HttpServletRequest req, HttpServletRequest resp){
        String user = req.getParameter("usuario");
        String password = req.getParameter("password");

        if(user.equals("admininicial") && password.equals("admin123456")){
            
            return "menu";
        }else{
            return "error";
        }
    }
}
