package com.TicketBooking.Application.Service;

import com.TicketBooking.Application.Controller.Dto.TicketDTO;
import com.TicketBooking.Application.Entity.Ticket;
import com.TicketBooking.Application.Exception.DestinationNotValidException;
import com.TicketBooking.Application.Exception.InvalidDateException;
import com.TicketBooking.Application.Exception.NameNotValidException;
import com.TicketBooking.Application.Exception.SourceNotValidException;
import com.TicketBooking.Application.Repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
@Service
public class TicketServiceImpl implements TicketService {

    @Autowired
    private TicketRepository repository;

    @Override
    public String saveTicket(TicketDTO ticket) throws Exception {
        String ticketNumber = null;

        boolean isValidName = this.isNameValid(ticket.getName());
        if (!isValidName) throw new NameNotValidException("Enter a valid name!");

        boolean isValidSource = this.isSourceValid(ticket.getSource());
        if (!isValidSource) throw new SourceNotValidException("Enter a valid source!");

        boolean isValidDestination = this.isDestinationValid(ticket.getDestination());
        if (!isValidDestination) throw new DestinationNotValidException("Enter a valid destination!");

        boolean validDate = this.validdateDate(ticket.getDate());
        if (validDate) {
            Ticket ticketEntity = this.DTOToEntity(ticket);
            ticketNumber = this.generateTicketNumber(ticket.getSource(), ticket.getDestination());
            ticketEntity.setTicketNumber(ticketNumber);  // Corrected setter name
            repository.save(ticketEntity);
        }

        return "Get Ticket Number is: " + ticketNumber;
    }

    // Example usage of findByTicketNumber
    public Ticket findTicketByNumber(String ticketNumber) {
        return repository.findByTicketNumber(ticketNumber);
    }

    private boolean isNameValid(String name) {
        if (name == null || name.trim().isEmpty()) {
            return false;
        }
        for (char c : name.toCharArray()) {
            if (Character.isLetter(c)) {
                return true;
            }
        }
        return false;
    }

    private boolean isSourceValid(String source) {
        if (source == null || source.trim().isEmpty()) {
            return false;
        }
        for (char c : source.toCharArray()) {
            if (Character.isLetter(c)) {
                return true;
            }
        }
        return false;
    }

    private boolean isDestinationValid(String destination) {
        if (destination == null || destination.trim().isEmpty()) {
            return false;
        }
        for (char c : destination.toCharArray()) {
            if (Character.isLetter(c)) {
                return true;
            }
        }
        return false;
    }

    private boolean validdateDate(String date) throws Exception {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        dateFormat.setLenient(false);
        Date parsedDate;
        try {
            parsedDate = dateFormat.parse(date);
        } catch (ParseException e) {
            throw new InvalidDateException("Enter date in format dd/MM/yyyy");
        }
        boolean next = new Date().after(parsedDate);
        if (next) {
            throw new InvalidDateException("Enter a valid date");
        } else {
            return true;
        }
    }

    public Ticket DTOToEntity(TicketDTO dto) {
        Ticket ticketEntity = new Ticket();
        ticketEntity.setName(dto.getName());
        ticketEntity.setSource(dto.getSource());
        ticketEntity.setDestination(dto.getDestination());
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            ticketEntity.setDate(dateFormat.parse(dto.getDate()));
        } catch (ParseException e) {
            e.printStackTrace();  // Consider logging instead of printing the stack trace
        }
        return ticketEntity;
    }

    private String generateTicketNumber(String source, String destination) {
        char s = source.toUpperCase().charAt(0);
        char d = destination.toUpperCase().charAt(0);
        Random random = new Random();
        int small = 1111111;
        int big = 8888888;
        int nextInt = random.nextInt(big - small) + small;
        return "" + s + d + nextInt;
    }
}
