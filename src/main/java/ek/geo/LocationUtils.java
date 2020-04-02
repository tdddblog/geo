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
        double R = 6_371;   // Earth radius (km)
        return R * angularDistanceRad(l1, l2);
    }

    
    public static double distanceMi(Location l1, Location l2)
    {
        double R = 3_958.8; // Earth radius (mi)
        return R * angularDistanceRad(l1, l2);
    }

    
    public static double initialBearingRad(Location l1, Location l2)
    {
        double lat1 = Math.toRadians(l1.getLatitude());
        double lat2 = Math.toRadians(l2.getLatitude());

        double lon1 = Math.toRadians(l1.getLongitude());
        double lon2 = Math.toRadians(l2.getLongitude());
        
        double y = Math.sin(lon2 - lon1) * Math.cos(lat2);
        double x = Math.cos(lat1) * Math.sin(lat2) - Math.sin(lat1) * Math.cos(lat2) * Math.cos(lon2-lon1);
        double bearing = Math.atan2(y, x);
        
        return bearing;
    }
    
    
    public static double initialBearing(Location l1, Location l2)
    {
        double deg = Math.toDegrees(initialBearingRad(l1, l2));
        return (deg < 0) ? deg + 360 : deg; 
    }

    
    public static Location destinationKm(Location start, double bearing, double distance)
    {
        double R = 6_371;   // Earth radius (km)
        
        // Angular distance
        distance = distance / R;     
        bearing = Math.toRadians(bearing);
        
        double lat1 = Math.toRadians(start.getLatitude());
        double lon1 = Math.toRadians(start.getLongitude());
        
        double lat2 = Math.asin(Math.sin(lat1) * Math.cos(distance) +
                Math.cos(lat1) * Math.sin(distance) * Math.cos(bearing));
        
        double y = Math.sin(bearing) * Math.sin(distance) * Math.cos(lat1);
        double x = Math.cos(distance) - Math.sin(lat1)*Math.sin(lat2);
        double lon2 = lon1 + Math.atan2(y, x);

        Location dest = new Location();
        dest.setLatitude(Math.toDegrees(lat2));
        dest.setLongitude(Math.toDegrees(lon2));
        return dest;
    }
    
    
    public static Location intersection(Location l1, double bearing1, Location l2, double bearing2)
    {
        Location dest = new Location();
        return dest;
    }
}
