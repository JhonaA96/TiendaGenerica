package com.tienda.mintic.seed;

import org.springframework.data.repository.CrudRepository;
import com.tienda.mintic.models.Usuarios;

public interface UserRepository extends CrudRepository <Usuarios, Long>{
    
}