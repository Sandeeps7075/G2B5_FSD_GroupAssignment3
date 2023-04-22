package com.sandeep.tta.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sandeep.tta.dao.TicketRepository;
import com.sandeep.tta.model.Ticket;

@Service
public class TicketServicesImpl implements TicketServices {

	@Autowired
	public TicketRepository ticketRepository;

	@Override
	public List<Ticket> getAllTickets() {
		return ticketRepository.findAll();
	}

	@Override
	public void saveTicket(Ticket ticket) {
		this.ticketRepository.save(ticket);

	}

	@Override
	public Ticket getTicketById(long id) {
		Optional<Ticket> optional = ticketRepository.findById(id);
		Ticket ticket = null;
		if (optional.isPresent()) {
			ticket = optional.get();
		} else {
			throw new RuntimeException("Ticket not for id" + id);
		}
		return ticket;
	}

	@Override
	public void deleteTicketById(long id) {
		this.ticketRepository.deleteById(id);

	}

	@Override
	public List<Ticket> searchBy(String title, String description) {
		return ticketRepository.findByTitleContainsAndDescriptionContainsAllIgnoreCase(title, description);
	}
}
