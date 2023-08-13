package com.desaextremo.retotres;

import com.desaextremo.retotres.repository.GadgetRepository;
import com.desaextremo.retotres.repository.OrderRepository;
import com.desaextremo.retotres.repository.UserRepository;
import com.desaextremo.retotres.service.GadgetService;
import com.desaextremo.retotres.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RetotresApplication implements CommandLineRunner {
	@Autowired
	private UserRepository userRepository;

	@Autowired
	private GadgetRepository gadgetRepositoy;

	@Autowired
	private OrderRepository orderRepository;

	public static void main(String[] args) {
		SpringApplication.run(RetotresApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//borrado inicial de datos
		orderRepository.deleteAll();
		userRepository.deleteAll();
		gadgetRepositoy.deleteAll();
	}
}
