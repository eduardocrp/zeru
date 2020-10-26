package com.eddev.zeru.sevices;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

import com.eddev.zeru.models.Order;
import com.eddev.zeru.repositories.OrderRepository;
import com.eddev.zeru.sevices.exceptions.ObjectNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @Autowired
    private OrderRepository repo;

    public Order find(BigInteger id) {
        Optional<Order> obj = repo.findById(id);

        return obj.orElseThrow(() -> new ObjectNotFoundException("Ordem não encontrada"));
    }

    public Order insert(Order obj) {
        obj.setIdOrder(null);

        return repo.save(obj);
    }

    public Order update(Order obj) {
        return repo.save(obj);
    }

    public void delete(BigInteger id) {
        find(id);
        try {
            repo.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityViolationException("Não é possível excluir Ordem que possui Famílias");
        }

    }

    public List<Order> findAll() {
        return repo.findAll();
    }

}
