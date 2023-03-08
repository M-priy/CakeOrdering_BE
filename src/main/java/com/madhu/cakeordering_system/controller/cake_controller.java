package com.madhu.cakeordering_system.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.madhu.cakeordering_system.entity.cake;
import com.madhu.cakeordering_system.service.cake_Service;
@CrossOrigin
@RestController
public class cake_controller {
	@Autowired
	private cake_Service ckService;
	
	@PostMapping("/addcake")
	public String savecake(@RequestBody cake c) {
		ckService.savecake(c);
		return "value Added";
	}
	
	
	@GetMapping("/{pgno}/{pgsize}")
	   public List<cake> listing(@PathVariable("pgno")int pgno,@PathVariable("pgsize")int pgsize){
		   return ckService.findall(pgno, pgsize);
	  }
	   
	@GetMapping("/getorder")
	public List<cake>getAllDetails(){
		   return ckService.getAllDetails();
	  }
	   
	 @GetMapping("/{id}")
		public cake getcakeById(@PathVariable int id) {
			return ckService.getcakeById(id);
		}
	 
	 
	@PutMapping("/updatecake/{id}")
	    public cake updatecakeById(@PathVariable int id, @RequestBody cake c) {
	        return ckService.updatecakeById(id, c);
	    }
	  @DeleteMapping("/deletecake/{id}")
    public boolean deletecakeById(@PathVariable int id) {
        return ckService.deletecakeById(id);
   }
}
