package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.Postagem;

public interface PostagemRepository extends JpaRepository<Postagem, Long> {

}
