package com.codefarmEquipment.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codefarmEquipment.model.Equipment;

import com.codefarmEquipment.model.User;
import com.codefarmEquipment.repository.EquipmentRepository;
import com.codefarmEquipment.repository.UserRepository;

@Service
public class EquipmentService {

    @Autowired
    private EquipmentRepository equipmentRepository;

    @Autowired
    private UserRepository userRepository;
	
	  public Equipment save(String username, Equipment equipment) { User user =
	  userRepository.findByUsername(username); equipment.setUser(user); return
	  equipmentRepository.save(equipment); }
	 


}