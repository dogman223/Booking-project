package com.bookingproject.bookingproject.service;

import com.bookingproject.bookingproject.model.Client;
import com.bookingproject.bookingproject.repository.ClientRepository;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;

@Service
public class ClientManager implements InitializingBean {

    private ClientRepository clientRepository;

    public ClientManager(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public void saveClient() {
        Client client = new Client();
        client.setName("Andrzej");
        client.setSurname("Kowalski");
        client.setEmail("andrzej@kowalski.pl");
        client.setPhone("123-5232-2342");
        clientRepository.save(client);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        saveClient();
    }
}
