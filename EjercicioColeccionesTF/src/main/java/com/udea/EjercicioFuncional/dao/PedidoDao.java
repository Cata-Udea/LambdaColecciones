package com.udea.EjercicioFuncional.dao;

import com.udea.EjercicioFuncional.entidad.Pedido;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PedidoDao extends CrudRepository<Pedido, Long> {
        List<Pedido> findAll();
}