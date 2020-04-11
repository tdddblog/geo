package ek.geo;

public class Location
{
    private double latitude;
    private double longitude;
    
    
    public Location()
    {
    }

    
    public double getLatitude()
    {
        return latitude;
    }

    
    public double getLongitude()
    {
        return longitude;
    }

    
    public void setLatitude(double val)
    {
        this.latitude = val;
    }

    
    public void setLongitude(double val)
    {
        this.longitude = val;
    }

    
    /**
     * Parses degrees, minutes, seconds, compass direction value.
     * @param str
     */
    public void setLatitudeDMS(String str)
    {
        if(str == null || str.isEmpty()) 
        {
            throw new IllegalArgumentException("No value");
        }
        
        str = str.trim();
        
        char direction = Character.toUpperCase(str.charAt(str.length()-1));
        if(direction != 'N' && direction != 'S') 
        {
            throw new IllegalArgumentException("Missing compass direction 'N' or 'S'");
        }
        
        String[] tokens = str.split("[^0-9.]+");
        if(tokens.length == 3)
        {
            this.latitude = fromDMS(tokens[0], tokens[1], tokens[2], direction == 'S');
        }
        else if(tokens.length == 2)
        {
            this.latitude = fromDMS(tokens[0], tokens[1], null, direction == 'S');
        }
        else
        {
            throw new IllegalArgumentException("Could not parse latitude " + str);
        }
    }


    /**
     * Parses degrees, minutes, seconds, compass direction value.
     * @param str
     */
    public void setLongitudeDMS(String str)
    {
        if(str == null || str.isEmpty()) 
        {
            throw new IllegalArgumentException("No value");
        }
        
        str = str.trim();
        
        char direction = Character.toUpperCase(str.charAt(str.length()-1));
        if(direction != 'E' && direction != 'W') 
        {
            throw new IllegalArgumentException("Missing compass direction 'E' or 'W'");
        }
        
        String[] tokens = str.split("[^0-9.]+");
        if(tokens.length == 3)
        {
            this.longitude = fromDMS(tokens[0], tokens[1], tokens[2], direction == 'W');
        }
        else if(tokens.length == 2)
        {
            this.longitude = fromDMS(tokens[0], tokens[1], null, direction == 'W');
        }
        else
        {
            throw new IllegalArgumentException("Could not parse longitude " + str);
        }
    }

    
    private double fromDMS(String strDeg, String strMin, String strSec, boolean minus)
    {
        double deg = Double.parseDouble(strDeg);
        double min = Double.parseDouble(strMin);
        double sec = (strSec == null) ? 0 : Double.parseDouble(strSec);
        
        double value = deg + min / 60.0 + sec / 3600.0;
        return minus ? -value : value;
    }
}
