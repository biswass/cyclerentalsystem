

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.bits.cycleRental.*")
public class  {

	public static void main(String[] args) {
		SpringApplication.run(CycleRentalApplication.class, args);
		
	}

}
