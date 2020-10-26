package com.eddev.zeru.sevices;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

import com.eddev.zeru.models.Specie;
import com.eddev.zeru.repositories.SpecieRepository;
import com.eddev.zeru.sevices.exceptions.ObjectNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

@Service
public class SpecieService {

    @Autowired
    private SpecieRepository repo;

    public Specie find(BigInteger id) {
        Optional<Specie> obj = repo.findById(id);

        return obj.orElseThrow(() -> new ObjectNotFoundException("Espécie não encontrada"));
    }

    public Specie insert(Specie obj) {
        obj.setIdSpecie(null);

        return repo.save(obj);
    }

    public Specie update(Specie obj) {
        return repo.save(obj);
    }

    public void delete(BigInteger id) {
        find(id);
        try {
            repo.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityViolationException("Não é possível excluir Espécie que possui Plantas");
        }

    }

    public List<Specie> findAll() {
        return repo.findAll();
    }

}
