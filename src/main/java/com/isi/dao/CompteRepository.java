package com.isi.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.isi.entities.Compte;

public interface CompteRepository extends JpaRepository<Compte, Long> {

}
