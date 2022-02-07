/**
 * Name: Chevon Fernando
 * Westminster no: w1839044
 * IIT no: 20200970
 */
package F1champinship;

import java.util.InputMismatchException;

public class Exceptions {
    public boolean ifString(String userInput) {
        if(!userInput.matches("[a-zA-Z\\s]+")){
            System.out.println("Invalid Input please enter the correct String word!");
            return true;
        }
        return false;
    }

    public boolean ifInteger(String userInput) {
        try {
            Integer.parseInt(userInput);
        } catch (NumberFormatException | InputMismatchException e) {
            //the parseDouble failed and you need to handle it here
            System.out.printf("Error: %s is not a valid number.\n\n", userInput);
            return true;
        }
        return false;
    }
}