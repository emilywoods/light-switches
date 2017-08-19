package colouredLights;

import colouredLights.model.Light;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;


public class LightStatePresenterTest {
    public static final String CURRENT_TIME = "00:00:00";
    public static final String POSITION = "10";
    public static final String COLOUR = "white";
    LightStatePresenter subjectUnderTest;
    String result;

    @Before
    public void setup() {
        subjectUnderTest = new LightStatePresenter();
    }

    @Test
    public void getLightState_returnsLightStateString(){
        whenGetLightStateIsCalled();

        thenReturnsLightStateString();
    }

    private void whenGetLightStateIsCalled() {
        result = subjectUnderTest.getLightState(CURRENT_TIME, POSITION, Light.State.OFF, COLOUR);
    }


    private void thenReturnsLightStateString() {
        assertThat(result, is(CURRENT_TIME + " " + POSITION + " " + COLOUR + " Light " + Light.State.OFF));
    }

}
