package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.Comentario;

public interface ComentarioRepository extends JpaRepository<Comentario, Long> {

}
