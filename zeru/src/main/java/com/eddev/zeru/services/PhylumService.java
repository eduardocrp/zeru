package com.eddev.zeru.services;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

import com.eddev.zeru.models.Phylum;
import com.eddev.zeru.repositories.PhylumRepository;
import com.eddev.zeru.services.exceptions.ObjectNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

@Service
public class PhylumService {

    @Autowired
    private PhylumRepository repo;

    public Phylum find(BigInteger id) {
        Optional<Phylum> obj = repo.findById(id);

        return obj.orElseThrow(() -> new ObjectNotFoundException(
                "Filo não encontrado"));
    }

    public Phylum insert(Phylum obj){
        obj.setIdPhylum(null);

        return repo.save(obj);
    }

    public Phylum update(Phylum obj){
        return repo.save(obj);
    }

    public void delete(BigInteger id){
        find(id);
        try {
            repo.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityViolationException("Não é possível excluir Filo que possui Classes");
        }

    }

    public List<Phylum> findAll(){
        return repo.findAll();
    }

}
