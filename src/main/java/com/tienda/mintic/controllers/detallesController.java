package com.tienda.mintic.controllers;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
import com.tienda.mintic.models.Detalles;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.tienda.mintic.service.DetallesService;
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
@RequestMapping("/detalles")
public class detallesController {

    @Autowired
    private DetallesService detallesService;

    @PostMapping("/guardar")
    public ResponseEntity<?> create(@RequestBody Detalles detalle ){
        
        return ResponseEntity.status(HttpStatus.CREATED).body(detallesService.save(detalle));
    }

    @GetMapping("/listar/{id}")
    public ResponseEntity<?> read(@PathVariable(value="id") Long detalleId){
        Optional<Detalles> oDetalle = detallesService.findById(detalleId);
        if(!oDetalle.isPresent()){
            return ResponseEntity.notFound().build();
        }else{
            return ResponseEntity.ok(oDetalle);
        }
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<?> update(@PathVariable(value="id") Long detalleId, @RequestBody Detalles detalle){
        Optional<Detalles> oDetalle = detallesService.findById(detalleId);
        if(!oDetalle.isPresent()){
            return ResponseEntity.notFound().build();
        }
        oDetalle.get().setCodigo_detalle_venta(detalle.getCodigo_detalle_venta());
        oDetalle.get().setCantidad_producto(detalle.getCantidad_producto());
        oDetalle.get().setCodigo_producto(detalle.getCodigo_producto());
        oDetalle.get().setCodigo_venta(detalle.getCodigo_venta());
        oDetalle.get().setIva_venta(detalle.getIva_venta());
        oDetalle.get().setValor_total(detalle.getValor_total());
        oDetalle.get().setValor_venta(detalle.getValor_venta());

        return ResponseEntity.status(HttpStatus.ACCEPTED).body(detallesService.save(oDetalle.get()));
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<?> delete(@PathVariable(value="id") Long detalleId){
        Optional<Detalles> oDetalle = detallesService.findById(detalleId);
        if(!oDetalle.isPresent()){
            return ResponseEntity.notFound().build();
        }
        detallesService.delete(detalleId);
        return ResponseEntity.ok().build();
    }
    @GetMapping("/listar")
    public List<Detalles> readAll(){
        List<Detalles> detalle = StreamSupport.stream(detallesService.findAll().spliterator(), false).collect(Collectors.toList());
        return detalle;
    }
}
