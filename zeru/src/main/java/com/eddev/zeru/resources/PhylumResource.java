package com.eddev.zeru.resources;

import java.math.BigInteger;
import java.util.List;

import com.eddev.zeru.models.Phylum;
import com.eddev.zeru.sevices.PhylumService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "/phylum")
public class PhylumResource {
    
    @Autowired
    private PhylumService service;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Phylum> find(@PathVariable BigInteger id){
        return ResponseEntity.ok().body(service.find(id));
    }

    @GetMapping
    public ResponseEntity<List<Phylum>> getMethodName() {
        return ResponseEntity.ok().body(service.findAll());
    }

}
