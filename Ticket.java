package com.sandeep.tta.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "Ticket")
public class Ticket {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private long id;

	@Column(name = "Ticket_Title")
	private String title;

	@Column(name = "Ticket_Short_Description")
	private String description;

	@Column(name = "Ticket_Created_on")
	@Temporal(TemporalType.DATE)
	private Date ticketCreatedDate = new Date(System.currentTimeMillis());

	@Column(name = "Content")
	private String content;

	public Ticket() {

	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getTicketCreatedDate() {
		return ticketCreatedDate;
	}

	public void setTicketCreatedDate(Date ticketCreatedDate) {
		this.ticketCreatedDate = ticketCreatedDate;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Ticket(long id, String title, String description, Date ticketCreatedDate, String content) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.ticketCreatedDate = ticketCreatedDate;
		this.content = content;
	}

}
