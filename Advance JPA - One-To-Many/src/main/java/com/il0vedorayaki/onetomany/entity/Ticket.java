package com.il0vedorayaki.onetomany.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Data
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity @Table(name = "lottery", schema = "public")
public class Ticket {

    @Id
    @Column(name = "ticket_id")
    private String ticketId;

    @Column(name = "price")
    private Integer price;

    @Column(name = "amount")
    private Integer amount;

    @ToString.Exclude
    @OneToMany(mappedBy = "ticket", fetch = FetchType.LAZY)
    private List<UserTicket> userTickets;

}
