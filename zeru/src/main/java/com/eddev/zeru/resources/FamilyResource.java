package com.eddev.zeru.resources;

import java.math.BigInteger;
import java.net.URI;
import java.util.List;

import com.eddev.zeru.models.Family;
import com.eddev.zeru.services.FamilyService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
@RequestMapping(value = "/family")
public class FamilyResource {

    @Autowired
    private FamilyService service;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Family> find(@PathVariable BigInteger id) {
        return ResponseEntity.ok().body(service.find(id));
    }

    @GetMapping
    public ResponseEntity<List<Family>> findAll() {
        return ResponseEntity.ok().body(service.findAll());
    }

    @PostMapping
    public ResponseEntity<Void> insert(@RequestBody Family obj) {

        Family objInserted = service.insert(obj);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(objInserted.getIdFamily()).toUri();

        return ResponseEntity.created(uri).build();
    }

    @PutMapping
    public ResponseEntity<Void> update(@RequestBody Family obj) {

        Family objUpdated = service.update(obj);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(objUpdated.getIdFamily()).toUri();

        return ResponseEntity.created(uri).build();

    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable BigInteger id) {

        service.delete(id);

        return ResponseEntity.noContent().build();
    }

}
