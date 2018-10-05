package eu.babywatcher;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.hateoas.config.EnableEntityLinks;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
@EnableTransactionManagement
@EntityScan(basePackages = "eu.babywatcher.got.entity")
@EnableJpaRepositories(basePackages = "eu.babywatcher.got.repository")
@EnableEntityLinks 
public class MsGotApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsGotApplication.class, args);
	}
}
