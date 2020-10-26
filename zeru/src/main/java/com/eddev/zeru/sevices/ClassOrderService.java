package com.eddev.zeru.sevices;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

import com.eddev.zeru.models.ClassOrder;
import com.eddev.zeru.repositories.ClassOrderRepository;
import com.eddev.zeru.sevices.exceptions.ObjectNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

@Service
public class ClassOrderService {

    @Autowired
    private ClassOrderRepository repo;

    public ClassOrder find(BigInteger id) {
        Optional<ClassOrder> obj = repo.findById(id);

        return obj.orElseThrow(() -> new ObjectNotFoundException("Classe não encontrada"));
    }

    public ClassOrder insert(ClassOrder obj) {
        obj.setIdClassOrder(null);

        return repo.save(obj);
    }

    public ClassOrder update(ClassOrder obj) {
        return repo.save(obj);
    }

    public void delete(BigInteger id) {
        find(id);
        try {
            repo.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityViolationException("Não é possível excluir Classe que possui Ordens");
        }

    }

    public List<ClassOrder> findAll() {
        return repo.findAll();
    }

}