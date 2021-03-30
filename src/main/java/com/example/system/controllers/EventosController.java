package com.example.system.controllers;

import java.net.URI;
import java.time.LocalDate;

import com.example.system.dtos.EventosDTO;
import com.example.system.dtos.EventosInsertDTO;
import com.example.system.dtos.EventosUpdateDTO;
import com.example.system.services.EventosService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping("/eventos")
public class EventosController {

    @Autowired
    private EventosService service;

    @GetMapping
	public ResponseEntity<Page<EventosDTO>> getEventos(
		@RequestParam(value = "page", defaultValue = "0") Integer page,
		@RequestParam(value = "linesPerPage", defaultValue = "6") Integer linesPerPage,
		@RequestParam(value = "direction", defaultValue = "ASC") String direction,
		@RequestParam(value = "orderBy", defaultValue = "id") String orderBy,
		@RequestParam(value = "name", defaultValue = "") String name,
		@RequestParam(value = "place", defaultValue = "") String place,
		@RequestParam(value = "description", defaultValue = "") String description,
		@RequestParam(value = "startdate", defaultValue = "01/01/2000") LocalDate startdate
		
	) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction),orderBy);
		
		Page<EventosDTO> list = service.getEventos(pageRequest, name, place, description, startdate);
		return ResponseEntity.ok(list);
	}
	
	
	
	
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

    @GetMapping("{id}")
    public ResponseEntity<EventosDTO> getEventosById(@PathVariable Long id) {
        EventosDTO dto = service.getEventosById(id);
        return ResponseEntity.ok(dto);
    }

}
