package colouredLights.manager;

import colouredLights.manager.UserCommsManager;
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
    private final int DEFAULT_NUMBER = 20;
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

        thenPrintsToConsoleTimes(2);
        thenReturnsInput(DEFAULT_NUMBER);
    }

    @Test
    public void getUserInputInteger_givenUserProvidesIntegerInput_thenReturnsInput() {
        givenTheSystemPrintsAMessage();
        givenTheUserInputs("10");

        whenGetUserInputIntegerIsCalled();

        thenPrintsToConsoleTimes(1);
        thenReturnsInput(10);
    }

    @Test
    public void printToConsole_printsToConsole() {
        givenTheSystemPrintsAMessage();

        whenPrintToConsoleIsCalledWith("Light State");

        thenPrintsToConsoleTimes(1);
    }

    private void givenTheSystemPrintsAMessage(){
        when(mockUserComms.systemOut()).thenReturn(System.out);
    }

    private void  givenTheUserInputsNothing() {
        when(mockUserComms.userInput()).thenReturn("");
    }

    private void givenTheUserInputs(String input) {
        when(mockUserComms.userInput()).thenReturn(input);
    }

    private void whenGetUserInputIntegerIsCalled() {
        userInput = subjectUnderTest.getUserInputInteger();
    }

    private void whenPrintToConsoleIsCalledWith(String output) {
        subjectUnderTest.printToConsole(output);
    }

    private void thenPrintsToConsoleTimes(int times) {
        verify(mockUserComms, times(times)).systemOut();
    }

    private void thenReturnsInput(int input) {
        assertThat(userInput, is(input));
    }

}
