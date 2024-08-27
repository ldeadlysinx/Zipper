package com.example.demo.Repository;

import com.example.demo.entity.Board1;
import com.example.demo.entity.Member;
import com.example.demo.entity.Notification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NotificationRepository extends JpaRepository<Notification, Long> {

    @Query("SELECT n FROM Notification n JOIN FETCH n.member WHERE n.member = :member ORDER BY a.createdDate DESC")
    List<Notification> findByMember(Member member);
}
