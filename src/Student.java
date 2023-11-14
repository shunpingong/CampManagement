
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
            System.out.println("|3. Submit Camp Enquiries                                                            |");
            System.out.println("|4. View Submitted Enquiries                                                         |");
            System.out.println("|5. Edit Submitted Enquiries                                                         |");
            System.out.println("|6. Delete Submitted Enquiries                                                       |");
            System.out.println("|7. View Registered Camps                                                            |");
            System.out.println("|8. Withdraw From Camp                                                               |");
            System.out.println("|9. View Camp Committee Menu                                                         |");
            System.out.println("|10. Exit Menu                                                                       |");
            System.out.println("--------------------------------------------------------------------------------------");
			System.out.printf("Menu Option: ");
            choice = sc.nextInt();
        }while(choice>10||choice<1);
        return choice;
	}

	@Override

	// public void menuChoice(int i, User currentUser)
	public void menuChoice(int i){
		Scanner sc = new Scanner(System.in);
		switch(i)
		{
			case 1:
				CampList.printCampNames();
				break;

			case 2:
				//Register for camps either as a camp attendee or camp committee
				//Only camp committee for one camp
                break;

            case 3:
				System.out.print("Enter enquiry text: ");
				String text = sc.nextLine();

				// CampList.printCampNames();
				// Let the student choose which camp to submit an enquiry for
				System.out.print("Choose a camp to submit an enquiry for (enter the number): ");
				int chosenCampIndex = sc.nextInt();
				String chosenCamp = "hello"; //find a way to obtain the camp from CampList
				
				// Create an enquiry object and add it to the enquiry list
				Enquiry newEnquiry = new Enquiry(text, currentUser, chosenCamp);
				EnquiryList.addEnquiry(newEnquiry);

				System.out.println("Enquiry for camp " + chosenCamp + " submitted.");
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

            case 10:
                // Exit Menu
                System.out.println("Exiting Camp Menu. Goodbye!");
                System.exit(0);
                break;
		}

	}
}