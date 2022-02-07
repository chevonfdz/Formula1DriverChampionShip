/**
 * Name: Chevon Fernando
 * Westminster no: w1839044
 * IIT no: 20200970
 */
package F1champinship;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Formula1ChampionshipManager implements ChampionshipManager, Serializable{

    public static final String reset = "\u001B[0m";
    public static final String cyan = "\u001B[36m";
    public static final String purple = "\u001B[35m";
    public static final String blackBackground = "\u001B[40m";
    /**
     * creating static arraylist to store date using formula1driver class
     */
    static ArrayList<Formula1Driver> formula1DriverList = new ArrayList<>();

    /**
     * adding the driver information to the array named formula1DriverList
     * calling the method to save the information to the file
     */
    @Override
    public void addNewDriver(Formula1Driver formula1Driver)
    {
        formula1DriverList.add(formula1Driver);
        System.out.println("Driver team added successfully");
        saveInformationInFile();
    }


    /**
     * Using for loop checking all the team names that the user entered,
     * and if the user entered team names is equal to our stored team names then it will delete the driver object from the array.
     * If the team name is not there then it will print The Team you entered is not here, try again
     */
    @Override
    public void removeDriver(String removeDriverTeam)
    {
        for (int i = 0; i < formula1DriverList.size(); i++) {
            if (formula1DriverList.get(i).getTeamNames().equals(removeDriverTeam)){
                formula1DriverList.remove(i);
                System.out.println("Team deleted successfully");
                break;
            } else {
                if(i == (formula1DriverList.size() -1)) {
                    System.out.println("The Team you entered is not here, try again");
                    break;
                }
            }
        }
    }


    /**
     * using for loop checking all the driver names in the array that the user entered previously,
     * and if the user entered driver names is equal to our stored team names,
     * then it will change the previous driver name to the added new driver name.
     * If the team name is not there then it will print The Name you entered is not here, try again
     */
    @Override
    public void changeDriver(String preDriverName, String newDriverName)
    {
        for(int i = 0; i < formula1DriverList.size(); i++){
            if(formula1DriverList.get(i).getDriverName().equals(preDriverName)){
                formula1DriverList.get(i).setDriverName(newDriverName);
                System.out.println(formula1DriverList.get(i).toString());
            } else {
                if(i == (formula1DriverList.size() -1)) {
                    System.out.println("The Name you entered is not here, try again");
                    break;
                }
            }
        }
    }


    /**
     * using for loop checking all the driver names in the array that the user entered previously,
     * and if the user entered driver names is equal to our stored team names,
     * then it will display all statistics from the driver that user has entered.
     * If the team name is not there then it will print The Name you entered is not here, try again
     */
    @Override
    public void displayDriverStatistics(String statDriverName)
    {
        for(int i=0; i < formula1DriverList.size(); i++){
            if(formula1DriverList.get(i).getDriverName().equals(statDriverName)){
                System.out.println(formula1DriverList.get(i).toString());
                break;
            }else {
                if(i == (formula1DriverList.size() -1)){
                    System.out.println("The club you entered is not here, try again");
                    break;
                }
            }
        }
    }


    /**
     * This will print the driver statistics table with colored Output.
     */
    @Override
    public void displayFormula1DriverTable()
    {
        /**
         * Checking the driver order according to the points that driver get
         * and sorting according to the Driver Compare number of points that driver got
         * and call the driver compare method using this object
         */
        DriverCompare driverCompare = new DriverCompare();
        formula1DriverList.sort(driverCompare);

        System.out.println(cyan+"...................................... Formula 1 Championship Diver statics Table .........................................."+reset);
        System.out.println(blackBackground+"____________________________________________________________________________________________________________________________"+reset);
        System.out.printf(purple+"%-14s %-14s %-18s %-12s %-12s %-12s %-18s %-18s", "| Diver Name |", "| Location |", "| Team Name |","| Firsts |", "| Seconds |", "| Thirds |", "| Num of Points |","| Num of Races |"+reset);
        System.out.println(blackBackground+"__________________________________________________________________________________________________________________________"+reset);
        for (Formula1Driver driver : formula1DriverList) {
            System.out.printf(blackBackground+"|%-14s %-14s %-18s %-13s %-13s %-15s %-18s %-32s|",
                    driver.getDriverName(),
                    driver.getDriverLocation(),
                    driver.getTeamNames(),
                    driver.getFirstPosition(),
                    driver.getSecondPosition(),
                    driver.getThirdPosition(),
                    driver.getNumberOfPoints(),
                    driver.getNumberOfRaces()+reset);
            System.out.println(cyan+"__________________________________________________________________________________________________________________________"+reset);
        }
    }


    /**
     * when the user wants to add a race the user has to enter the places that the driver has achieved.
     * after entering the position system will automatically update
     * the driver's position, the number of races, and the number of points that driver got.
     */
    @Override
    public void addRace(int year,int month, int date)
    {
        Scanner input = new Scanner(System.in);
        for (Formula1Driver driver : formula1DriverList) {
            System.out.println("Enter driver position of  " + driver.getDriverName() + ": ");
            String name = driver.getDriverName();
            int newPositionDriver = input.nextInt();
            switch (newPositionDriver) {
                /**
                 * To avoid code duplication create the method named addDetails and this will automatically update driver statistics
                 */
                case 1 -> {
                    driver.setFirstPosition(driver.getFirstPosition() + 1);
                    addDetails(25, name);}
                case 2 -> {
                    driver.setSecondPosition(driver.getSecondPosition() + 1);
                    addDetails(18, name);}
                case 3 -> {
                    driver.setThirdPosition(driver.getThirdPosition() + 1);
                    addDetails(15, name);}
                case 4 -> addDetails(12, name);
                case 5 -> addDetails(10, name);
                case 6 -> addDetails(8, name);
                case 7 -> addDetails(6, name);
                case 8 -> addDetails(4, name);
                case 9 -> addDetails(2, name);
                case 10 -> addDetails(1, name);
                default -> addDetails(0, name);
            }
        }
    }


    /** updating the driver statistic */
    public void addDetails(int points, String name)
    {
        for (Formula1Driver driver : formula1DriverList) {
            if (driver.getDriverName().equals(name)) {
                driver.setNumberOfPoints(driver.getNumberOfPoints() + points);
                driver.setNumberOfRaces(driver.getNumberOfRaces() + 1);
            }
        }
    }


    /** Saving all the information to the file named Formula1Championship.txt */
    @Override
    public void saveInformationInFile()
    {
        try{
            FileOutputStream fos = new FileOutputStream("Formula1Championship.src");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(formula1DriverList);

            System.out.println("File store successfully");
        }catch (IOException e){
            e.printStackTrace();
            System.out.println("couldn't find store data");
        }
    }


    /** Saving all the information to the file named Formula1Championship.txt */
    @Override
    public void readInformationInFile()
    {
        try {
            FileInputStream fos = new FileInputStream("Formula1Championship.src");
            ObjectInputStream oos = new ObjectInputStream(fos);
                formula1DriverList = (ArrayList) oos.readObject();
                oos.close();
                System.out.println("Data loaded");

        }catch (IOException | ClassNotFoundException e){
            e.printStackTrace();
        }
    }

    /**
     * Referred sites:
     * @https://www.geeksforgeeks.org/java-math-random-method-examples/
     * @https://www.geeksforgeeks.org/initializing-a-list-in-java/
     * @https://www.tutorialspoint.com/get-the-index-of-a-particular-element-in-an-arraylist-in-java
     * @https://www.geeksforgeeks.org/how-to-print-colored-text-in-java-console/
     * @https://www.baeldung.com/java-printstream-printf
     * @https://www.javatpoint.com/java-fileinputstream-class
     */

}
