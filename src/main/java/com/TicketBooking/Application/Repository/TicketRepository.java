package com.TicketBooking.Application.Repository;

import com.TicketBooking.Application.Entity.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository<Ticket, Integer> {

    Ticket findByTicketNumber(String ticketNumber);
}
