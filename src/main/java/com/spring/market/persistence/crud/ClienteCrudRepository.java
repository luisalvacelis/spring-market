package com.spring.market.persistence.crud;

import com.spring.market.persistence.entity.Cliente;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ClienteCrudRepository extends CrudRepository<Cliente,String> {

    Optional<List<Cliente>> findByApellidosAndNombre(String apellidos,String nombre);
    Optional<List<Cliente>> findByNombre(String nombre);
    Optional<List<Cliente>> findByApellidos(String apellidos);
    Optional<List<Cliente>> findByCorreoElectronico(String correoElectronico);
}
