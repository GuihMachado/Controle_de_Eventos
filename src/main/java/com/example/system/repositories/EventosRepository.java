package com.example.system.repositories;

import com.example.system.entities.Eventos;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface EventosRepository extends JpaRepository <Eventos,Long>{
    @Query("SELECT e FROM Eventos e")
    public Page <Eventos> find(Pageable pageRequest);
}

