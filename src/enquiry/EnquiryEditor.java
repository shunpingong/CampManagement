package src.enquiry;

import java.util.Scanner;

import src.CampInfo;
import src.Student;

import java.util.ArrayList;

public class EnquiryEditor {

    public static void editMenu(Student student, ArrayList<Enquiry> enquiryList ) {
        Scanner sc = new Scanner(System.in);
        while(true) {
            Enquiry selectedEnquiry = null;
            ArrayList<Enquiry> requiredEnquiries = EnquiryOutput.getRequiredEnquiries(student,false);
            EnquiryOutput.viewRequiredEnquiries(requiredEnquiries);
            selectedEnquiry = EnquiryOutput.selectEnquiry(requiredEnquiries);
            if (selectedEnquiry == null) {
                return;
            }
            System.out.println("1. Edit this enquiry, 2. Delete this enquiry, 3. Select a new enquiry or 4. Exit\n");
            int selection = sc.nextInt();
            String newLine = sc.nextLine();
            switch (selection) {
                case 1:
                    EnquiryEditor.editEnquiry(selectedEnquiry);
                    return;
                case 2:
                    EnquiryEditor.deleteEnquiry(student, selectedEnquiry, enquiryList);
                    return;
                case 3:
                    break;
                case 4:
                    System.out.println("Exiting");
                    return;
                default:
                    break;
            }
        }
    }

    public static void AddEnquiry(Student student, CampInfo camp, ArrayList<Enquiry> enquiryList){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter your enquiry: ");
        String response = sc.nextLine();
        Enquiry newEnquiry = new Enquiry(response, student, camp, null);
        enquiryList.add(newEnquiry);
        camp.addEnquiriesForCamp(newEnquiry);
        System.out.printf("Enquiry Submitted for camp: %s\n\n", camp.getCampName());
    }

    public static void editEnquiry(Enquiry e) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter new enquiry description: ");
        String newDescription = sc.nextLine();
        e.setDescription(newDescription + "\n**This enquiry has been edited**");
        System.out.println("Your enquiry has been edited\n");
    }

    public static void deleteEnquiry(Student student, Enquiry e, ArrayList<Enquiry> enquiryList) {
        e.getCamp().getEnquiriesForCamp().remove(e);
        enquiryList.remove(e);
        System.out.println("Your enquiry has been deleted\n");
    }
}