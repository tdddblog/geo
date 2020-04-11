package tt;

import ek.geo.Location;
import ek.geo.LocationUtils;

public class TestDistance
{

    public static void main(String[] args)
    {
        testDistance1();
        System.out.println();
        testDistance2();
    }

    
    private static void testDistance1()
    {
        Location loc1 = new Location();
        loc1.setLatitudeDMS("50 03 59N");
        loc1.setLongitudeDMS("5 42 53W");

        Location loc2 = new Location();
        loc2.setLatitudeDMS("58 38 38N");
        loc2.setLongitudeDMS("3 04 12W");
        
        double dist = LocationUtils.distanceKm(loc1, loc2);
        double bearing1 = LocationUtils.initialBearing(loc1, loc2);
        
        System.out.println("Distance = " + dist);
        System.out.println("Initial Bearing = " + bearing1);
    }


    private static void testDistance2()
    {
        Location loc1 = new Location();
        loc1.setLatitudeDMS("60 03 59N");
        loc1.setLongitudeDMS("1 42 53W");

        Location loc2 = new Location();
        loc2.setLatitudeDMS("58 38 38N");
        loc2.setLongitudeDMS("3 04 12W");
        
        double dist = LocationUtils.distanceKm(loc1, loc2);
        double bearing1 = LocationUtils.initialBearing(loc1, loc2);
        
        System.out.println("Distance = " + dist);
        System.out.println("Initial Bearing = " + bearing1);
    }

}
