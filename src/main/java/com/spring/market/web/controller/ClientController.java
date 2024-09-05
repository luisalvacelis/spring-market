package com.spring.market.web.controller;

import com.spring.market.domain.Client;
import com.spring.market.domain.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clients")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @GetMapping("/all-clients")
    public ResponseEntity<List<Client>> getAll(){
        return new ResponseEntity<>(clientService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/client={id}")
    public ResponseEntity<Client> getClient(@PathVariable("id") String clientId){
        return clientService.getClient(clientId)
                .map(client -> new ResponseEntity<>(client,HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/name={name}")
    public ResponseEntity<List<Client>> getByName(@PathVariable("name") String name){
        return clientService.getByName(name)
                .map(client -> new ResponseEntity<>(client,HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/lastname={lastname}")
    public ResponseEntity<List<Client>> getByLastname(@PathVariable("lastname") String lastname){
        return clientService.getByLastname(lastname)
                .map(client -> new ResponseEntity<>(client,HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/email={email}")
    public ResponseEntity<List<Client>> getByEmail(@PathVariable("email") String email){
        return clientService.getByEmail(email)
                .map(client -> new ResponseEntity<>(client,HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/save")
    public ResponseEntity<Client> save(@RequestBody Client client){
        return new ResponseEntity<>(clientService.save(client),HttpStatus.CREATED);
    }

    @PostMapping("/update")
    public ResponseEntity<Client> update(@RequestBody Client client){
        return new ResponseEntity<>(clientService.update(client),HttpStatus.OK);
    }

    @DeleteMapping("/delete={id}")
    public ResponseEntity delete(@PathVariable("id") String clientId){
        if(clientService.delete(clientId)){
            return new ResponseEntity(HttpStatus.OK);
        }else{
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }
}
