package colouredLights;

import colouredLights.model.Light;


public class LightStatePresenter {

    public String getLightState(String currentTime, String position, Light.State lightState, String lightColour) {
        return currentTime + " " + position + " " + lightColour + " Light " + lightState;
    }
}
