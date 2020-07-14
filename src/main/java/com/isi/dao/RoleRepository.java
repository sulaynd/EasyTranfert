package com.isi.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.isi.entities.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {

}
