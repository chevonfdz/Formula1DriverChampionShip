/**
 * Name: Chevon Fernando
 * Westminster no: w1839044
 * IIT no: 20200970
 */
package F1champinship;

import java.util.Comparator;

public class DriverCompare implements Comparator<Formula1Driver> {

    @Override
    public int compare(Formula1Driver o1, Formula1Driver o2) {
        //comparing driver statics with the maximum points
        if(o1.getNumberOfPoints() > o2.getNumberOfPoints()){
            return -1;
        }else if (o2.getNumberOfPoints() > o1.getNumberOfPoints()){
            return 1;
        }else {
            //if points are equal then we must look maximum difference with the firstPlaces that driver got
            int firstPlacesTeam1 = o1.getFirstPosition();
            int firstPlacesTeam2 = o2.getFirstPosition();
            return Integer.compare(firstPlacesTeam2, firstPlacesTeam1);
        }
    }

    /**
     * Referred sites:
     * @https://www.geeksforgeeks.org/how-compare-method-works-in-java/
     * */
}
