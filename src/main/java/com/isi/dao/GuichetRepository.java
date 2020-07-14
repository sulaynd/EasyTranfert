package com.isi.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.isi.entities.Guichet;

public interface GuichetRepository extends JpaRepository<Guichet, Long> {

}
