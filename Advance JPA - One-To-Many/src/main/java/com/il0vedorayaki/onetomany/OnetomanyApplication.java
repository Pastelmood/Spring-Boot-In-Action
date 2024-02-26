package com.il0vedorayaki.onetomany;

import com.il0vedorayaki.onetomany.entity.Ticket;
import com.il0vedorayaki.onetomany.entity.UserTicket;
import com.il0vedorayaki.onetomany.repository.TicketRepository;
import com.il0vedorayaki.onetomany.repository.UserTicketRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;
import java.util.Optional;

@SpringBootApplication
public class OnetomanyApplication {

	public static void main(String[] args) {
		SpringApplication.run(OnetomanyApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(UserTicketRepository userTicketRepository, TicketRepository ticketRepository) {
		return runner -> {
			// findAllUserTicketByUserId(userTicketRepository);
			// findAllTicketsBelongToUserByUserIdJoin(userTicketRepository);
			// findAllTicketsBelongToUserByUserIdJoinFetch(userTicketRepository);
			findAllTicketsBelongToUserWithOutNoAssociate(userTicketRepository);
		};
	}

	private void findAllTicketsBelongToUserWithOutNoAssociate(UserTicketRepository userTicketRepository) {

		String userId = "0123456789";

		List<UserTicket> userTickets = userTicketRepository.findByUserId(userId);

		System.out.println("\n====> Find all tickets belong to user without no associate");
		System.out.println("====> UserTicket ID: " + userId);
		userTickets.forEach(userTicket -> {
			System.out.println("====> UserTicket: " + userTicket);
			System.out.println("====> Ticket ID: " + userTicket.getTicket().getTicketId());
		});
	}


	/*
	This method will error "could not initialize proxy - no Session"
	The best way to handle the LazyInitializationException is to use the JOIN FETCH directive.
	 */
	private void findAllUserTicketByUserId(UserTicketRepository userTicketRepository) {
		String userId = "0123456789";

		List<UserTicket> userTickets = userTicketRepository.findByUserId(userId);

		System.out.println("\n=====> findAllUserTicketByUserId");
		System.out.println("=====> UserTicket ID: " + userId);
		userTickets.forEach(userTicket -> {
			System.out.println("====> UserTicket: " + userTicket);
			System.out.println("====> Ticket: " + userTicket.getTicket());
		});
	}

	/*
	This method will error "could not initialize proxy - no Session"
	The best way to handle the LazyInitializationException is to use the JOIN FETCH directive.
	 */
	private void findAllTicketsBelongToUserByUserIdJoin(UserTicketRepository userTicketRepository) {

		String userId = "0123456789";

		List<UserTicket> userTickets = userTicketRepository.findAllTicketBelongToUserByUserIdJoin(userId);

		System.out.println("\n=====> findAllTicketsBelongToUserByUserIdJoin");
		System.out.println("=====> UserTicket ID: " + userId);
		userTickets.forEach(userTicket -> {
			System.out.println("====> UserTicket: " + userTicket);
			System.out.println("====> Ticket: " + userTicket.getTicket());
		});

	}

	private void findAllTicketsBelongToUserByUserIdJoinFetch(UserTicketRepository userTicketRepository) {
		String userId = "0123456789";

		List<UserTicket> userTickets = userTicketRepository.findAllTicketsBelongToUserByUserIdJoinFetch(userId);

		System.out.println("\n====> findAllTicketsBelongToUserByUserIdJoinFetch");
		System.out.println("====> UserTicket ID: " + userId);
		userTickets.forEach(userTicket -> {
			System.out.println("====> UserTicket: " + userTicket);
			System.out.println("====> Ticket: " + userTicket.getTicket());
		});
	}

}
