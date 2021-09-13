package com.globallabs.springwebmvc.repository;

import com.globallabs.springwebmvc.model.Jedi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface JediRepository extends JpaRepository<Jedi, Long> {

}
