package com.tienda.mintic.controllers;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
import com.tienda.mintic.models.Usuario;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.tienda.mintic.service.UsuarioService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;


@RestController
@RequestMapping("/usuarios")
public class userController {
    
    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("/guardar")
    public ResponseEntity<?> create(@RequestBody Usuario usuario){
        
        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioService.save(usuario));
    }
    @GetMapping("/listar/{id}")
    public ResponseEntity<?> read(@PathVariable(value="id") Long usuarioId){
        Optional<Usuario> oUsuario = usuarioService.findById(usuarioId);
        if(!oUsuario.isPresent()){
            return ResponseEntity.notFound().build();
        }else{
            return ResponseEntity.ok(oUsuario);
        }
    }
    @PutMapping("/actualizar/{id}")
    public ResponseEntity<?> update(@PathVariable(value="id") Long usuarioId, @RequestBody Usuario usuario){
        Optional<Usuario> oUsuario = usuarioService.findById(usuarioId);
        if(!oUsuario.isPresent()){
            return ResponseEntity.notFound().build();
        }
        oUsuario.get().setCedula_usuario(usuario.getCedula_usuario());
        oUsuario.get().setEmail_usuario(usuario.getEmail_usuario());
        oUsuario.get().setNombre_usuario(usuario.getNombre_usuario());
        oUsuario.get().setPassword(usuario.getPassword());
        oUsuario.get().setUsuario(usuario.getUsuario());
        oUsuario.get().setEnabled(usuario.isEnabled());

        return ResponseEntity.status(HttpStatus.ACCEPTED).body(usuarioService.save(oUsuario.get()));
    } 
    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<?> delete(@PathVariable(value="id") Long usuarioId){
        Optional<Usuario> oUsuario = usuarioService.findById(usuarioId);
        if(!oUsuario.isPresent()){
            return ResponseEntity.notFound().build();
        }
        usuarioService.delete(usuarioId);
        return ResponseEntity.ok().build();
    }
    @GetMapping("/listar")
    public List<Usuario> readAll(){
        List<Usuario> usuario = StreamSupport.stream(usuarioService.findAll().spliterator(), false).collect(Collectors.toList());
        return usuario;
    }
}