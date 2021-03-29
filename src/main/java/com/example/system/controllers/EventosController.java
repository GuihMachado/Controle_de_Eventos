package com.example.system.controllers;

import java.net.URI;

import com.example.system.dtos.EventosDTO;
import com.example.system.dtos.EventosInsertDTO;
import com.example.system.dtos.EventosUpdateDTO;
import com.example.system.services.EventosService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping("/eventos")
public class EventosController {

    @Autowired
    private EventosService service;

    @PostMapping
	public ResponseEntity<EventosDTO> insert(@RequestBody EventosInsertDTO insertDto){
		EventosDTO dto = service.insert(insertDto); 
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getId()).toUri();
		return ResponseEntity.created(uri).body(dto);
	}

    @DeleteMapping("{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		service.delete(id); 
		return ResponseEntity.noContent().build();
	}

    @PutMapping("{id}")
	public ResponseEntity<EventosDTO> update(@PathVariable Long id, @RequestBody EventosUpdateDTO updateDto){
		EventosDTO dto = service.update(id, updateDto); 
		return ResponseEntity.ok().body(dto);
	}

}
