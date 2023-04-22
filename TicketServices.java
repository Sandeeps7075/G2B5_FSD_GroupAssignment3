package com.sandeep.tta.services;

import java.util.List;

import com.sandeep.tta.model.Ticket;

public interface TicketServices {

	List<Ticket> getAllTickets();

	public List<Ticket> searchBy(String title, String description);

	void saveTicket(Ticket ticket);

	Ticket getTicketById(long id);

	void deleteTicketById(long id);

}
