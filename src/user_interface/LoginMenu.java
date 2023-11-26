package src.user_interface;

import java.util.ArrayList;
import java.util.Scanner;

import src.login_system.Login;
import src.user_data.ExcelManager;
import src.user_data.Student;
import src.user_data.StudentData;
import src.user_interface.interfaces.IMenu;

/**
 * The {@code LoginMenu} class implements the {@link IMenu} interface
 * It provides options for users to login to the system or quit.
 *
 * @author Kenneth
 * @version 1.0
 * @since 2023-11-26
 */
public class LoginMenu implements IMenu{

    /**
     * The menu choice selected by the user.
     */
    private int choice;

    /**
     * Constructs a new {@code LoginMenu} object.
     */
    public LoginMenu(){
        this.choice = 0;
    }

    /**
     * Prints the menu options for user login.
     */
    public void printMenu(){
        printMenuTitle();
        printMenuOptions();
        selectOptions();
    }

    /**
     * Prints the title of the menu.
     */
    @Override
    public void printMenuTitle() {
        System.out.println("======================================================================================");
		System.out.println("|                                   WELCOME TO CAMs!                                 |");
		System.out.println("======================================================================================");
    }

    /**
     * Selects and executes the chosen menu option.
     */
    @Override
    public void printMenuOptions() {
        Scanner sc = new Scanner(System.in);
        System.out.println("--------------------------------------------------------------------------------------");
        System.out.println("|1. Login to the system                                                              |");
        System.out.println("|2. Quit                                                                             |");
        System.out.println("--------------------------------------------------------------------------------------");
        do{		
			System.out.print("Menu Option: ");
        	choice = sc.nextInt();
        }while(!(choice == 1 || choice == 2));
    }

    @Override
    public void selectOptions() {
        switch(choice)
        {
			case 1: //view all camps
                Login.login();
				break;
            case 2:
                // Exit Menu
                System.out.println("Exiting Login Menu. Goodbye!");
                System.exit(0);
		}
    }
    
}
