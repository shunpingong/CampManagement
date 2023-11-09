package src;

import java.time.LocalDate;
import java.util.Scanner;

public class GetDate { 
    public GetDate(){};

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
}
