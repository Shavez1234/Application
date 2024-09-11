package com.TicketBooking.Application.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
@Entity
@Table(name = "ticket")
public class Ticket {

    // Getters and Setters
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Getter
    @Setter
    private String name;
    @Getter
    @Setter
    private String source;

    @Setter
    @Getter
    private String destination;
    @Getter
    @Setter
    private Date date;
    @Setter
    @Getter
    private String ticketNumber;

    @Override
    public String toString() {
        return "Ticket{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", source='" + source + '\'' +
                ", destination='" + destination + '\'' +
                ", date=" + date +
                ", ticketNumber='" + ticketNumber + '\'' +
                '}';
    }
}

