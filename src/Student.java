package src;
import java.util.Scanner;

public class Student extends User {
	private String email;
	private String status;

	// Constructors
	public Student(String userID, String name, Faculty faculty, String email){
		super(userID, name, faculty);
		this.email = email;
		this.status = ""; //to store the camp name that student is a committee of??
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
            System.out.println("|-1. Exit Menu                                                                       |");
            System.out.println("--------------------------------------------------------------------------------------");
			System.out.printf("Menu Option: ");
            choice = sc.nextInt();
        }while(choice>9||choice<-1);
        return choice;
	}

	@Override

	public void menuChoice(int i, User currentUser){
	// public void menuChoice(int i){
		Scanner sc = new Scanner(System.in);

		Student studentUser = (Student) currentUser; //downcast to make it perform the methods as a student

		switch(i)
		{
			case 1:
				//If student signed up, don't show the camp again
				CampList.printCampNames();
				break;

			case 2:
				//Register for camps either as a camp attendee or camp committee
				//Only camp committee for one camp only
	
				CampList.viewCamps();
				System.out.print("Choose a camp to sign up for (enter the number): ");
				int chosenCampIndex = sc.nextInt();
				if (CampList.getCampInfo(chosenCampIndex).isStudentWithdrawn(studentUser)) {
					System.out.println("Cannot register. "+ studentUser.getName() + " has already withdrawn from this camp: " + CampList.getCampInfo(chosenCampIndex).getCampName());
				}
				else{
					System.out.println("1. Sign up as member");
					System.out.println("2. Sign up as committee");
					System.out.print("Enter your choice:");
					int choice = sc.nextInt();

					if (choice ==1){
						CampList.getCampInfo(chosenCampIndex).addStudentAttendees(studentUser); //index alr automatically -1 in CampList
					}

					if (choice ==2){
						//if user is already a committee for a camp -> cannot register as committee
						if (studentUser.getStatus() != "") {
							System.out.println("You are already a committee member for the camp: " + (studentUser.getStatus()));
							break;
						}

						// public Student(String userID, String name, Faculty faculty, String email){
						// public CampCommittee(String userID, String name, Faculty faculty, String email, int points)
						else{
							//NOT REALLY SURE OF THE LOGIC HERE FOR CAMP COMMITTEE, I WANT TO MAKE THIS STUDENT INTO CAMP COMMITTEE BUT IDK HOW
							studentUser.setStatus(CampList.getCampInfo(chosenCampIndex).getCampName());
							CampCommittee commUser = new CampCommittee(studentUser.getID(), studentUser.getName(), studentUser.getFaculty(), email, studentUser.getStatus(), 0);
							CampList.getCampInfo(chosenCampIndex).addCampCom(commUser); //index alr automatically -1 in CampList
						}
					}
				}	
					break;

            case 3:
				//Enter enquiry
				System.out.print("Enter enquiry text: ");
				String text = sc.nextLine();

				// Let the student choose which camp to submit an enquiry for
				CampList.viewCamps();
				System.out.print("Choose a camp to submit an enquiry for (enter the number): ");
				chosenCampIndex = sc.nextInt();

				// Get the camp Name
				String chosenCamp = CampList.getCampInfo(chosenCampIndex).getCampName();
				
				// Create an enquiry object and add it to the enquiry list
				Enquiry newEnquiry = new Enquiry(text, studentUser, chosenCamp);
				EnquiryList.addEnquiry(newEnquiry);
                break;

            case 4:
				//For loop to go through all camps and check if current user submitted enquiry and then 
				EnquiryList.displayEnquiriesForCamp("Orientation",studentUser);
                break;

            case 5:
				//add on from case 4
				//ask for text to update
				//chhoose the camp to update enquiry, ensure already made an enquiry to that camp first
				System.out.print("Enter new enquiry text: ");
				text = sc.nextLine();

				CampList.viewCamps();

				System.out.print("Choose a camp to update the enquiry for (enter the number): ");
				chosenCampIndex = sc.nextInt();
				chosenCamp = CampList.getCampInfo(chosenCampIndex).getCampName();

				newEnquiry = new Enquiry(text, studentUser, chosenCamp);
				EnquiryList.updateEnquiry(newEnquiry);
                break;

			case 6:
				//show enquiry submitted first - to add on

				CampList.viewCamps();
				System.out.print("Choose a camp to delete an enquiry for (enter the number): ");
				chosenCampIndex = sc.nextInt();
				chosenCamp = CampList.getCampInfo(chosenCampIndex).getCampName();

				EnquiryList.deleteEnquiry(chosenCamp, studentUser);
				
				break;

			case 7:
				// view registered camp
				break;

			case 8:
				// Withdraw from camp
				//public void removeStudentAttendees(Student student){
				System.out.print("Choose a camp registered to withdraw (enter the number): ");
				chosenCampIndex = sc.nextInt();

				if (studentUser.getStatus().equals(CampList.getCampInfo(chosenCampIndex).getCampName())) {
					System.out.println("Cannot withdraw. Student is a committee for camp: "+ CampList.getCampInfo(chosenCampIndex).getCampName());
				}
				else{
					CampList.getCampInfo(chosenCampIndex).removeStudentAttendees(studentUser);

				}

				//Show his registered camp - from case 7
				//Let him choose which to withdraw
				//Check if he is a committee for the camp if not let him withdraw
				//If withdrawn, cannot register for same camp again
				break;
					
            case 9:
				//Display all enquiries the camp commiittee is in charge of
				//view and reply to enquiries from students to the camp they oversee. 
				//Submit suggestions for changes to camp details to staff
				//view, edit, and delete the details of his/her suggestions before being processed
				//Generate a report of the list of students attending each camp they oversee
                break;

            case -1:
                // Exit Menu
                System.out.println("Exiting Camp Menu. Goodbye!");
                System.exit(0);
                break;
		}

	}
}