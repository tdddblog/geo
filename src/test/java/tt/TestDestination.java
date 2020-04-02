package tt;

import ek.geo.Location;
import ek.geo.LocationUtils;

public class TestDestination
{
    public static void main(String[] args)
    {
        testDest();
    }
    
    public static void testDest()
    {
        Location loc1 = new Location();
        loc1.setLatitudeDMS("50 27 10.60 N");
        loc1.setLongitudeDMS("30 30 51.82 E");
        
        Location loc2 = LocationUtils.destinationKm(loc1, 326.41, 1000);
        
        System.out.println(loc2.getLatitude());
        System.out.println(loc2.getLongitude());
    }
    
}
