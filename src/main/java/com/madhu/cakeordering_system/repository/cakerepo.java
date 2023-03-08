package com.madhu.cakeordering_system.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.madhu.cakeordering_system.entity.cake;

public interface cakerepo extends JpaRepository<cake,Integer>{
	
}
