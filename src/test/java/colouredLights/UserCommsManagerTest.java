package colouredLights;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class UserCommsManagerTest {
    UserCommsManager subjectUnderTest;

    @Mock
    UserComms mockUserComms;

    @Before
    public void setup() {
        subjectUnderTest = new UserCommsManager(mockUserComms);
    }

    @Test(expected = IllegalArgumentException.class)
    public void getUserInput_givenUserInputsNonNumber_thenThrowsException() {
        givenTheSystemPrintsAMessage();
        givenTheUserInputs("Hello");

        whenRunAppIsCalled();
    }

    @Test(expected = IllegalArgumentException.class)
    public void getUserInput_givenUserInputsNonInteger_thenThrowsException() {
        givenTheSystemPrintsAMessage();
        givenTheUserInputs("4.1");

        whenRunAppIsCalled();
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

    private void whenRunAppIsCalled() {
        subjectUnderTest.getUserInput();
    }
}
