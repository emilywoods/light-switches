package colouredLights.model;

import java.util.List;

public class Light {

    public State state;
    public List<String> colour;

    public enum State {
        ON, OFF
    }

}
