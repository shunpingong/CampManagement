package src;

import java.time.LocalDate;
import java.util.Scanner;

public class UserInput {
    public UserInput(){};
    
    public static LocalDate getDate(){ //returns date in LocalDate data type
        Scanner sc = new Scanner(System.in);
        int year=0;
        do{
            System.out.printf("Enter Year (YYYY): ");
            year = sc.nextInt();
        } while(year<2023);
        int month = 0;
        do{
            System.out.printf("Enter Month (MM): ");
            month = sc.nextInt();
        } while(month>12 || month<1);
        int day = 0;
        do{
            System.out.printf("Enter Day (DD): ");
            day = sc.nextInt();
        } while(day>31 || day<1);
        return LocalDate.of(year, month, day);
    }

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
}
