package com.nttdata.book.ticket.app;

import java.util.Date;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.nttdata.book.ticket.app.entities.Ticket;
import com.nttdata.book.ticket.app.service.TicketBookingService;

@SpringBootApplication
public class TicketBookingManagementAppApplication implements CommandLineRunner {
	
	@Autowired
	private DataSource dataSource;
	@Autowired
	private TicketBookingService ticketBookingService;

	public static void main(String[] args) {
		
	 SpringApplication.run(TicketBookingManagementAppApplication.class, args);
		
		
	}

	@Override
	public void run(String... args) throws Exception {
		Ticket ticket = new Ticket();
		ticket.setBookingDate(new Date());
		ticket.setDestStation("Mumbai");
		ticket.setSourceStation("Pune");
		ticket.setPassengerName("KK");
		ticket.setEmail("kk@yahoo.com");
		
		Ticket t = ticketBookingService.createTicket(ticket);
		System.out.println("Ticket Id : "+t.getTicketId());
		System.out.println("DataSource "+dataSource.getClass());
	}

}
