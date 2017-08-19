package colouredLights.utils;

import org.springframework.stereotype.Component;

import java.io.PrintStream;
import java.util.Scanner;

@Component
public class UserCommsService {

    public PrintStream systemOut(){
        return System.out;
    }

    public String userInput() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

}
