package colouredLights.model;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Light {

    public State state;
    public List<String> colour = Arrays.asList("Blue", "Green", "Red");

    public enum State {
        ON, OFF
    }


}
