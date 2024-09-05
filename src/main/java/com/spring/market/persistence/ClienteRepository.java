package com.spring.market.persistence;

import com.spring.market.domain.Client;
import com.spring.market.domain.repository.ClientRepository;
import com.spring.market.persistence.crud.ClienteCrudRepository;
import com.spring.market.persistence.entity.Cliente;
import com.spring.market.persistence.mapper.ClientMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ClienteRepository implements ClientRepository {

    @Autowired
    private ClienteCrudRepository clienteCrudRepository;
    @Autowired
    private ClientMapper clientMapper;

    @Override
    public List<Client> getAll() {
        return clientMapper.toClients((List<Cliente>) clienteCrudRepository.findAll());
    }

    @Override
    public Optional<Client> getClient(String clientId) {
        return clienteCrudRepository.findById(clientId).map(cliente -> clientMapper.toClient(cliente));
    }

    @Override
    public Optional<List<Client>> getLastnameAndName(String lastname, String name) {
        Optional<List<Cliente>> clientes = clienteCrudRepository.findByApellidosAndNombre(lastname,name);
        return clientes.map(clients -> clientMapper.toClients(clients));
    }

    @Override
    public Optional<List<Client>> getByName(String name) {
        return clienteCrudRepository.findByNombre(name)
                .map(clientes -> clientMapper.toClients(clientes));
    }

    @Override
    public Optional<List<Client>> getByLastname(String lastname) {
        return clienteCrudRepository.findByApellidos(lastname)
                .map(clientes -> clientMapper.toClients(clientes));
    }

    @Override
    public Optional<List<Client>> getByEmail(String email) {
        return clienteCrudRepository.findByCorreoElectronico(email)
                .map(clientes -> clientMapper.toClients(clientes));
    }

    @Override
    public Client save(Client client) {
        Cliente cliente=clientMapper.toCliente(client);
        return clientMapper.toClient(clienteCrudRepository.save(cliente));
    }

    @Override
    public Client update(Client client) {
        Cliente cliente=clientMapper.toCliente(client);
        return clientMapper.toClient(clienteCrudRepository.save(cliente));
    }

    @Override
    public void delete(String clientId) {
        clienteCrudRepository.deleteById(clientId);
    }
}
