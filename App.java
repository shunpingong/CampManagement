// Imports
import java.util.ArrayList;
import java.util.Scanner;

// Class
public class App {
    // Main
    public static void main(String[] args){
        // Hardcoded Data (Change later to get from Excel File)
        // Students
        Student[] students = new Student[11];
        students[0] = new Student("YCHERN", "CHERN", Faculty.SCSE, "YCHERN@e.ntu.edu.sg");
        students[1] = new Student("KOH1", "KOH", Faculty.ADM, "KOH1@e.ntu.edu.sg");
        students[2] = new Student("BR015", "BRANDON", Faculty.EEE, "BR015@e.ntu.edu.sg");
        students[3] = new Student("CT113", "CALVIN", Faculty.SCSE, "CT113@e.ntu.edu.sg");
        students[4] = new Student("TCN019", "CHAN", Faculty.NBS, "TCN019@e.ntu.edu.sg");
        students[5] = new Student("DL007", "DENISE", Faculty.SCSE, "DL007@e.ntu.edu.sg");
        students[6] = new Student("DON84", "DONG", Faculty.ADM, "DON84@e.ntu.edu.sg");
        students[7] = new Student("ELI34", "ERNEST", Faculty.EEE, "ELI34@e.ntu.edu.sg");
        students[8] = new Student("LE51", "LEE", Faculty.SCSE, "LE51@e.ntu.edu.sg");
        students[9] = new Student("SL22", "LIU", Faculty.NBS, "SL22@e.ntu.edu.sg");
        students[10] = new Student("AKY013", "RAWAL", Faculty.SSS, "AKY013@e.ntu.edu.sg");

        // Staff Members
        Staff[] staff = new Staff[5];
        staff[0] = new Staff("HUKUMAR", "Madhukumar", Faculty.SCSE, "HUKUMAR@ntu.edu.sg");
        staff[1] = new Staff("OURIN", "Alexei", Faculty.ADM, "OURIN@ntu.edu.sg");
        staff[2] = new Staff("UPAM", "Chattopadhyay", Faculty.EEE, "UPAM@ntu.edu.sg");
        staff[3] = new Staff("ANWIT", "Datta", Faculty.SCSE, "ANWIT@ntu.edu.sg");
        staff[4] = new Staff("ARVI", "Arvind", Faculty.NBS, "ARVI@ntu.edu.sg");

        // Call to the Login page
    }
}
