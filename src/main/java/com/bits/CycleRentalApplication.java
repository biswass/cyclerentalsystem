
package com.bits;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.bits.*")
public class CycleRentalApplication {

	public static void main(String[] args) {
		SpringApplication.run(CycleRentalApplication.class, args);
	}

}

/*
 * select * from users INNER JOIN wallet ON users.wallet_id = wallet.id;
 * select * from reservation;
 * */
