package com.example.system.repositories;

import com.example.system.entities.Eventos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventosRepository extends JpaRepository <Eventos,Long>{
    
}

