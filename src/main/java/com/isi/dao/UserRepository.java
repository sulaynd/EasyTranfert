package com.isi.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.isi.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
