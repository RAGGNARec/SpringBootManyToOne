package com.uisrael.TareaSemanaIII_ManyToOne.repositories;

import com.uisrael.TareaSemanaIII_ManyToOne.entities.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long> {
}
