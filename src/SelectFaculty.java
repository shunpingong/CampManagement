package src;

import java.util.Scanner;

public class SelectFaculty {
    public SelectFaculty(){};

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
