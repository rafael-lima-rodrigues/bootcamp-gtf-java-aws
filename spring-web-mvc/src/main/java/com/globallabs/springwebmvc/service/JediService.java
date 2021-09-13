package com.globallabs.springwebmvc.service;

import com.globallabs.springwebmvc.exception.JediNotFoundExeception;
import com.globallabs.springwebmvc.model.Jedi;
import com.globallabs.springwebmvc.repository.JediRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JediService {

    @Autowired
    JediRepository repository;
    
    public List<Jedi> findAll() {
        
        return repository.findAll();
    }

    public Jedi findById(Long id) {
        Optional<Jedi> jedi = repository.findById(id);

        if (jedi.isPresent()) {
            return jedi.get();
        } else {
            throw new JediNotFoundExeception();
        }
    }

    public Jedi save(Jedi jedi) {
        return repository.save(jedi);
    }

    public Jedi update(Long id, Jedi dto) {
        Optional<Jedi> jediEntity = repository.findById(id);
        Jedi jedi;
        if (jediEntity.isPresent()){
            jedi = jediEntity.get();
        } else {
            throw new JediNotFoundExeception();
        }
        jedi.setName(dto.getName());
        jedi.setLastName(dto.getLastName());
        return repository.save(jedi);
    }

    public void delete(Long id) {
        Optional<Jedi> jedi = repository.findById(id);

        repository.delete(jedi.get());
    }
}
