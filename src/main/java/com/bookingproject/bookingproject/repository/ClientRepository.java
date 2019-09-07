package com.bookingproject.bookingproject.repository;

import com.bookingproject.bookingproject.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client,Long> {

}
