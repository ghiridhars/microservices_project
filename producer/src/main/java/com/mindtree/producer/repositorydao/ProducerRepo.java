package com.mindtree.producer.repositorydao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.mindtree.producer.entity.Producer;

public interface ProducerRepo extends JpaRepository<Producer, Integer> {

	@Query("select p from Producer p where p.name=?1")
	public Producer findByName(String name);
}
