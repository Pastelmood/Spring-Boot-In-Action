package com.il0vedorayaki.onetomany.repository;

import com.il0vedorayaki.onetomany.entity.UserTicket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserTicketRepository extends JpaRepository<UserTicket, Integer> {

    List<UserTicket> findByUserId(String userId);

    @Query("select ut from UserTicket ut join ut.ticket where ut.userId = :userId")
    List<UserTicket> findAllTicketBelongToUserByUserIdJoin(@Param("userId") String userId);

    @Query("select ut from UserTicket ut join fetch ut.ticket where ut.userId = :userId")
    List<UserTicket> findAllTicketsBelongToUserByUserIdJoinFetch(@Param("userId") String userId);

}
