package com.udea.EjercicioFuncional.dao;

import com.udea.EjercicioFuncional.entidad.Cliente;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClienteDao extends CrudRepository<Cliente, Long> {

    List<Cliente> findAll();
}