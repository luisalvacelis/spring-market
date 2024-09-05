package com.spring.market.domain.repository;

import com.spring.market.domain.Client;

import java.util.List;
import java.util.Optional;

public interface ClientRepository {

    List<Client> getAll();
    Optional<Client> getClient(String clientId);
    Optional<List<Client>> getLastnameAndName(String lastname,String name);
    Optional<List<Client>> getByName(String name);
    Optional<List<Client>> getByLastname(String lastname);
    Optional<List<Client>> getByEmail(String email);
    Client save(Client client);
    Client update(Client client);
    void delete(String clientId);
}
