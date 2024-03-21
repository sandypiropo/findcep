package com.api.findcep;

import com.api.findcep.entities.Address;
import com.api.findcep.services.ViaCEPService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.util.Scanner;

@SpringBootApplication
public class FindcepApplication {

	public static void main(String[] args) {
		SpringApplication.run(FindcepApplication.class, args);
		Scanner scanner = new Scanner(System.in);

		ViaCEPService viaCEPService = new ViaCEPService();

		System.out.println("INSIRA SEU CEP: ");
		String userCep = scanner.next();

		try {
			Address address = viaCEPService.getAdress(userCep);
			System.out.println(address);
		} catch (IOException e){
			e.printStackTrace();
		}
	}
}
