package com.bookingproject.bookingproject.controller;

import com.bookingproject.bookingproject.model.Client;
import com.bookingproject.bookingproject.model.Reservation;
import com.bookingproject.bookingproject.service.ClientManager;
import com.bookingproject.bookingproject.service.RoomManager;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.time.LocalDate;

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
        return "redirect:/client/registration_successful";
    }

    @GetMapping("/insert_id")
    String insertIdView () {
        return "insert_id";
    }

    @GetMapping("/edit_profile")
    String editProfileView (@RequestParam(value = "id") Long id, Model model) {
        Client foundClient = clientManager.findClientById(id);
        model.addAttribute("client", foundClient);
        return "edit_profile";
    }

    @PostMapping("/edit_profile")
    RedirectView editProfile (@RequestParam(value = "id") Long id, EditClientRequest editClientRequest) {
        clientManager.editClient(id, editClientRequest);
        RedirectView redirectView = new RedirectView();
        redirectView.setUrl("/client");
        return redirectView;
    }

    @GetMapping("/delete_profile")
    String deleteProfileView () {
        return "delete_profile";
    }

    @PostMapping("/delete_profile")
    String deleteProfile (@RequestParam(value = "login") String login,
                          @RequestParam(value = "password") String password) {
        Client foundClient = clientManager.findClientByLoginAndPassword(login, password);
        clientManager.deleteClient(foundClient.getId());
        return "client";
    }

    @GetMapping("/new_reservation")
    String newReservationView() {
        return "new_reservation";
    }

    @PostMapping("/new_reservation")
    String newReservationDates(@RequestParam(value = "arrival") String arrival,
                               @RequestParam(value = "departure") String departure,
                               Model model) {
        return "/rooms";
    }
}
