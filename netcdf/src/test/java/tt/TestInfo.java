package tt;

import ucar.ma2.Array;
import ucar.nc2.Attribute;
import ucar.nc2.Group;
import ucar.nc2.NetcdfFile;
import ucar.nc2.NetcdfFiles;
import ucar.nc2.Variable;


public class TestInfo
{
    public static void main(String[] args) throws Exception
    {
        //printInfo();
        getData();
    }
    
    public static void getData() throws Exception
    {
        String filename = "/tmp/gmt/tmp_01m.grd";
        NetcdfFile ncFile = NetcdfFiles.open(filename);
        
        Variable lat = ncFile.getRootGroup().findVariable("lat");
        Variable z = ncFile.getRootGroup().findVariable("z");
        
        Array arr = z.read("1200,0:200");
        
        System.out.format("%.3f, %.3f, %.3f \n", arr.getDouble(100), arr.getDouble(120), arr.getDouble(150));
        
        ncFile.close();
    }
    
    
    public static void printInfo() throws Exception
    {
        String filename = "/tmp/gmt/tmp_01m.grd";
        
        //String filename = "/tmp/gmt/earth_relief_10m.grd"; 
        
        NetcdfFile ncFile = NetcdfFiles.open(filename);
        System.out.println(ncFile.getFileTypeDescription());
        System.out.println(ncFile.getFileTypeId());
        
        
        Group root = ncFile.getRootGroup();

        System.out.println("\nAttributes:");
        for(Attribute attr: root.attributes())
        {
            System.out.println(attr);
        }

        System.out.println("\nVariables:");
        for(Variable var: root.getVariables())
        {
            System.out.println(var);
        }

        
        ncFile.close();
    }

}
