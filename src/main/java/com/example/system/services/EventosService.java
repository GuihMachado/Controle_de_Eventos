package com.example.system.services;

import javax.persistence.EntityNotFoundException;

import com.example.system.dtos.EventosDTO;
import com.example.system.dtos.EventosInsertDTO;
import com.example.system.dtos.EventosUpdateDTO;
import com.example.system.entities.Eventos;
import com.example.system.repositories.EventosRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
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

    public EventosDTO update(@PathVariable Long id, @RequestBody EventosUpdateDTO dto){
        try{
          Eventos entity = repo.getOne(id);
  
          entity.setPlace(dto.getPlace());
          entity.setStartdate(dto.getStartdate());
          entity.setEnDate(dto.getEnDate());
          entity.setStarTime(dto.getStarTime());
          entity.setEndtime(dto.getEndtime());
          entity = repo.save(entity);
          return new EventosDTO(entity);
        }
        catch(EntityNotFoundException ex){
          throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Event not found");
        }
      }
    
}