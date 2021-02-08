package com.eddev.zeru.controllers;

import java.math.BigInteger;
import java.net.URI;
import java.util.List;

import com.eddev.zeru.models.Phylum;
import com.eddev.zeru.services.PhylumService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping(value = "/phylum")
public class PhylumController {

    @Autowired
    private PhylumService service;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Phylum> find(@PathVariable BigInteger id) {
        return ResponseEntity.ok().body(service.find(id));
    }

    @GetMapping
    public ResponseEntity<List<Phylum>> findAll() {
        return ResponseEntity.ok().body(service.findAll());
    }

    @PostMapping
    public ResponseEntity<Void> insert(@RequestBody Phylum obj) {

        Phylum objInserted = service.insert(obj);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(objInserted.getIdPhylum())
                .toUri();

        return ResponseEntity.created(uri).build();
    }

    @PutMapping
    public ResponseEntity<Void> update(@RequestBody Phylum obj) {

        Phylum objUpdated = service.update(obj);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(objUpdated.getIdPhylum())
                .toUri();

        return ResponseEntity.created(uri).build();

    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable BigInteger id) {

        service.delete(id);

        return ResponseEntity.noContent().build();
    }
        

}
