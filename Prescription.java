import java.util.ArrayList;
import java.util.Date;
public class Prescription{
    private int prescID;
    private String firstName;
    private String lastName;
    private String address;
    private float sphere;
    private float axis;
    private float cylinder;
    private Date examinationDate;
    private String optometrist;
    private String[] remarktypes= {"Client","Optometrist"};
    private ArrayList <String> postRemarks= new ArrayList<>();

    public boolean addPrescription()
    {
        //TODO Add the prescription's information to a TXT file
        //If the prescription meets the given conditions,
        , // the information should be added to a TXT file (e.g., presc.txt), and the funtion should return true
        //If the prescription's Information does not meet the given conditions,
          // the information should not be added to the TXT file, and the function should return false
          return True;
    }
    public boolean addRemark()
    {
        //TODO Add the prescription's remark to a TXT file
        //IF the remark meets the given Conditions,
        //the information should be added to a txt File(e.g., remark.txt), and the function should return true
        //If the remark does not meetthe given conditions,
        //the information should not be added to the TXT file,and the function should retuen false
        return true;
    }
}
