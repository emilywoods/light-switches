package colouredLights;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

import static java.lang.System.in;
import static java.lang.System.out;

@SpringBootApplication
public class Application implements CommandLineRunner {

    public static void main (String args[]) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        UserComms userComms = new UserComms();
        new UserCommsManager(userComms).getUserInput();
    }
}
