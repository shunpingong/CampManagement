package src.camp_management;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

import src.user_data.Faculty;

/**
 * The {@code UserInput} class provides methods for handling user input related to camp management.
 * 
 * @version 1.0
 * @since 2023-11-26
 * @author Yi heng
 */
public class UserInput {

    /**
     * Default constructor for the UserInput class.
     */
    public UserInput(){};
    
    /**
     * Prompts the user to enter a valid date in the format DD/MM/YYYY.
     *
     * @return The entered date as a LocalDate object.
     */
    public static LocalDate getDate(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        Scanner sc = new Scanner(System.in);
        String inputDate;
        do{
            System.out.printf("Enter Date (DD/MM/YYYY): ");
            inputDate = sc.nextLine();
        } while(!isValidDate(inputDate, formatter));

        return LocalDate.parse(inputDate, formatter);
    }

    /**
     * Prompts the user to set the visibility status and returns the choice.
     *
     * @return True if the user chooses to set visibility to true, false otherwise.
     */
    public static boolean setVisibility(){
        Scanner sc = new Scanner(System.in);
        System.out.println("1. Set To Visible");
        System.out.println("2. Set To Invisible");
        int choice = 0;
        
        do{
            System.out.printf("Enter Choice: ");
            choice = sc.nextInt();
        }while (choice < 1 || choice > 2);
        System.out.println(choice);
        if (choice == 1) {
            return true;
        }
        return false;
    }

    /**
     * Prompts the user to choose a faculty from the available options.
     *
     * @return The selected Faculty.
     */
    public static Faculty chooseFaculty(){
        int i=1;
        Scanner sc = new Scanner(System.in);
        for (Faculty fac : Faculty.values()) { 
            System.out.format("%d. "+fac , i);
            System.out.println(); 
            i++;
        }
        int choice = 0;
        do{
            System.out.printf("Enter Choice: ");
            choice = sc.nextInt();
        }while(choice>15 || choice <1);
        return Faculty.values()[choice-1];
    }

    /**
     * Prompts the user to choose a sorting option for camps.
     *
     * @return The user's choice for camp sorting.
     */
    public static int sortCampMenu(){
        Scanner sc = new Scanner(System.in);
        int choice=0;
        do{
            System.out.println("How Do You Want The Camps To Be Sorted?");
            System.out.println("1. Name (Ascending)");
            System.out.println("2. Name (Descending)");
            System.out.println("3. Start Date");
            System.out.println("4. End Date");
            System.out.println("5. Registration Deadline");
            choice = sc.nextInt();
        }while(choice<1 || choice>5);
        return choice;
    }

    /**
     * Prompts the user to choose an attribute to edit for a camp.
     *
     * @return The user's choice for editing a camp attribute.
     */
    public static int editCampMenu(){
        Scanner sc = new Scanner(System.in);
        int choice=0;
        do{//Faculty userGroup,int totalSlots, int committeeSlots, Staff inCharge
            System.out.println("Which Attribute To Edit?");
            System.out.println("1. Camp Name");
            System.out.println("2. Camp Location");
            System.out.println("3. Camp Description");
            System.out.println("4. Start Date");
            System.out.println("5. End Date");
            System.out.println("6. Registration Deadline");
            System.out.println("7. Faculty Group");
            System.out.println("8. Total Slots");
            System.out.println("9. Committee Slots");
            choice = sc.nextInt();
        }while(choice<1 || choice>9);
        return choice;
    }

    /**
     * Prompts the user to select a camp for editing.
     *
     * @return The user's choice of the camp to edit.
     */
    public static int selectCamp(){
        Scanner sc = new Scanner(System.in);
        int choice=0;
        CampList.viewCamps();
        int length = CampList.getSize();
        do{
            System.out.println("Which Camp To Edit?");
            choice = sc.nextInt();
        }while(choice<1 || choice>length);
        return choice;
    }

    /**
     * Checks if the provided date string is a valid date according to the specified formatter.
     *
     * @param date      The date string to validate.
     * @param formatter The DateTimeFormatter to use for parsing.
     * @return True if the date is valid, false otherwise.
     */
    private static boolean isValidDate(String date, DateTimeFormatter formatter){
        try{
            LocalDate.parse(date, formatter);
        }catch(DateTimeParseException e){
            System.out.println("Error: Invalid Date. Please put a valid date");
            return false;
        }
        return true;
    }
}
