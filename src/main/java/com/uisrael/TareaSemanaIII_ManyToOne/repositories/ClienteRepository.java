package com.uisrael.TareaSemanaIII_ManyToOne.repositories;

import com.uisrael.TareaSemanaIII_ManyToOne.entities.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {

}
