package br.ufrn.pds.rpgturnosdomain;

import br.ufrn.pds.rpgturnosdomain.model.noonglade.NoongladeCity;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RpgturnosDomainApplication {

	public static void main(String[] args) {
		SpringApplication.run(RpgturnosDomainApplication.class, args);
		NoongladeCity.beginning();
	}

}
