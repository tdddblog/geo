package tt;

import ek.geo.Location;

public class TestDMSParser
{

    public static void main(String[] args)
    {
        String strLat = "50 27 10.60 N";
        String strLon = "30 30 51.82 E";
        
        Location loc = new Location();
        loc.setLatitudeDMS(strLat);
        loc.setLongitudeDMS(strLon);
        
        System.out.println(loc.getLatitude());
        System.out.println(loc.getLongitude());
    }

}
