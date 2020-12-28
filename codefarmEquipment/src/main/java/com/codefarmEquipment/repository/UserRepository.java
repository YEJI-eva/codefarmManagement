package com.codefarmEquipment.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codefarmEquipment.model.User;


public interface UserRepository extends JpaRepository<User, Long>  {

	 User findByUsername(String username);

}
