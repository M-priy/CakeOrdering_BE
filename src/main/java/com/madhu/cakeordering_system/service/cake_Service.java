package com.madhu.cakeordering_system.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.madhu.cakeordering_system.entity.cake;
import com.madhu.cakeordering_system.repository.cakerepo;

@Service
public class cake_Service {
	@Autowired
	private cakerepo ckrepo;
	
	
	public cake savecake(cake c) {
		return ckrepo.save(c);
	}
	
	
	public List<cake> findall(int pgno, int pgsize){
		PageRequest pg= PageRequest.of(pgno, pgsize);
		Page<cake> pageresult=ckrepo.findAll(pg);
		return pageresult.toList();
	}
	
	
	public cake getcakeById(int id) {
		return ckrepo.findById(id).orElse(null);
	}
	
	public cake updatecakeById(int id, cake c) {
		cake existingcake=ckrepo.findById(id).orElse(null);
		existingcake.setCategory(c.getCategory());
		existingcake.setName(c.getName());
		existingcake.setCost(c.getCost());
		existingcake.setPaymode(c.getPaymode());
		existingcake.setDelivery(c.getDelivery());
		
		 return ckrepo.save(existingcake);
		
	}
	public List<cake> getAllDetails(){
		return ckrepo.findAll();
	}
	
	
	
	public boolean deletecakeById(int id) {
		try {
			ckrepo.deleteById(id);
			
		}
		catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
}
