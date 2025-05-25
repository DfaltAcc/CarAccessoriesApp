package za.ac.cput;

import com.sun.tools.javac.Main;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import za.ac.cput.domain.Admin;
import za.ac.cput.domain.User;

@SpringBootApplication

public class App {
    public static void main(String[] args) {

        SpringApplication.run(Main.class, args);
    }
}
