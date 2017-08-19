package colouredLights;

import colouredLights.utils.UserCommsService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.when;

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

    @Test
    public void getUserInput_givenUserGivesNoInput_thenSetsInputTo20() {
        givenTheSystemPrintsAMessage();
        givenTheUserInputsNothing();

        whenRunAppIsCalled();

        thenTheInputIsSetTo20();
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
        userInput = subjectUnderTest.getUserInputInteger();
    }

    private void thenTheInputIsSetTo20(){
        assertThat(userInput, is(20));
    }
}
