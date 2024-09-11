package com.TicketBooking.Application.Controller.Dto;

import java.util.Date;

public class TicketDTO {
    private String name;
    private String source;
    private String destination;
    private String date;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "TicketDTO{" +
                "name='" + name + '\'' +
                ", source='" + source + '\'' +
                ", destination='" + destination + '\'' +
                ", date=" + date +
                '}';
    }
}
