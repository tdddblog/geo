package ek.geo;

/**
 * Based on http://www.movable-type.co.uk/scripts/latlong.html 
 */
public class LocationUtils
{
    public static double angularDistanceRad(Location l1, Location l2)
    {
        double lat1 = Math.toRadians(l1.getLatitude());
        double lat2 = Math.toRadians(l2.getLatitude());
        double dLat = lat2 - lat1;

        double lon1 = Math.toRadians(l1.getLongitude());
        double lon2 = Math.toRadians(l2.getLongitude());
        double dLon = lon2 - lon1;
        
        // Haversine formula
        double a = Math.sin(dLat/2.0) * Math.sin(dLat/2.0) +
                Math.cos(lat1) * Math.cos(lat2) *
                Math.sin(dLon/2.0) * Math.sin(dLon/2.0);
        
        // Angular distance in radians
        double dist = 2.0 * Math.atan2(Math.sqrt(a), Math.sqrt(1.0-a));

        return dist;
    }


    public static double distanceKm(Location l1, Location l2)
    {
        // Earth radius (km)
        double R = 6_371;
        return R * angularDistanceRad(l1, l2);
    }

    
    public static double distanceMi(Location l1, Location l2)
    {
        // Earth radius (mi)
        double R = 3_958.8;
        return R * angularDistanceRad(l1, l2);
    }

}
