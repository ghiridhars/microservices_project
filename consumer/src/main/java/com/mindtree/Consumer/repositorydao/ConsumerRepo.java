package com.mindtree.Consumer.repositorydao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mindtree.Consumer.model.Consumer;

public interface ConsumerRepo extends JpaRepository<Consumer, Integer>{
	
}
