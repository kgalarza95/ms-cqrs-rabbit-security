package ec.com.sofka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//16. Configure the main class that relates to this new app
@SpringBootApplication
public class ConsumerApplication {
    public static void main(String[] args) {
        System.out.println("++++++++++++++++ConsumerApplication");
        SpringApplication.run(ConsumerApplication.class, args);
    }
}
