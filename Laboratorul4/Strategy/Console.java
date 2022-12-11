package Strategy;

import Template.Programmers;
import Template.User;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Console implements Strategy {

    private String getUserInput() {
        String ecuation = "Error";
        try {
            // Enter data using BufferReader
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(System.in));

            // Reading data using readLine
            ecuation = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ecuation;
    }

    @Override
    public String calculate(){
        User user = new Programmers("programmer", "programmer");
        System.out.println("User please write input : (like 'adds 5 and 2000001') ");
        String ex = getUserInput();
        return "Result is" + user.calculate(ex);
    }
}
