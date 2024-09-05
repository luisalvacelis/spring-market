package com.spring.market.persistence.crud;

import com.spring.market.persistence.entity.Categoria;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface CategoriaCrudRepository extends CrudRepository<Categoria,Integer> {

    Optional<List<Categoria>> findByDescripcion(String descripcion);
    Optional<List<Categoria>> findByEstado(boolean estado);
}
