package colouredLights;

import java.io.PrintStream;
import java.util.Scanner;

public class UserComms {

    public PrintStream systemOut(){
        return System.out;
    }

    public String userInput() {
        Scanner scanner = new Scanner(System.in);
        return scanner.next();
    }

}
