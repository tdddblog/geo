package tt;

import ek.geo.DMSConverter;
import ek.geo.Obliquity;

public class TestObliquity
{
    public static void main(String[] args)
    {
        //System.out.println(DMSConverter.DMStoSec(23, 26, 21.448));
        
        for(double t = -2; t < 1; t+=0.1)
        {
            double year = t*10000 + 2000;
            System.out.format("%6.0f   %.2f  %.2f\n", year, Obliquity.laskar(t), Obliquity.bc(t));
        }
    }

}
