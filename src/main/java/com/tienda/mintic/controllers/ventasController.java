package com.tienda.mintic.controllers;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
import com.tienda.mintic.models.Ventas;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.tienda.mintic.service.VentasService;
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
@RequestMapping("/ventas")
public class ventasController {

    @Autowired
    private VentasService ventasService;

    @PostMapping("/guardar")
    public ResponseEntity<?> create(@RequestBody Ventas venta ){
        
        return ResponseEntity.status(HttpStatus.CREATED).body(ventasService.save(venta));
    }

    @GetMapping("/listar/{id}")
    public ResponseEntity<?> read(@PathVariable(value="id") Long ventaId){
        Optional<Ventas> oVenta = ventasService.findById(ventaId);
        if(!oVenta.isPresent()){
            return ResponseEntity.notFound().build();
        }else{
            return ResponseEntity.ok(oVenta);
        }
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<?> update(@PathVariable(value="id") Long ventaId, @RequestBody Ventas venta){
        Optional<Ventas> oVenta = ventasService.findById(ventaId);
        if(!oVenta.isPresent()){
            return ResponseEntity.notFound().build();
        }
        oVenta.get().setCodigo_venta(venta.getCodigo_venta());
        oVenta.get().setCedula_cliente(venta.getCedula_cliente());
        oVenta.get().setCedula_usuario(venta.getCedula_usuario());
        oVenta.get().setIva_venta(venta.getIva_venta());
        oVenta.get().setTotal_venta(venta.getTotal_venta());
        oVenta.get().setValor_venta(venta.getValor_venta());

        return ResponseEntity.status(HttpStatus.ACCEPTED).body(ventasService.save(oVenta.get()));
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<?> delete(@PathVariable(value="id") Long ventaId){
        Optional<Ventas> oVenta = ventasService.findById(ventaId);
        if(!oVenta.isPresent()){
            return ResponseEntity.notFound().build();
        }
        ventasService.delete(ventaId);
        return ResponseEntity.ok().build();
    }
    @GetMapping("/listar")
    public List<Ventas> readAll(){
        List<Ventas> producto = StreamSupport.stream(ventasService.findAll().spliterator(), false).collect(Collectors.toList());
        return producto;
    }
}
