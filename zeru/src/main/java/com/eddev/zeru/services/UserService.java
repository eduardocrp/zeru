package com.eddev.zeru.services;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

import com.eddev.zeru.models.User;
import com.eddev.zeru.repositories.UserRepository;
import com.eddev.zeru.services.exceptions.ObjectNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository repo;

    @Autowired
    private BCryptPasswordEncoder passEncoder;

    public User find(BigInteger id) {
        Optional<User> obj = repo.findById(id);

        return obj.orElseThrow(() -> new ObjectNotFoundException("Usuário não encontrado"));
    }

    public User insert(User obj) {
        obj.setIdUser(null);
        obj.setPassword(passEncoder.encode(obj.getPassword()));

        return repo.save(obj);
    }

    public User update(User obj) {
        if (passEncoder.upgradeEncoding(obj.getPassword()))
            obj.setPassword(passEncoder.encode(obj.getPassword()));

        return repo.save(obj);
    };

    public void delete(BigInteger id) {
        find(id);
        try {
            repo.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityViolationException("Não é possível excluir Usuário que possui registros vinculados");
        }

    }

    public List<User> findAll() {
        return repo.findAll();
    }
}
