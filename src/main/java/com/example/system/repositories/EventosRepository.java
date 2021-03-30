package com.example.system.repositories;


import java.time.LocalDate;

import com.example.system.entities.Eventos;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface EventosRepository extends JpaRepository <Eventos,Long>{
    @Query(" SELECT e FROM Eventos e " + 
    " WHERE( e.startdate >= :startdate) AND " + "( LOWER(e.name) LIKE LOWER(CONCAT ('%', :name, '%'))) AND " + "( LOWER(e.place)LIKE LOWER(CONCAT('%', :place,'%'))) AND "
    + "( LOWER( e.description) LIKE LOWER(CONCAT ('%', :description, '%'))) "
    )
    public Page <Eventos> find(Pageable pageRequest, String name, String place, String description, LocalDate startdate);
}

