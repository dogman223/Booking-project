package com.bookingproject.bookingproject.service;

import com.bookingproject.bookingproject.controller.CreateClientRequest;
import com.bookingproject.bookingproject.controller.EditClientRequest;
import com.bookingproject.bookingproject.model.Client;
import com.bookingproject.bookingproject.repository.ClientRepository;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;

@Service
public class ClientManager implements InitializingBean {

    private ClientRepository clientRepository;

    public ClientManager(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public void saveClient1() {
        Client client = new Client();
        client.setName("Andrzej");
        client.setSurname("Kowalski");
        client.setEmail("andrzej@kowalski.pl");
        client.setPhone("123-5232-2342");
        clientRepository.save(client);
    }
    public void saveClient2() {
        Client client = new Client();
        client.setName("Rafał");
        client.setSurname("Kowalewski");
        client.setEmail("asdasf@kowalewski.pl");
        client.setPhone("123-123-123");
        clientRepository.save(client);
    }
    public void saveClient3() {
        Client client = new Client();
        client.setName("Maciej");
        client.setSurname("Maciejewski");
        client.setEmail("ciej@ma.pl");
        client.setPhone("135-123-4123");
        clientRepository.save(client);
    }
    public void saveClient4() {
        Client client = new Client();
        client.setName("Tomasz");
        client.setSurname("Nie");
        client.setEmail("niechcialas@tomasz.pl");
        client.setPhone("123-41-123");
        clientRepository.save(client);
    }
    public void saveClient5() {
        Client client = new Client();
        client.setName("Jakub");
        client.setSurname("Szybki");
        client.setEmail("jakub@szybki.pl");
        client.setPhone("345-6234-123");
        clientRepository.save(client);
    }

    public void saveClient6() {
        Client client = new Client();
        client.setName("qqq");
        client.setSurname("qqq");
        client.setEmail("qqq@qqq.pl");
        client.setPhone("345-6234-123");
        client.setLogin("qqq");
        client.setPassword("qqq");
        clientRepository.save(client);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        saveClient1();
        saveClient2();
        saveClient3();
        saveClient4();
        saveClient5();
        saveClient6();
    }

    public void saveClient(CreateClientRequest clientRequest) {
        Client client = ClientMapper.map(clientRequest);
        clientRepository.save(client);
    }

    public Client findClientByLoginAndPassword (String login, String password) {
        return clientRepository.findDistinctByLoginAndPassword(login, password);
    }

    public Client findClientById (Long id) {
        Client client = clientRepository.getOne(id);
        return client;
    }

    public void editClient(Long id, EditClientRequest editClientRequest) {
        Client editedClient = clientRepository.getOne(id);
        editedClient.setName(editClientRequest.getName());
        editedClient.setSurname(editClientRequest.getSurname());
        editedClient.setEmail(editClientRequest.getEmail());
        editedClient.setPhone(editClientRequest.getPhone());
        editedClient.setPassword(editClientRequest.getPassword());
        clientRepository.save(editedClient);
    }

    public void deleteClient(Long id) {
        clientRepository.deleteById(id);
    }
}
