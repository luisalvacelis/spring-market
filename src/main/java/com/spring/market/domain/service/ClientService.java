package com.spring.market.domain.service;

import com.spring.market.domain.Client;
import com.spring.market.domain.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    public List<Client> getAll(){
        return clientRepository.getAll();
    }

    public Optional<Client> getClient(String clientId){
        return clientRepository.getClient(clientId);
    }

    public Optional<List<Client>> getByName(String name){
        return clientRepository.getByName(name);
    }

    public Optional<List<Client>> getByLastname(String lastname){
        return clientRepository.getByLastname(lastname);
    }

    public Optional<List<Client>> getByEmail(String email){
        return clientRepository.getByEmail(email);
    }

    public Client save(Client client){
        return clientRepository.save(client);
    }

    public Client update(Client client){
        return clientRepository.update(client);
    }

    public boolean delete(String clientId){
        return getClient(clientId)
                .map(client -> {
                    clientRepository.delete(clientId);
                    return true;
                }).orElse(false);
    }
}
