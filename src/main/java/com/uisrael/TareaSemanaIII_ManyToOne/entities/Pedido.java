package com.uisrael.TareaSemanaIII_ManyToOne.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private Double total;
    private LocalDate fechaPedido;
    private String estado;
    @ManyToOne(cascade = CascadeType.ALL) // O también puedes usar CascadeType.PERSIST
    @JoinColumn(name = "cliente")
    private Cliente cliente;
}
