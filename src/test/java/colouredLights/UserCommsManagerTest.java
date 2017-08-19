package colouredLights;

import colouredLights.utils.UserCommsService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class UserCommsManagerTest {
    UserCommsManager subjectUnderTest;

    Integer userInput;

    @Mock
    UserCommsService mockUserComms;

    @Before
    public void setup() {
        subjectUnderTest = new UserCommsManager(mockUserComms);
    }

    @Test(expected = IllegalArgumentException.class)
    public void getUserInputInteger_givenUserInputsNonNumber_thenThrowsException() {
        givenTheSystemPrintsAMessage();
        givenTheUserInputs("Hello");

        whenGetUserInputIntegerIsCalled();
    }

    @Test(expected = IllegalArgumentException.class)
    public void getUserInputInteger_givenUserInputsNonInteger_thenThrowsException() {
        givenTheSystemPrintsAMessage();
        givenTheUserInputs("4.1");

        whenGetUserInputIntegerIsCalled();
    }

    @Test
    public void getUserInputInteger_givenUserGivesNoInput_thenSetsInputTo20() {
        givenTheSystemPrintsAMessage();
        givenTheUserInputsNothing();

        whenGetUserInputIntegerIsCalled();

        thenTheInputIsSetTo20();
    }

    @Test
    public void printLightState_printsCurrentTime() {
        givenTheSystemPrintsAMessage();

        whenPrintLightStateIsCalledWithCurrentTimeAndPosition("00:00:00");

        thenPrintsToConsole();
    }

    private void givenTheSystemPrintsAMessage(){
        when(mockUserComms.systemOut()).thenReturn(System.out);
    }

    private void  givenTheUserInputsNothing() {
        when(mockUserComms.userInput()).thenReturn(null);
    }

    private void givenTheUserInputs(String input) {
        when(mockUserComms.userInput()).thenReturn(input);
    }

    private void whenGetUserInputIntegerIsCalled() {
        userInput = subjectUnderTest.getUserInputInteger();
    }

    private void whenPrintLightStateIsCalledWithCurrentTimeAndPosition(String time) {
        subjectUnderTest.printLightState(time);
    }

    private void thenTheInputIsSetTo20(){
        assertThat(userInput, is(20));
    }

    private void thenPrintsToConsole() {
        verify(mockUserComms, times(1)).systemOut();
    }

}
