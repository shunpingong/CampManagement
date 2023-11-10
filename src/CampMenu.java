package src;
import java.util.ArrayList;
import java.util.Scanner;

public class CampMenu {
    
    public CampMenu(){};
    
    public static void staffMenu(){
        int choice;
        Scanner sc = new Scanner(System.in);
        do{
            System.out.println("--------------------------------------------------------------------------------------");
            System.out.println("|                                    Camp Menu (Staff)                               |");
            System.out.println("--------------------------------------------------------------------------------------");
            System.out.println("|1. View All Camps                                                                   |");
            System.out.println("|2. View Camps Created By You                                                        |");
            System.out.println("|3. Create New Camp                                                                  |");
            System.out.println("|4. Edit Camp Detail                                                                 |");
            System.out.println("|5. Delete Camp                                                                      |");
            System.out.println("|6. Toggle Visibility Of Camp                                                        |");
            System.out.println("|7. View Enquiries                                                                   |");
            System.out.println("|8. Reply Enquiries                                                                  |");
            System.out.println("|9. View Suggestions                                                                 |");
            System.out.println("|10. Reply Suggestions                                                               |");
            System.out.println("|11. Generate Report Of Created Camp                                                 |");
            System.out.println("|12. Generate Performance Report Of Camp Committee                                   |");
            System.out.println("|13. Exit Menu                                                                       |");
            System.out.println("--------------------------------------------------------------------------------------");
            System.out.printf("Menu Option: ");
            
            choice = sc.nextInt();
            switch(choice){
                case 1:
                    
                    break;
                case 2:
                    break;
                case 3:
                    CreateNewCamp.create();
                    break;
            }
        }while(choice<13);

    }
    
    public static void studentMenu(){
        int choice;
        Scanner sc = new Scanner(System.in);
        do{
            System.out.println("--------------------------------------------------------------------------------------");
            System.out.println("|                                    Camp Menu (Student)                             |");
            System.out.println("--------------------------------------------------------------------------------------");
            System.out.println("|1. View All Available Camps                                                         |");
            System.out.println("|2. Register For Camp                                                                |");
            System.out.println("|3. Camp Enquiries                                                                   |");
            System.out.println("|4. View Registered Camps                                                            |");
            System.out.println("|5. Withdraw From Camp                                                               |");
            System.out.println("|6. View Camp Committee Menu                                                         |");
            System.out.println("|7. Exit Menu                                                                        |");
            System.out.println("--------------------------------------------------------------------------------------");
            
            choice = sc.nextInt();
            switch(choice){
                case 1:
                    break;
            }
        }while(choice<8);
    }
    
}
