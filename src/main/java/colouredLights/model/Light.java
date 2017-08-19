package colouredLights.model;

public class Light {

    public State state;
    public Colour colour;

    public enum State {
        ON, OFF
    }

    public enum Colour {
        RED, GREEN, WHITE
    }

}
