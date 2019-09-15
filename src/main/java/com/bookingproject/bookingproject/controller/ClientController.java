package com.bookingproject.bookingproject.controller;

import com.bookingproject.bookingproject.model.Client;
import com.bookingproject.bookingproject.model.Reservation;
import com.bookingproject.bookingproject.service.ClientManager;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/client")
public class ClientController {

    private ClientManager clientManager;

    public ClientController(ClientManager clientManager) {
        this.clientManager = clientManager;
    }

    @GetMapping
    String clientView () {
        return "client";
    }

    @GetMapping("/new_profile")
    String createProfileView () {
        return "new_profile";
    }

    @GetMapping("/registration_successful")
    String createProfileSuccessfulView () {
        return "registration_successful";
    }

    @PostMapping
    String createProfile (CreateClientRequest clientRequest) {
        clientManager.saveClient(clientRequest);
        return "redirect:client";
    }

    @GetMapping("/insert_id")
    String insertIdView () {
        return "insert_id";
    @GetMapping("/new_reservation")
    String newResView() {
        return "new_reservation";
    }

    @GetMapping("/edit_profile")
    String editProfileView (@RequestParam(value = "id") Long id, Model model) {
        Client foundClient = clientManager.findClientById(id);
        model.addAttribute("client", foundClient);
        return "edit_profile";
    }
    // dopisać postmapping RedirectView wypełnionego formularza powyżej
    @PostMapping("/edit_profile")
    RedirectView editProfile (@RequestParam(value = "id") Long id, EditClientRequest editClientRequest) {
        clientManager.editClient(id, editClientRequest);
        RedirectView redirectView = new RedirectView();
        redirectView.setUrl("/client");
        return redirectView;
    }
}
