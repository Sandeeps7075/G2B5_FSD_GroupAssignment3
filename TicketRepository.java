package com.sandeep.tta.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sandeep.tta.model.Ticket;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long> {

	/*
	 * @Query("SELECT ticket FROM Ticket ticket WHERE CONCAT(ticket.title,'',ticket.description)LIKE %?1%"
	 * )
	 */
	List<Ticket> findByTitleContainsAndDescriptionContainsAllIgnoreCase(String title, String description);

}
