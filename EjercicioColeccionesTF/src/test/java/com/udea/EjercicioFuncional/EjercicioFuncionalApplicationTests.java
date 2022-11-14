package com.udea.EjercicioFuncional;

import com.udea.EjercicioFuncional.dao.ClienteDao;
import com.udea.EjercicioFuncional.dao.PedidoDao;
import com.udea.EjercicioFuncional.dao.ProductoDao;
import com.udea.EjercicioFuncional.entidad.Cliente;
import com.udea.EjercicioFuncional.entidad.Pedido;
import com.udea.EjercicioFuncional.entidad.Producto;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;

@Slf4j
@DataJpaTest
class EjercicioFuncionalApplicationTests {

	@Autowired
	private ClienteDao clienteDao;

	@Autowired
	private PedidoDao pedidoDao;

	@Autowired
	private ProductoDao productoDao;

	@Test
	@DisplayName("Obtener una lista de productos con categoría = \"Libros\" y precio < 50")
	public void exerciseEj() {
		long startTime = System.currentTimeMillis();
		List<Producto> result = productoDao.findAll()
				.stream()
				.filter(p -> p.getCategoria().equalsIgnoreCase("Libros"))
				.filter(p -> p.getPrecio() < 50 )
				.collect(Collectors.toList());
		long endTime = System.currentTimeMillis();

		log.info(String.format("ejercicio de prueba - tiempo de ejecución: %1$d ms", (endTime - startTime)));
		result.forEach(p -> log.info(p.toString()));
	}


	@Test
	@DisplayName("Ejercicio #1: Mapeo  de idPedido y numero de productos del mismo")
	public void exercise1() {
		long startTime = System.currentTimeMillis();
		Map<Long, Object> pedidos = pedidoDao.findAll()
				.stream()
				//.forEach(pedido -> Pedido+' '+Pedido.getProductos().size());
				.collect(Collectors.toMap(Pedido::getIdPedido,Pedido->Pedido.getProductos().size()));
				//.collect(Collectors.toList());
		long endTime = System.currentTimeMillis();
		log.info(String.format("ejercicio 1 - tiempo de ejecución: %1$d ms", (endTime - startTime)));
		pedidos.forEach((k,v) -> log.info(String.format("idPedido: %1$d - numero de productos: %2$d", k, v)));
	}

	@Test
	@DisplayName("Ejercicio #2: Mapeo  de pedidos agrupados por clientes")
	public void exercise2() {
		long startTime = System.currentTimeMillis();
		Map<Cliente, List<Pedido>> pedidos = pedidoDao.findAll()
				.stream()
				.collect(groupingBy(Pedido::getCliente));
		long endTime = System.currentTimeMillis();
		log.info(String.format("ejercicio 2 - tiempo de ejecución: %1$d ms", (endTime - startTime)));
		pedidos.forEach((p,v) -> log.info(String.format("cliente: %1$s - pedidos: %2$s", p, v)));
	}

}
