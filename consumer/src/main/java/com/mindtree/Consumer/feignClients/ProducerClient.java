package com.mindtree.Consumer.feignClients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.mindtree.Consumer.model.Producer;

@Service
@FeignClient(name = "producerService",
		url = "http://localhost:8989/onlineStore/producerService/producer")
public interface ProducerClient {

	@GetMapping(value = "/getProducerBy/{name}")
	public Producer getProducerBy(@PathVariable String name);
}
