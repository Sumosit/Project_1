package goa.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Bean
    public CommandLineRunner runner(ClientRepository clientRepository) {
        return new CommandLineRunner() {
            @Override
            public void run(String... args) throws Exception {
                for (int i = 0 ; i < 20; i++) {
                    Client c = new Client("Robot" + i, "robot" + i, "password" + i);
                    clientRepository.save(c);
                }
            }
        };
    }
}
