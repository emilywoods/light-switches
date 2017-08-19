package colouredLights;

import colouredLights.model.Light;
import colouredLights.utils.TimeService;
import colouredLights.utils.UserCommsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.concurrent.TimeUnit;

@SpringBootApplication
public class Application implements CommandLineRunner {
    UserCommsService userComms;
    TimeService timeService;
    UserCommsManager userCommsManager;
    LightStatePresenter lightStatePresenter;
    Light light;

    @Autowired
    public Application(
            UserCommsService userComms,
            TimeService timeService,
            UserCommsManager userCommsManager,
            LightStatePresenter lightStatePresenter,
            Light light
    ) {

        this.userComms = userComms;
        this.timeService = timeService;
        this.userCommsManager = userCommsManager;
        this.lightStatePresenter = lightStatePresenter;
        this.light = light;
    }

    public static void main(String args[]) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Integer userInput = userCommsManager.getUserInputInteger();

        int currentPosition = 1;
        int lightListElement = 0;
        while (currentPosition <= userInput) {
            if (lightListElement == light.colour.size()) lightListElement = 0;
            outputState(currentPosition, lightListElement, Light.State.ON);
            outputState(currentPosition, lightListElement, Light.State.OFF);
            lightListElement += 1;
            currentPosition += 1;
        }
    }

    private void outputState(int currentPosition, int lightListElement, Light.State lightState) throws InterruptedException {
        String lightOff = lightStatePresenter.presentLightState(timeService.currentTime(), currentPosition, lightState, light.colour.get(lightListElement));
        userCommsManager.printLightState(lightOff);
        TimeUnit.SECONDS.sleep(1);
    }
}
