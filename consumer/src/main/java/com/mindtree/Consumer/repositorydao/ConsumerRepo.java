package com.mindtree.Consumer.repositorydao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mindtree.Consumer.entity.Consumer;

@Repository
public interface ConsumerRepo extends JpaRepository<Consumer, Integer> {

}
