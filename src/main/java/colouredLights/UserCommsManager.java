package colouredLights;

import colouredLights.utils.UserCommsService;
import org.springframework.beans.factory.annotation.Autowired;

public class UserCommsManager {
    public final String DEFAULT_NUMBER_OF_LIGHTS = "20";
    private UserCommsService userComms;

    @Autowired
    public UserCommsManager(UserCommsService userComms) {
        this.userComms = userComms;
    }

    public Integer getUserInputInteger() {
        String stringNumberOfLights  = getUserInput();
        return Integer.parseInt(stringNumberOfLights);
    }

    public void printLightState(String lightState) {
        userComms.systemOut().println(lightState);
    }

    private String getUserInput() {
        userComms.systemOut().println("Select a number of colours");
        String numberOfLights = userComms.userInput();

        if (numberOfLights.isEmpty()) {
            userComms.systemOut().println("No input provided. Default = 20");
            numberOfLights = DEFAULT_NUMBER_OF_LIGHTS;
        }

        validateInput(numberOfLights);
        return numberOfLights;
    }

    private void validateInput(String numberOfLights) {
        if(!numberOfLights.matches("\\d+")) {
            throw new IllegalArgumentException("Error: Input was not an integer number");
        }
    }
}
