package colouredLights.utils;

import colouredLights.utils.TimeService;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class TimeServiceTest {

    TimeService subjectUnderTest;

    @Before
    public void setup() {
        subjectUnderTest = new TimeService();
    }

    @Test
    public void currentTime_returnsCurrentTime() {
        assertTrue(subjectUnderTest.currentTime().matches("\\d{2}:\\d{2}:\\d{2}"));
    }

}
