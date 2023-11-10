package src;

import java.util.Scanner;

public class PrintAllCamp {
    public PrintAllCamp(){};

    public static void printAll(){
        System.out.println("------------------------------------------------------------------------------------");
        System.out.println("|                                    Camp List                                     |");
        System.out.println("------------------------------------------------------------------------------------");
        int i;
        for(i=0;i<CampList.getSize();i++){
            CampInfo camp = CampList.getCampInfo(i);
            System.out.printf("|%-3s|Name: %-13s|Date: %-5s to %-15s|Available Slots: %-5s|\n", 
                                i+1,
                                camp.getCampName(), 
                                camp.getStartDate(), 
                                camp.getEndDate(), 
                                camp.getTotalSlots());
        }
        
        
        Scanner sc = new Scanner(System.in);
        int choice = 0;
        do{
            System.out.println("Options:");
            System.out.println("1. View Camp Details");
            System.out.println("2. Return");
            choice = sc.nextInt();
        }while(choice<1 || choice>2);
        if (choice == 1) {
            System.out.printf("Which Camp To View: ");
            do{
                break;
            }while(choice>i);
        }
    }
}

