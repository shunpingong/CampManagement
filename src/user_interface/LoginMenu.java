package src.user_interface;

import java.util.Scanner;

import src.login_system.Login;
import src.user_interface.interfaces.IMenu;

public class LoginMenu implements IMenu{
    //Instances
    private int choice;

    // Constructor
    public LoginMenu(){
        this.choice = 0;
    }
    public void printMenu(){
        printMenuTitle();
        printMenuOptions();
        selectOptions();
    }

    @Override
    public void printMenuTitle() {
        System.out.println("======================================================================================");
		System.out.println("|                                   WELCOME TO CAMs!                                 |");
		System.out.println("======================================================================================");
    }

    @Override
    public void printMenuOptions() {
        Scanner sc = new Scanner(System.in);
        System.out.println("--------------------------------------------------------------------------------------");
        System.out.println("|1. Login to the system                                                              |");
        System.out.println("|-1. Quit                                                                            |");
        System.out.println("--------------------------------------------------------------------------------------");
        do{		
			System.out.print("Menu Option: ");
        	choice = sc.nextInt();
        }while(choice > 1 || choice < -1 || choice == 0);
    }

    @Override
    public void selectOptions() {
        switch(choice)
        {
			case 1: //view all camps
                Login.login();
				break;
            case -1:
                // Exit Menu
                System.out.println("Exiting Login Menu. Goodbye!");
                System.exit(0);
		}
    }
    
}
