package src.user_interface;

import java.util.ArrayList;
import java.util.Scanner;

import src.login_system.Login;
import src.user_data.ExcelManager;
import src.user_data.Student;
import src.user_data.StudentData;
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
                resetRole();
                System.out.println("Exiting Login Menu. Goodbye!");
                System.exit(0);
		}
    }

    private void resetRole(){
        ExcelManager xl = new ExcelManager("data\\student_list.xlsx");
        for(int i=0;i<StudentData.getCount();i++){
            Student user = StudentData.getUser(i);
            if(user.getRole().equalsIgnoreCase("Student"))
                continue;
            ArrayList<String> updateData = new ArrayList<>();
            updateData.add(user.getName());
            updateData.add(user.getEmail());
            updateData.add(user.getFaculty().toString());
            updateData.add(user.getPWD());
            updateData.add("Student");
            updateData.add("N/A");
            xl.updateXL(updateData);
        }
    }
    
}
