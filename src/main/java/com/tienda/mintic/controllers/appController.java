package com.tienda.mintic.controllers;

import java.util.List;
import com.tienda.mintic.dao.UsuarioDao;
import com.tienda.mintic.models.Usuario;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class appController {

    @Autowired
    private UsuarioDao usuarioDao;

    public List<Usuario> data(){
        return usuarioDao.findAll();
    }

    @GetMapping({"/", "/login"})
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

    
    @GetMapping("/clientes")
    public String clientes(){
        return "clientes";
    }

    @GetMapping("/proveedores")
    public String proveedores(){
        return "proveedores";
    }

    @GetMapping("/productos")
    public String productos(){
        return "productos";
    }

    @GetMapping("/ventas")
    public String ventas(){
        return "ventas";
    }

    @GetMapping("/reportes")
    public String reportes(){
        return "reportes";
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
