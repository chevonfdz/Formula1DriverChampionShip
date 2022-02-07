/**
 * Name: Chevon Fernando
 * Westminster no: w1839044
 * IIT no: 20200970
 */
package F1champinship;

import java.io.Serializable;

public abstract class Driver implements Serializable {
    private String driverName;
    private String driverLocation;
    private String teamNames;

    /**
     * creating constructor
     */
    public Driver(String driverName, String driverLocation, String teamNames){
        this.driverName = driverName;
        this.driverLocation = driverLocation;
        this.teamNames = teamNames;
    }

    /**
     * creating getter and setter to set and get values to the array
     */
    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public String getDriverLocation() {
        return driverLocation;
    }

    public String getTeamNames() {
        return teamNames;
    }

    @Override
    public String toString() {
        return "Driver{" +
                "driverName='" + driverName + '\'' +
                ", driverLocation='" + driverLocation + '\'' +
                ", teamNames='" + teamNames + '\'' +
                '}';
    }
}