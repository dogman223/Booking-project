package com.bookingproject.bookingproject.controller;

import com.bookingproject.bookingproject.model.Client;
import com.bookingproject.bookingproject.model.Reservation;
import com.bookingproject.bookingproject.model.Room;
import com.bookingproject.bookingproject.service.ClientManager;
import com.bookingproject.bookingproject.service.ReservationManager;
import com.bookingproject.bookingproject.service.RoomManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.time.LocalDate;
import java.util.List;


@Controller
@RequestMapping("/client")
public class ClientController {

    private ClientManager clientManager;

    public ClientController(ClientManager clientManager) {
        this.clientManager = clientManager;
    }

    @Autowired
    private ReservationManager reservationManager;

    @Autowired
    private RoomManager roomManager;

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

    @PostMapping("new_reservation")
    String newReservationDates(@RequestParam(value = "arrival") String arrival,
                               @RequestParam(value = "departure") String departure,
                               Model model) {
        model.addAttribute("arrival", arrival);
        model.addAttribute("departure", departure);
        return "/room_select";
    }

    @GetMapping("room_select")
    String roomSelectView(@RequestParam(value = "arrival") String arrival,
                          @RequestParam(value = "departure") String departure,
                          Model model) {
        LocalDate arrivalDate = LocalDate.parse(arrival);
        LocalDate departureDate = LocalDate.parse(departure);
        List<Room> availableRoomsByDates = reservationManager.findAvailableRoomsByDates(arrivalDate, departureDate);
        model.addAttribute("rooms", availableRoomsByDates);
        model.addAttribute("arrival", arrival);
        model.addAttribute("departure", departure);
        return "/room_select";
    }

    @PostMapping("room_select")
    String roomSelect (@RequestParam(value = "arrival") String arrival,
                       @RequestParam(value = "departure") String departure,
                       @RequestParam(value = "roomID") Long roomID,
                       Model model) {
        model.addAttribute("arrival", arrival);
        model.addAttribute("departure", departure);
        model.addAttribute("roomID", roomID);
        return "confirm_reservation";
    }

    @GetMapping("confirm_reservation")
    String confirmBookingView(@RequestParam(value = "arrival") String arrival,
                              @RequestParam(value = "departure") String departure,
                              @RequestParam(value = "roomID") Long roomID,
                              Model model) {
        model.addAttribute("arrival", arrival);
        model.addAttribute("departure", departure);
        model.addAttribute("roomID", roomID);
        return "confirm_reservation";
    }

    @PostMapping("confirm_reservation")
    String confirmBooking(@RequestParam(value = "arrival") String arrival,
                          @RequestParam(value = "departure") String departure,
                          @RequestParam(value = "roomID") Long roomID,
                          @RequestParam(value = "login") String login,
                          @RequestParam(value = "password") String password
                          ) {
        Client foundClient = clientManager.findClientByLoginAndPassword(login, password);
        List<Room> rooms = roomManager.getRooms();
        Room selectedRoom = null;
        for (Room room: rooms) {
            if (room.getId().equals(roomID)) {
                selectedRoom = room;
            }
        }
        CreateReservationRequest createReservationRequest = new CreateReservationRequest();
        createReservationRequest.setArrival(LocalDate.parse(arrival));
        createReservationRequest.setDeparture(LocalDate.parse(departure));
        createReservationRequest.setRoom(selectedRoom);
        Reservation reservation = reservationManager.saveReservation(createReservationRequest);
        EditClientRequest editClientRequest = new EditClientRequest();
        editClientRequest.setEmail(foundClient.getEmail());
        editClientRequest.setLogin(foundClient.getLogin());
        editClientRequest.setName(foundClient.getName());
        editClientRequest.setPassword(foundClient.getPassword());
        editClientRequest.setPhone(foundClient.getPhone());
        editClientRequest.setReservations(foundClient.getReservations());
        editClientRequest.getReservations().add(reservation);
        editClientRequest.setSurname(foundClient.getSurname());
        clientManager.updateReservations(foundClient.getId(), editClientRequest);
        return "/client";
    }

    @GetMapping("history")
    String historyView () {
        return "history";
    }

    @PostMapping("/history/bookings_list")
    String history (@RequestParam(value = "login") String login,
                    @RequestParam(value = "password") String password,
                    Model model) {
        Client foundClient = clientManager.findClientByLoginAndPassword(login, password);
        List<Reservation> reservations = foundClient.getReservations();
        model.addAttribute("reservations", reservations);
        return "bookings_list";
    }
}
