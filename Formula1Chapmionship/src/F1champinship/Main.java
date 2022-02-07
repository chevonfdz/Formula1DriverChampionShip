/**
 * Name: Chevon Fernando
 * Westminster no: w1839044
 * IIT no: 20200970
 */
package F1champinship;

import java.io.IOException;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    /**
     * Creating an objects to reference methods
     * Following object is for Formula1ChampionshipManager class
     * Following object is for Exceptions class in there check all the exception handling
     * Following object objects for call the non-static methods from the static method
     */
    static Formula1ChampionshipManager formula1ChampionshipManager = new Formula1ChampionshipManager();
    static Exceptions exceptions = new Exceptions();
    static Main objMain = new Main();
    static Scanner input = new Scanner(System.in);
    boolean error;


    /**
     * In the main method, we are calling the menu option
     * Once the project is stated to running this will automatically load the data that we entered previously.
     */
    public static void main(String[] args) throws IOException
    {
        System.out.println("Welcome to the Formula 1 Racing Car Championship! ");
//        formula1ChampionshipManager.readInformationInFile();
        objMain.mainMenu();
    }


    /**
     * Creating a method for display the menu table that what things this programme can do.
     */
    public void mainMenu() throws IOException
    {
        do {
            System.out.println("""
                    
                    -------------- Menu Table ----------------------
                     A => Add new driver
                     B => Remove driver
                     C => Change driver
                     D => Display driver statistics
                     E => Display driver table
                     F => Add new race
                     G => Saving in a file
                     H => Read all the information
                     I => Exit the program
                     J => Open GUI
                    ---------------------------------------------------
                    """);
            System.out.print("Enter Your Option:" );

            /** Using switch case checks and redirecting to the methods that the user entered. */
            String userInput = input.next();
            String newUserInput = userInput.toUpperCase(Locale.ROOT);
            String[] args = new String[0];
            switch (newUserInput) {
                case "A" -> addNewDriver();
                case "B" -> removeDriver();
                case "C" -> changeDriver();
                case "D" -> displayDriverStatistics();
                case "E" -> formula1ChampionshipManager.displayFormula1DriverTable();
                case "F" -> addRace();
                case "G" -> formula1ChampionshipManager.saveInformationInFile();
                case "H" -> formula1ChampionshipManager.readInformationInFile();
                case "I" -> {
                    System.out.println("Thank you for using our system for Formula 1 racing car championship!!");
                    formula1ChampionshipManager.saveInformationInFile();
                    System.exit(0);
                }
                case "J" -> GUI.main(args);
                default -> System.out.println("Please enter given correct number or code!");
            }
        } while (true);
    }


    /**
     * Calling this method to Adding a new driver to the formula 1 championship,
     * when the user selects A as the option from the menu
     */
    private void addNewDriver() throws IOException
    {
        String addDriverName;
        String addDriverLocation;
        String addDriverTeamName;
        String addFirstPositions;
        String addSecondPositions;
        String addThirdPositions;
        String addNumOfPoints;
        String addNumOfRaces;
        /** Using do-while loop checking the exception from the exception class.*/

        do {
            System.out.print("Enter Drivers' Name: ");
            addDriverName = input.next();
            error = exceptions.ifString(addDriverName);
        } while (error);

        do {
            Scanner inputNew = new Scanner(System.in);
            System.out.print("Enter Drivers' Location: ");
            addDriverLocation = inputNew.next();
            error = exceptions.ifString(addDriverLocation);
        } while (error);

        /**
         * Checking whether team name is already registered to the list
         * if the team is already added to the team then the change the boolean value to the true
         */

        do {
            System.out.print("Enter Drivers' Team Name: ");
            addDriverTeamName = input.next();
            while (true) {
                boolean teamName = false;
                for (Formula1Driver driver : Formula1ChampionshipManager.formula1DriverList) {
                    if (driver.getTeamNames().equals(addDriverTeamName)) {
                        teamName = true;
                        break;
                    }
                }
                if (teamName) {
                    System.out.println("This team is already added to the team! try new team");
                    mainMenu();
                } else {
                    break;
                }
            }
            error = exceptions.ifString(addDriverTeamName);
        }while (error);

        do {
            System.out.print("Enter number of first positions: ");
            addFirstPositions = input.next();
            error = exceptions.ifInteger(addFirstPositions);
        }while (error);

        do {
            System.out.print("Enter number of Second positions: ");
            addSecondPositions = input.next();
            error = exceptions.ifInteger(addSecondPositions);
        }while (error);

        do {
            System.out.print("Enter number of third positions: ");
            addThirdPositions = input.next();
            error = exceptions.ifInteger(addThirdPositions);
        }while (error);

        do {
            System.out.print("Enter number of points: ");
            addNumOfPoints = input.next();
            error = exceptions.ifInteger(addNumOfPoints);
        }while (error);

        do {
            System.out.print("enter number of races: ");
            addNumOfRaces = input.next();
            error = exceptions.ifInteger(addNumOfRaces);
        }while (error);

        /**
         * adding all the details about driver to the created formula1driver object
         * adding the information using object to the array which is in the Formula1ChampionshipManager class
         */
        Formula1Driver formula1Driver = new Formula1Driver(Integer.parseInt(addFirstPositions), Integer.parseInt(addSecondPositions),Integer.parseInt(addThirdPositions)
                ,Integer.parseInt(addNumOfPoints), Integer.parseInt(addNumOfRaces), addDriverName, addDriverLocation, addDriverTeamName);
        formula1ChampionshipManager.addNewDriver(formula1Driver);
    }


    /**
     * Calling this method to remove a new driver from the formula 1 championship,
     * when the user selects B as the option from the menu
     */
    private void removeDriver() throws IOException
    {
        String removeDriverTeam;
        do {
            System.out.print("Enter the Drivers' Team: ");
            removeDriverTeam = input.next();
            error = exceptions.ifString(removeDriverTeam);
        } while (error);


        while (true) {
            boolean teamName = true;
            /**
             * if the team is already added to the team then the change the boolean value to the true
             */
            for (Formula1Driver driver : Formula1ChampionshipManager.formula1DriverList) {
                if (driver.getTeamNames().equals(removeDriverTeam)) {
                    teamName = false;
                    break;
                }
            }
            if (teamName) { // if the team is added
                System.out.println("Please enter the correct team name");
                mainMenu();
            } else {
                break;
            }
        }
        /**
         * adding and passing the information to the array for to delete the divers team
         */
        formula1ChampionshipManager.removeDriver(removeDriverTeam);
    }


    /**
     *  Calling this method to change a driver from the formula 1 championship driver list,
     *  when the user selects C as the option from the menu
     */
    private void changeDriver() throws IOException
    {
        String preDriverName;
        String newDriverName;
        do {
            System.out.print("Enter Drivers' Name: ");
            preDriverName = input.next();
            error = exceptions.ifString(preDriverName);
        } while (error);

        while (true){
            /**
             * if the team is already added to the team then the change the boolean value to the true
             */
            boolean teamName = true;
            for (Formula1Driver driver : Formula1ChampionshipManager.formula1DriverList){
                if(driver.getDriverName().equals(preDriverName)){
                    teamName = false;
                    break;
                }
            }
            if(teamName){ // if the team is added
                System.out.println("There is no driver name that you entered! Please try again!");
                mainMenu();
            }else{
                break;
            }
        }

        do {
            System.out.print("Enter the New Drivers' Name: ");
            newDriverName = input.next();
            error = exceptions.ifString(newDriverName);
        } while (error);

        /**
         * adding and passing the information to the array for to delete the divers team
         */
        formula1ChampionshipManager.changeDriver(preDriverName, newDriverName);
    }


    /**
     *  Calling this method to display driver statistics from the formula 1 championship driver list,
     *  when the user selects D as the option from the menu
     */
    private void displayDriverStatistics() throws IOException
    {
        String statDriverName;
        do {
            System.out.print("Enter Drivers' Name: ");
            statDriverName = input.next();
            error = exceptions.ifString(statDriverName);
        } while (error);
        /**
         * if the team is already added to the team then the change the boolean value to the true
         */
        while (true){
            boolean teamName = true;
            for (Formula1Driver driver : Formula1ChampionshipManager.formula1DriverList){
                if(driver.getDriverName().equals(statDriverName)){
                    teamName = false;
                    break;
                }
            }
            if(teamName){ // if the team is added
                System.out.println("There is no driver name that you entered! Please try again!");
                mainMenu();
            }else{
                break;
            }
        }
        /**
         * adding and passing the information to the array for to delete the divers team
         */
        formula1ChampionshipManager.displayDriverStatistics(statDriverName);
    }


    /**
     *  Calling this method to add a new race to the formula 1 championship,
     *  when the user selects F as the option from the menu
     */
    private void addRace()
    {
        if(Formula1ChampionshipManager.formula1DriverList.size() >= 10) {
            int year = 0;
            int month = 0;
            int date = 0;
            /**
             * check year data type
             * check month data type
             * check date data type
             */
            boolean checkstyle = false;
            boolean checkpoints = false;
            boolean checkmated = false;

            do {
                System.out.print("Enter the year :");
                if (input.hasNextInt()) { //check year type
                    year = input.nextInt();
                    if (year >= 2020 && year <= 2030) { //check year range
                        checkstyle = true;
                    } else {
                        checkstyle = false; //if the year is invalid display error message
                        System.out.println("Please enter a valid year");
                    }
                } else { //display error message
                    System.out.println("Please enter a valid year");
                    checkstyle = false;
                    input.next();
                }
            }
            while (!(checkstyle));

            do {
                System.out.print("Enter the month:");
                if (input.hasNextInt()) { //check month type
                    month = input.nextInt();
                    if (month > 0 && month <= 13) { //check month range
                        checkpoints = true;
                    } else {                   //display error message
                        checkpoints = false;
                        System.out.println("Please enter a valid month");
                    }
                } else {                      //display error message
                    System.out.println("Please enter a valid month");
                    checkpoints = false;
                    input.next();
                }
            }
            while (!(checkpoints));

            do {
                System.out.print("Enter the date:");
                if (input.hasNextInt()) { // check date type
                    date = input.nextInt();
                    if (date > 0 && date <= 31) { //check date range
                        checkmated = true;
                    } else {
                        checkmated = false;     //display error message
                        System.out.println("Please enter a valid date");
                    }
                } else {                    //display error message
                    System.out.println("Please enter a valid date");
                    checkmated = false;
                    input.next();
                }
            }
            while (!(checkmated));
            formula1ChampionshipManager.addRace(year, month, date);
        }else {
            System.out.println("Please add atleaste 10 driver ");
        }
    }

    /**
     * Referred sites:
     * @https://stackoverflow.com/questions/29954080/how-to-handle-exception-when-convert-string-to-double
     * @https://www.delftstack.com/howto/java/java-array-indexof/
     * @https://beginnersbook.com/2013/05/java-date-format-validation/#:~:text=Java%20Date%20Validation%3A%20Checks%20whether%20a%20Date%20is%20valid%20or%20not&text=In%20the%20method%20validateJavaDate(String,check%20other%20formats%20against%20it.
     * @https://www.baeldung.com/java-string-valid-date
     * @https://howtodoinjava.com/java/date-time/date-validation/
     * */
}
