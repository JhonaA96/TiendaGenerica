package com.tienda.mintic.controllers;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
import com.tienda.mintic.models.Proveedor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.tienda.mintic.service.ProveedorService;
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
@RequestMapping("/proveedores")
public class proveedorController {

    @Autowired
    private ProveedorService proveedorService;

    @PostMapping("/guardar")
    public ResponseEntity<?> create(@RequestBody Proveedor proveedor ){
        
        return ResponseEntity.status(HttpStatus.CREATED).body(proveedorService.save(proveedor));
    }

    @GetMapping("/listar/{id}")
    public ResponseEntity<?> read(@PathVariable(value="id") Long proveedorId){
        Optional<Proveedor> oProveedor = proveedorService.findById(proveedorId);
        if(!oProveedor.isPresent()){
            return ResponseEntity.notFound().build();
        }else{
            return ResponseEntity.ok(oProveedor);
        }
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<?> update(@PathVariable(value="id") Long proveedorId, @RequestBody Proveedor proveedor){
        Optional<Proveedor> oProveedor = proveedorService.findById(proveedorId);
        if(!oProveedor.isPresent()){
            return ResponseEntity.notFound().build();
        }
        oProveedor.get().setNit_proveedor(proveedor.getNit_proveedor());
        oProveedor.get().setCiudad_proveedor(proveedor.getCiudad_proveedor());
        oProveedor.get().setDireccion_proveedor(proveedor.getDireccion_proveedor());
        oProveedor.get().setNombre_proveedor(proveedor.getNombre_proveedor());
        oProveedor.get().setTelefono_proveedor(proveedor.getTelefono_proveedor());

        return ResponseEntity.status(HttpStatus.ACCEPTED).body(proveedorService.save(oProveedor.get()));
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<?> delete(@PathVariable(value="id") Long proveedorId){
        Optional<Proveedor> oProveedor = proveedorService.findById(proveedorId);
        if(!oProveedor.isPresent()){
            return ResponseEntity.notFound().build();
        }
        proveedorService.delete(proveedorId);
        return ResponseEntity.ok().build();
    }
    @GetMapping("/listar")
    public List<Proveedor> readAll(){
        List<Proveedor> proveedor = StreamSupport.stream(proveedorService.findAll().spliterator(), false).collect(Collectors.toList());
        return proveedor;
    }
}
