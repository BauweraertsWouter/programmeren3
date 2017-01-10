package be.kdg.prog3.listeners;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan("be.kdg.prog3.listeners")
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
