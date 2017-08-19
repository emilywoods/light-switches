package colouredLights.model;

import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class Light {
    public List<String> colour = Arrays.asList("Blue", "Green", "Red");
    public enum State { ON, OFF }

}
