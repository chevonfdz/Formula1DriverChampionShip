/**
 * Name: Chevon Fernando
 * Westminster no: w1839044
 * IIT no: 20200970
 */
package F1champinship;

public interface ChampionshipManager
{
    void addNewDriver(Formula1Driver formula1Driver);

    void removeDriver(String removeDriverTeam);

    void changeDriver(String preDriverName, String newDriverName);

    void displayDriverStatistics(String statDriverName);

    void displayFormula1DriverTable();

    void addRace(int year,int month, int date);

    void saveInformationInFile();

    void readInformationInFile();
}