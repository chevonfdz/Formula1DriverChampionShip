/**
 * Name: Chevon Fernando
 * Westminster no: w1839044
 * IIT no: 20200970
 */
package F1champinship;

import java.io.Serializable;

public class Formula1Driver extends Driver implements Serializable {
    private int firstPosition;
    private int secondPosition;
    private int thirdPosition;
    private int numberOfPoints;
    private int numberOfRaces;

    /**
     * creating constructor
     */
    Formula1Driver(int firstPosition, int secondPosition, int thirdPosition, int numberOfPoints,
                   int numberOfRaces, String driverName, String driverLocation, String teamNames) {
        super(driverName, driverLocation, teamNames);
        this.firstPosition = firstPosition;
        this.secondPosition = secondPosition;
        this.thirdPosition = thirdPosition;
        this.numberOfPoints = numberOfPoints;
        this.numberOfRaces = numberOfRaces;
    }


    /**
     * creating getter and setter to set and get values to the array
     */
    public int getFirstPosition() {
        return firstPosition;
    }

    public void setFirstPosition(int firstPosition) {
        this.firstPosition = firstPosition;
    }

    public int getSecondPosition() {
        return secondPosition;
    }

    public void setSecondPosition(int secondPosition) {
        this.secondPosition = secondPosition;
    }

    public int getThirdPosition() {
        return thirdPosition;
    }

    public void setThirdPosition(int thirdPosition) {
        this.thirdPosition = thirdPosition;
    }

    public int getNumberOfPoints() {
        return numberOfPoints;
    }

    public void setNumberOfPoints(int numberOfPoints) {
        this.numberOfPoints = numberOfPoints;
    }

    public int getNumberOfRaces() {
        return numberOfRaces;
    }

    public void setNumberOfRaces(int numberOfRaces) {
        this.numberOfRaces = numberOfRaces;
    }

    @Override
    public String toString() {
        return  "Drivers' Name = " + getDriverName()+" | "+
                "Location = " + getDriverLocation()+" | "+
                "Team = " + getTeamNames()+ " | "+
                "firstPosition = " + firstPosition +
                " | secondPosition = " + secondPosition +
                " | thirdPosition = " + thirdPosition +
                " | numberOfPoints = " + numberOfPoints +
                " | numberOfRaces = " + numberOfRaces +" ";
    }
}
