package com.TicketBooking.Application.Service;

import com.TicketBooking.Application.Controller.Dto.TicketDTO;

public interface TicketService {
    public String saveTicket(TicketDTO ticket) throws Exception;
}
