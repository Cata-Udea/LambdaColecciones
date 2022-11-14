package com.udea.EjercicioFuncional.dao;

import com.udea.EjercicioFuncional.entidad.Producto;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductoDao extends CrudRepository<Producto, Long> {
    List<Producto> findAll();
}

