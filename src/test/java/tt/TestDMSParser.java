package tt;

import ek.geo.Location;
import ek.geo.LocationUtils;

public class TestDMSParser
{

    public static void main(String[] args)
    {
        /*
        String strLat = "50 27 10.60 N";
        String strLon = "30 30 51.82 E";
        
        Location loc = new Location();
        loc.setLatitudeDMS(strLat);
        loc.setLongitudeDMS(strLon);
        
        System.out.println(loc.getLatitude());
        System.out.println(loc.getLongitude());
        */
        
        testDistance();
        
    }

    
    private static void testDistance()
    {
        Location loc1 = new Location();
        loc1.setLatitudeDMS("50 03 59N");
        loc1.setLongitudeDMS("5 42 53W");

        Location loc2 = new Location();
        loc2.setLatitudeDMS("58 38 38N");
        loc2.setLongitudeDMS("3 04 12W");
        
        double dist = LocationUtils.distanceMi(loc1, loc2);
        
        System.out.println(dist);
    }
}
