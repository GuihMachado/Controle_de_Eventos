package com.example.system.controllers;

import java.net.URI;

import com.example.system.dtos.EventosDTO;
import com.example.system.dtos.EventosInsertDTO;
import com.example.system.services.EventosService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
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

}
