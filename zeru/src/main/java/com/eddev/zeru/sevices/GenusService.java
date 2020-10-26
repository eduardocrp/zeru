package com.eddev.zeru.sevices;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

import com.eddev.zeru.models.Genus;
import com.eddev.zeru.repositories.GenusRepository;
import com.eddev.zeru.sevices.exceptions.ObjectNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

@Service
public class GenusService {

    @Autowired
    private GenusRepository repo;

    public Genus find(BigInteger id) {
        Optional<Genus> obj = repo.findById(id);

        return obj.orElseThrow(() -> new ObjectNotFoundException("Gênero não encontrado"));
    }

    public Genus insert(Genus obj) {
        obj.setIdGenus(null);

        return repo.save(obj);
    }

    public Genus update(Genus obj) {
        return repo.save(obj);
    }

    public void delete(BigInteger id) {
        find(id);
        try {
            repo.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityViolationException("Não é possível excluir Gênero que possui espécies");
        }

    }

    public List<Genus> findAll() {
        return repo.findAll();
    }

}