package src;

import java.util.Scanner;

public class Student extends User {
	// Instances
	private String email;
	private String status;

	// Constructors
	public Student(String userID, String name, Faculty faculty, String email){
		super(userID, name, faculty);
		this.email = email;
		this.status = "";
	}

	// Accessors
	public String getEmail(){
		return this.email;
	}
	public String getStatus(){
		return this.status;
	}

	// Mutators
	public void setEmail(String email){
		this.email = email;
	}
	public void setStatus(String status){
		this.status = status;
	}

	@Override
    public int menu() {
		Scanner sc = new Scanner(System.in);
        int choice = 0;
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
			System.out.printf("Menu Option: ");
            choice = sc.nextInt();
        }while(choice>7||choice<1);
        return choice;
	}

	@Override
	public void menuChoice(int i){
		switch(i)
		{
			case 1:
				break;
/*
			case 2:
				//Register for camps either as a camp attendee or camp committee
				//Only camp committee for one camp
                break;

            case 3:
				//Camp Enquiries
				//Submit enquiries
				//view, edit, and delete their enquiry before processed
				//Display List of camps the student signed up for
				//Let them choose which to submit an enquiry for
				//public Enquiry(String text,User sender,CampInfo camp){
				//Get string of enquiry, sender just pass in current user
				//From list of camps displayed, student will choose which to submit enquiry for
                break;

            case 4:
                break;

            case 5:
                break;

            case 6:
				//Display all enquiries the camp commiittee is in charge of
				//view and reply to enquiries from students to the camp they oversee. 
				//Submit suggestions for changes to camp details to staff
				//view, edit, and delete the details of his/her suggestions before being processed
				//Generate a report of the list of students attending each camp they oversee
                break;
*/
		}

	}
}