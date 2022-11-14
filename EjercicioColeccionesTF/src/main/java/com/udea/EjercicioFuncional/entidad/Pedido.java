package com.udea.EjercicioFuncional.entidad;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "producto_pedido")
public class Pedido {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPedido;

    @Column(name="pedido_fecha")
    private LocalDate pedidoFecha;

    @Column(name="entrega_fecha")
    private LocalDate entregaFecha;

    private String estado;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    @ManyToMany
    @JoinTable(
            name = "pedido_producto_relacion",
            joinColumns = { @JoinColumn(name = "id_pedido") },
            inverseJoinColumns = { @JoinColumn(name = "id_producto") }
    )
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    Set<Producto> productos;

    public Long getIdPedido() {
        return idPedido;
    }

    public Set<Producto> getProductos() {
        return productos;
    }
}
