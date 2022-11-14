package com.udea.EjercicioFuncional.entidad;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="producto")
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProducto;

    private String nombre;

    private String categoria;

    @With
    private Double precio;

    @ManyToMany(mappedBy = "productos")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Set<Pedido> pedidos;
}
