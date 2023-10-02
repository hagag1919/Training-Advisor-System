package CourseAdd_on;
import java.util.Vector;

public class Materials 
{
    public static Vector<String> materialsVector = new Vector<String>();
    //setters
    public void setMaterialsVector(String material)
    {
        materialsVector.add(material);
    }
    //getters
    public static Vector<String> getMaterialsVector()
    {
        return materialsVector;
    }
    
}
