package com.example.system.services;

import com.example.system.repositories.EventosRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EventosService {

    @Autowired
    private EventosRepository repo;

    
}