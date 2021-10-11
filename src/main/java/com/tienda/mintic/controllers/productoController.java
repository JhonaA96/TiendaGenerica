package com.tienda.mintic.controllers;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
import com.tienda.mintic.models.Producto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.tienda.mintic.service.ProductoService;
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
@RequestMapping("/productos")
public class productoController {

    @Autowired
    private ProductoService productoService;

    @PostMapping("/guardar")
    public ResponseEntity<?> create(@RequestBody Producto producto ){
        
        return ResponseEntity.status(HttpStatus.CREATED).body(productoService.save(producto));
    }

    @GetMapping("/listar/{id}")
    public ResponseEntity<?> read(@PathVariable(value="id") Long productoId){
        Optional<Producto> oProducto = productoService.findById(productoId);
        if(!oProducto.isPresent()){
            return ResponseEntity.notFound().build();
        }else{
            return ResponseEntity.ok(oProducto);
        }
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<?> update(@PathVariable(value="id") Long productoId, @RequestBody Producto producto){
        Optional<Producto> oProducto = productoService.findById(productoId);
        if(!oProducto.isPresent()){
            return ResponseEntity.notFound().build();
        }
        oProducto.get().setCodigo_producto(producto.getCodigo_producto());
        oProducto.get().setIva_compra(producto.getIva_compra());
        oProducto.get().setProveedor(producto.getProveedor());
        oProducto.get().setNombre_producto(producto.getNombre_producto());
        oProducto.get().setPrecio_compra(producto.getPrecio_compra());
        oProducto.get().setPrecio_venta(producto.getPrecio_venta());

        return ResponseEntity.status(HttpStatus.ACCEPTED).body(productoService.save(oProducto.get()));
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<?> delete(@PathVariable(value="id") Long productoId){
        Optional<Producto> oProducto = productoService.findById(productoId);
        if(!oProducto.isPresent()){
            return ResponseEntity.notFound().build();
        }
        productoService.delete(productoId);
        return ResponseEntity.ok().build();
    }
    @GetMapping("/listar")
    public List<Producto> readAll(){
        List<Producto> producto = StreamSupport.stream(productoService.findAll().spliterator(), false).collect(Collectors.toList());
        return producto;
    }
}
