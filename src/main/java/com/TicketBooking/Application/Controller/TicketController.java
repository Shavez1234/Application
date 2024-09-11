package com.TicketBooking.Application.Controller;

import com.TicketBooking.Application.Controller.Dto.TicketDTO;
import com.TicketBooking.Application.Service.TicketService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ticket")
public class TicketController {

    @Autowired
    private TicketService service;

    @PostMapping("/bookticket")
    public ResponseEntity<String>bookTicket(@Valid @RequestBody TicketDTO ticketDTO) {
        try {
            String response = service.saveTicket(ticketDTO);
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
