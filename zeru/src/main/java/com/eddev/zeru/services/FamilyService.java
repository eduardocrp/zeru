package com.eddev.zeru.services;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

import com.eddev.zeru.models.Family;
import com.eddev.zeru.repositories.FamilyRepository;
import com.eddev.zeru.services.exceptions.ObjectNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

@Service
public class FamilyService {

    @Autowired
    private FamilyRepository repo;

    public Family find(BigInteger id) {
        Optional<Family> obj = repo.findById(id);

        return obj.orElseThrow(() -> new ObjectNotFoundException("Família não encontrada"));
    }

    public Family insert(Family obj) {
        obj.setIdFamily(null);

        return repo.save(obj);
    }

    public Family update(Family obj) {
        return repo.save(obj);
    }

    public void delete(BigInteger id) {
        find(id);
        try {
            repo.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityViolationException("Não é possível excluir Família que possui Gêneros");
        }

    }

    public List<Family> findAll() {
        return repo.findAll();
    }

}
