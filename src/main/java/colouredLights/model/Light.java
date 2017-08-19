package colouredLights.model;

import java.util.Arrays;
import java.util.List;

public class Light {

    public List<String> colour = Arrays.asList("Blue", "Green", "Red");

    public enum State {
        ON, OFF
    }


}
