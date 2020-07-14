package com.isi.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.isi.entities.Operation;

public interface OperationRepository extends JpaRepository<Operation, Long> {

}
