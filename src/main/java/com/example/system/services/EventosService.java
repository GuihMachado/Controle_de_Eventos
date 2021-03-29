package com.example.system.services;

import com.example.system.dtos.EventosDTO;
import com.example.system.dtos.EventosInsertDTO;
import com.example.system.entities.Eventos;
import com.example.system.repositories.EventosRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class EventosService {

    @Autowired
    private EventosRepository repo;

    public EventosDTO insert(EventosInsertDTO dto){
        Eventos entity = new Eventos(dto);
        entity = repo.save(entity);
        return new EventosDTO(entity);
    }

    public void delete(Long id){
        try{
            repo.deleteById(id);
        }
        catch(EmptyResultDataAccessException e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Event not found");
        }
    }
    
}