package com.codefarmEquipment.controller;

import static org.hamcrest.CoreMatchers.both;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.codefarmEquipment.model.Equipment;
import com.codefarmEquipment.model.Purchase;
import com.codefarmEquipment.repository.EquipmentRepository;
import com.codefarmEquipment.repository.PurchaseRepository;

import javassist.NotFoundException;

@Controller
@RequestMapping("/equipment")
public class EquipmentController {
		
		@Autowired
		private  EquipmentRepository  equipmentRepository; //여기에 있는 데이터를 가져오기 
	    
	    
		@Autowired
		private  PurchaseRepository  purchaseRepository; //여기에 있는 데이터를 가져오기 

		
		@GetMapping("/list")
		public String list(Model model) {
			List<Equipment> equipments = equipmentRepository.findAll();
			List<Purchase> purchases = purchaseRepository.findAll();

			model.addAttribute("equipments",equipments); 
			model.addAttribute("purchases",purchases); 

			return "equipment/list";
		}
		
		@RequestMapping({"new", "/list"})
	    public ModelAndView resister(@PathVariable(name = "deviceGbcd", required = false) String deviceGbcd) throws NotFoundException {
	        ModelAndView mv = new ModelAndView("/list");
	        if (deviceGbcd != null) {
				List<Equipment> equipments = equipmentRepository.findByDeviceGbcd(deviceGbcd);
	            
				mv.addObject("equipments",equipments);
	        }
	        return mv;
	    }
		
		
		@GetMapping("/UseList")
		public String UseList(Model model) { 
			
			List<Equipment> equipments = equipmentRepository.findAll();
			List<Purchase> purchases = purchaseRepository.findAll();


			model.addAttribute("equipments",equipments); 
			model.addAttribute("purchases",purchases); 
			return "equipment/UseList";
		}
		

		
	/*
	 * @GetMapping("/form") public String form(Model model, @RequestParam(required
	 * =false) Long device_id) { if(device_id==null) {
	 * model.addAttribute("equipment", new Equipment()); } else { Equipment
	 * equipment =equipmentRepository.findById(device_id).orElse(null);
	 * model.addAttribute("equipment", equipment); } return "equipment/form"; }
	 */
		
		
}