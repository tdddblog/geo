package ek.geo;

public class DMSConverter
{
    public static double DMStoDecimal(int deg, int min, double sec)
    {
        return deg + min / 60.0 + sec / 3600.0;
    }

    public static double DMStoSec(int deg, int min, double sec)
    {
        return deg * 3600.0 + min * 60.0 + sec;
    }

}
