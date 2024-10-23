import java.util.ArrayList;
import java.util.Date;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
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

    public boolean addPrescription(Scanner userInput) throws IOException
    {
        //TODO Add the prescription's information to a TXT file
        //If the prescription meets the given conditions,
        , // the information should be added to a TXT file (e.g., presc.txt), and the funtion should return true
        //If the prescription's Information does not meet the given conditions,
          // the information should not be added to the TXT file, and the function should return false
          System.out.println("Enter first Name (4-15 Characters): ");
          firstName = userInput.nextLine();
          if (!validateName(firstName)) {
            System.out.println("Invalid First Name. Please enter between 4 and 15 characters.");
            return false;
          }
          System.out.println("Enter Last Name (4-15 characters): ");
          lastName = userInput.nextLine();
          if (!validateName(lastName)) {
            System.out.println("Invalid Last Name. Please enter between 4 and 15 characters.");
            return false;
          }
          System.out.println("Enter Address (minimum 20 characters): ");
          address = userInput.nextLine();
          if (address.length() < 20) {
            System.out.println("Invalid Address. Address should be at least 20 characters.");
            return false;
          }
          System.out.println("Enter Sphere (-20.00 to +20.00): ");
          sphere = userInput.nextFloat();
          userInput.nextLine(); // Consume newline character
          if (sphere < -20.00 || sphere > 20.00) {
            System.out.println("Invalid Sphere value. Please enter between -20.00 and +20.00");
            return false;
          }
          System.out.println("Enter Cylinder (-4.00 to +4.00): ");
          cylinder = userInput.nextFloat();
          userInput.nextLine(); // Consume newline character
          if (cylinder < -4.00 || cylinder > 4.00) {
            System.out.println("Invalid Cylinder value. Please enter between -4.00 and +4.00");
            return false;
          }
          System.out.println("Enter Axis (0 to 180): ");
          axis = userInput.nextFloat();
          userInput.nextLine(); // Consume newline character
          if (axis < 0 || axis > 180) {
            System.out.println("Invalid Axis value. Please enter between 0 and 180");
            return false;
          }
          System.out.println("Enter Examination Date (DD/MM/YY): ");
          String examDateStr = userInput.nextLine();

          System.out.println("Enter Optometrist Name (8-25 characters): ");
          optometrist = userInput.nextLine();
          if (!validateName(optometrist)) {
            System.out.println("Invalid Optometrist Name. Please enter between 8 and 25 characters.");
            return false;
          }
          return writePrescriptionToFile();
    }
    private boolean validateName(String name) {
        return name.length() >= 4 && name.length() <= 15;
    }
    private boolean writePrescriptionToFile() throws IOException {
        try (FileWriter writer = new FileWriter("presc.txt", true)) {
            writer.write(String.format("%d\n", prescID++));
        }
    }

    
    public boolean addRemark(Scanner userInput) throws IOException
    {
        //TODO Add the prescription's remark to a TXT file
        //IF the remark meets the given Conditions,
        //the information should be added to a txt File(e.g., remark.txt), and the function should return true
        //If the remark does not meetthe given conditions,
        //the information should not be added to the TXT file,and the function should retuen false

        if (postRemarks.size() >= 2) {
        System.out.println("Remark limit reached. Cannot add more remarks.");
        return false;
        }

        System.out.println("Enter remark (6-20 words, starting with uppercase): ");
        String remark = userInput.nextLine();

        String[] remarkWords = remark.split("\\s+");
        if (remarkWords.length < 6 || remarkWords.length > 20 || !Character.isUpperCase(remarkWords[0].charAt(0))) {
        System.out.println("Invalid remark. Please enter between 6 and 20 words, starting with an uppercase letter.");
        return false;
        }
        System.out.println("Choose remark type (Client or Optometrist): ");
        String remarkType = userInput.nextLine();
        if (!isValidRemarkType(remarkType)) {
        System.out.println("Invalid remark type. Please enter 'Client' or 'Optometrist'.");
        return false;
        }
        
        // Add remark to list
        postRemarks.add(remarkType + ": " + remark);

        // Write remark to file
        return writeRemarkToFile();
    }
    private boolean isValidRemarkType(String remarkType) {
    for (String type : remarkTypes) {
        if (type.equalsIgnoreCase(remarkType)) {
            return true;
        }
    }
    return false;
    }

    private boolean writeRemarkToFile() throws IOException {
    try (FileWriter writer = new FileWriter("remark.txt", true)) {
        for (String remark : postRemarks) {
            writer.write(remark + "\n");
        }
        return true;
    } 
    catch (IOException e) {
        e.printStackTrace();
        return false;
    }
    }
    
}
