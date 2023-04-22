package com.sandeep.tta.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sandeep.tta.model.Ticket;
import com.sandeep.tta.services.TicketServices;

@Controller
public class TicketController {

	@Autowired
	private TicketServices ticketServices;

	@GetMapping("/")
	public String ticketList(Model model) {
		model.addAttribute("ticketList", ticketServices.getAllTickets());
		return "ticket";

	}

	@GetMapping("/showFormForAddaTicket")
	public String showFormForAddaTicket(Model model) {
		Ticket ticket = new Ticket();
		model.addAttribute("ticket", ticket);
		return "generate_ticket";

	}

	@PostMapping("/saveTicket")
	public String saveTicket(@ModelAttribute Ticket ticket) {
		ticketServices.saveTicket(ticket);
		return "redirect:/";

	}

	@GetMapping("/showFormForEdit/{id}")
	public String showFormForEdit(@PathVariable(value = "id") long id, Model model) {
		Ticket ticket = ticketServices.getTicketById(id);
		model.addAttribute("ticket", ticket);
		return "edit";

	}

	@GetMapping("/viewTicket/{id}")
	public String viewTicket(@PathVariable(value = "id") long id, Model model) {
		Ticket ticket = ticketServices.getTicketById(id);
		model.addAttribute("ticket", ticket);
		return "view_ticket";
	}

	@GetMapping("/searchTicket")
	public String searchTicket(@RequestParam("title") String title, @RequestParam("description") String description,
			Model model) {
		if (title.trim().isEmpty())
			return "redirect:/";
		else {
			List<Ticket> ticket = ticketServices.searchBy(title, description);
			model.addAttribute("ticketList", ticket);
			return "ticket";
		}
	}

	@GetMapping("/deleteTicket/{id}")
	public String deleteTicketById(@PathVariable(value = "id") long id) {
		this.ticketServices.deleteTicketById(id);
		return "redirect:/";

	}

}
