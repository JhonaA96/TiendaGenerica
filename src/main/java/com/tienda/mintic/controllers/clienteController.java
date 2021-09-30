package com.tienda.mintic.controllers;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
import com.tienda.mintic.models.Cliente;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.tienda.mintic.service.ClienteService;
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
@RequestMapping("/clientes")
public class clienteController {

    @Autowired
    private ClienteService clienteService;

    @PostMapping("/guardar")
    public ResponseEntity<?> create(@RequestBody Cliente cliente ){
        
        return ResponseEntity.status(HttpStatus.CREATED).body(clienteService.save(cliente));
    }

    @GetMapping("/listar/{id}")
    public ResponseEntity<?> read(@PathVariable(value="id") Long clienteId){
        Optional<Cliente> oCliente = clienteService.findById(clienteId);
        if(!oCliente.isPresent()){
            return ResponseEntity.notFound().build();
        }else{
            return ResponseEntity.ok(oCliente);
        }
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<?> update(@PathVariable(value="id") Long usuarioId, @RequestBody Cliente cliente){
        Optional<Cliente> oCliente = clienteService.findById(usuarioId);
        if(!oCliente.isPresent()){
            return ResponseEntity.notFound().build();
        }
        oCliente.get().setCedula_cliente(cliente.getCedula_cliente());
        oCliente.get().setDireccion_cliente(cliente.getDireccion_cliente());
        oCliente.get().setEmail_cliente(cliente.getEmail_cliente());
        oCliente.get().setNombre_cliente(cliente.getNombre_cliente());
        oCliente.get().setTelefono(cliente.getTelefono());

        return ResponseEntity.status(HttpStatus.ACCEPTED).body(clienteService.save(oCliente.get()));
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<?> delete(@PathVariable(value="id") Long clienteId){
        Optional<Cliente> oCliente = clienteService.findById(clienteId);
        if(!oCliente.isPresent()){
            return ResponseEntity.notFound().build();
        }
        clienteService.delete(clienteId);
        return ResponseEntity.ok().build();
    }
    @GetMapping("/listar")
    public List<Cliente> readAll(){
        List<Cliente> cliente = StreamSupport.stream(clienteService.findAll().spliterator(), false).collect(Collectors.toList());
        return cliente;
    }
}