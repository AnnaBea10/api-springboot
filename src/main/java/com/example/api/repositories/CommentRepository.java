package com.example.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.api.entities.Comment;

public interface CommentRepository extends JpaRepository<Comment, Long>{
}
