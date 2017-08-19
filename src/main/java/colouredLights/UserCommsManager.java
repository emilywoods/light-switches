package colouredLights;

import org.springframework.beans.factory.annotation.Autowired;

import java.io.PrintStream;
import java.util.Scanner;

public class UserCommsManager {
    private UserComms userComms;

    @Autowired
    public UserCommsManager(UserComms userComms) {

        this.userComms = userComms;
    }

    public String getUserInput() {
        userComms.systemOut().println("Select a number of colours");
        String numberOfLights = userComms.userInput();
        validateInput(numberOfLights);


        return numberOfLights;
        // Message: what number?
        // Get user input
        // Validate user input
        // While the value is less than the number of user input then output to terminal
        // Mapper class output is

    }

    private void validateInput(String numberOfLights) {
        if(!numberOfLights.matches("\\d+")) {
            throw new IllegalArgumentException("Error: Input was not an integer number");
        }
    }
}
