package com.example.system.controllers;

import com.example.system.services.EventosService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/eventos")
public class EventosController {

    @Autowired
    private EventosService service;


}
