package ek.geo;

public class Obliquity
{
    // Numerical General Theory (J. Laskar)
    private static double NGT[] = { 
            -4680.93,
            -1.55,
            1999.25,
            -51.38,
            -249.67,
            -39.05,
            7.12,
            27.87,
            5.79,
            2.45
        };
    
    
    /**
     * Calculate obliquity based on J. Laskar formula.
     * @param time Multiples of 10,000 Julian years from J2000.0
     * @return obliquity in degrees
     */
    public static double laskar(double time)
    {
        double t[] = new double[10];
        t[0] = time;
        
        for(int i = 1; i < 10; i++)
        {
            t[i] = t[i-1] * time;
        }
        
        // Obliquity at J2000.0 in arcseconds (23d 26' 21.448") 
        double val = 84381.448;
        
        for(int i = 0; i < 10; i++)
        {
            val+= NGT[i] * t[i];
        }
        
        // Convert to degrees
        return val / 3600.0;
    }


    public static double bc(double time)
    {
        double t1 = time;
        double t2 = t1*t1;
        double t3 = t2*t1;
        
        double val = 84381.448 + t1 * -4680.93 + t2 * -1.5 + t3 * 2001.0;
        return val / 3600.0;
    }
}
