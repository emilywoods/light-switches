package colouredLights.presenter;

import colouredLights.model.Light;
import colouredLights.presenter.LightStatePresenter;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class LightStatePresenterTest {
    LightStatePresenter subjectUnderTest;
    private final String CURRENT_TIME = "00:00:00";
    private final int POSITION = 10;
    private final String COLOUR = "white";
    String result;

    @Before
    public void setup() {
        subjectUnderTest = new LightStatePresenter();
    }

    @Test
    public void present_returnsLightStateString(){
        whenGetLightStateIsCalled();

        thenReturnsLightStateString();
    }

    private void whenGetLightStateIsCalled() {
        result = subjectUnderTest.present(CURRENT_TIME, POSITION, Light.State.OFF, COLOUR);
    }


    private void thenReturnsLightStateString() {
        assertThat(result, is(CURRENT_TIME + " " + POSITION + " " + COLOUR + " Light " + Light.State.OFF));
    }

}
