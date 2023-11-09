package src;

import java.util.Scanner;

public class SetVisibility {
    public SetVisibility(){};

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
}
