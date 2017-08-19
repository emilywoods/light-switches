package colouredLights.utils;

import java.io.PrintStream;
import java.util.Scanner;

public class UserCommsService {

    public PrintStream systemOut(){
        return System.out;
    }

    public String userInput() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

}
