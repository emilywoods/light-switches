package colouredLights;

import colouredLights.model.Light;
import org.springframework.stereotype.Component;

@Component
public class LightStatePresenter {

    public String presentLightState(String currentTime, int currentPosition, Light.State lightState, String lightColour) {
        String currentPositionString = String.valueOf(currentPosition);
        return currentTime + " " + currentPositionString + " " + lightColour + " Light " + lightState;
    }

}
