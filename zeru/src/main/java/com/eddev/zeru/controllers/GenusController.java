package com.eddev.zeru.controllers;

import java.math.BigInteger;
import java.net.URI;
import java.util.List;

import com.eddev.zeru.models.Genus;
import com.eddev.zeru.services.GenusService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping(value = "/genus")
public class GenusController {

    @Autowired
    private GenusService service;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Genus> find(@PathVariable BigInteger id) {
        return ResponseEntity.ok().body(service.find(id));
    }

    @GetMapping
    public ResponseEntity<List<Genus>> findAll() {
        return ResponseEntity.ok().body(service.findAll());
    }
    
    @PreAuthorize("hasAnyRole('ADMIN')")
    @PostMapping
    public ResponseEntity<Void> insert(@RequestBody Genus obj) {

        Genus objInserted = service.insert(obj);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(objInserted.getIdGenus()).toUri();

        return ResponseEntity.created(uri).build();
    }

    @PreAuthorize("hasAnyRole('ADMIN')")
    @PutMapping
    public ResponseEntity<Void> update(@RequestBody Genus obj) {

        Genus objUpdated = service.update(obj);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(objUpdated.getIdGenus())
                .toUri();

        return ResponseEntity.created(uri).build();

    }

    @PreAuthorize("hasAnyRole('ADMIN')")
    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable BigInteger id) {

        service.delete(id);

        return ResponseEntity.noContent().build();
    }

}
