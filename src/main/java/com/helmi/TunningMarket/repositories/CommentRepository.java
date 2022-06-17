package com.helmi.TunningMarket.repositories;

import com.helmi.TunningMarket.entities.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}
