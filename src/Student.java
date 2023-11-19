package src;
import java.util.ArrayList;
import java.util.Scanner;

public class Student extends User {
	private String email;
	// private CampInfo committeeOf; //to store the camp that student is a committee of
	private ArrayList<CampInfo> registeredCamps = new ArrayList<CampInfo>(); //List of Camps Student Registered for
	private ArrayList<CampInfo> withdrawnCamps = new ArrayList<CampInfo>(); //List of Camps Student Withdrawn from
    private EnquiryList enquiriesMade = new EnquiryList(); //List of Enquiries Student made
	private CampCommittee committeeUser; //null if current student is not committee

	// Constructors
	public Student(String userID, String name, Faculty faculty, String email){
		super(userID, name, faculty);
		this.email = email;
		// this.committeeOf = null;
	}

/*--------------------------------------------------------------- ACCESSORS -------------------------------------------------------------------------*/
	public String getEmail(){
		return this.email;
	}
	// public CampInfo getCommitteeOf(){
	// 	return this.committeeOf;
	// }

	public CampCommittee getCommitteeUser(){
		return this.committeeUser;
	}

    public void viewRegisteredCamps() {
        System.out.println("Registered Camps");
        System.out.println("--------------------");
        int i = 1;
        for (CampInfo camp : registeredCamps) {
            System.out.printf("%d. %s\n",i,camp.getCampName());
            i++;
        }
		if (i==1){
			System.out.println("No camps registered yet.");
		}
    }

	public void viewWithdrawnCamps() {
        System.out.println("Withdrawn Camps");
        System.out.println("--------------------");
        int i = 1;
        for (CampInfo camp : registeredCamps) {
            System.out.printf("%d. %s\n",i,camp.getCampName());
            i++;
        }
		if (i==1){
			System.out.println("No camps withdrawn yet.");
		}
    }

	//Enquiries made by student: Bala
	public void viewEnquiriesMade() {
		enquiriesMade.displayEnquiriesByUser();
    }


/*---------------------------------------------------------------MUTATORS -------------------------------------------------------------------------*/
	public void setEmail(String email){
		this.email = email;
	}

	// public void setCommitteeOf(CampInfo camp){
	// 	this.committeeOf = camp; //CommitteeOf this camp

	// }

	public void addRegisteredCamp(CampInfo camp) {
        this.registeredCamps.add(camp);
    }

    public void addWithdrawnCamp(int index) {
        if (index >= 0 && index < registeredCamps.size()) {
            this.registeredCamps.remove(index);
        }
        else {
            throw new IndexOutOfBoundsException("Index is out of bounds");
        }
    }

    public void addWithdrawnCamp(CampInfo camp) {
            this.registeredCamps.remove(camp);
			this.withdrawnCamps.add(camp);

    }

/*---------------------------------------------------------------ADDITIONAL METHODS -------------------------------------------------------------------------*/
	@Override
	public User getIfCommittee() {
		return committeeUser == null ? this : committeeUser;
	}

	@Override
    public int menu() {
		Scanner sc = new Scanner(System.in);
        int choice = 0;
        do{
			showStudentMenu();
			System.out.println("--------------------------------------------------------------------------------------");
			System.out.print("Menu Option: ");
        	choice = sc.nextInt();
        }while(choice>9||choice<-1);
        return choice;
	}

	protected void showStudentMenu() {
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
	}

	@Override
	public void menuChoice(int i){
		Scanner sc = new Scanner(System.in);

		switch(i)
		{

			case 1:
				//If student signed up, don't show the camp again -> need to implement
				int availCamps = CampList.viewAllAvailableCamps(this);
				break;

			case 2:
				//Register for camps either as a camp attendee or camp committee
				//Only camp committee for one camp only
				//registerCamp(currentUser) -> a registerCamp class?
				// CampList.viewCamps();
				availCamps = CampList.viewAllAvailableCamps(this);
				if (availCamps !=0){
					System.out.print("Choose a camp to sign up for (enter the number): ");
					int chosenCampIndex = sc.nextInt();
					if (withdrawnCamps.contains(CampList.getCampInfo(chosenCampIndex-1))) {
						System.out.println("Cannot register. "+ this.getName() + " has already withdrawn from this camp: " + CampList.getCampInfo(chosenCampIndex-1).getCampName());
					}
					else{
						System.out.println("1. Sign up as member");
						System.out.println("2. Sign up as committee");
						System.out.print("Enter your choice:");
						int choice = sc.nextInt();

						if (choice ==1){
							CampList.getCampInfo(chosenCampIndex-1).addStudentAttendees(this);
							this.addRegisteredCamp(CampList.getCampInfo(chosenCampIndex-1));
						}

						if (choice == 2){
							//if user is already a committee for a camp -> cannot register as committee
							if (this.committeeUser != null) {
								System.out.println("You are already a committee member for the camp: " + (committeeUser.getCommitteeOf().getCampName()));
								break;
							}
							else{
								this.committeeUser = new CampCommittee(this.getID(), this.getName(), this.getFaculty(), this.getEmail(), CampList.getCampInfo(chosenCampIndex-1), 0);
								CampList.getCampInfo(chosenCampIndex-1).addCampCom(committeeUser); 
							}
						}
					}	
				}

					break;

            case 3:
				// Let the student choose which camp to submit an enquiry for
				availCamps = CampList.viewAllAvailableCamps(this);
				if (availCamps !=0){
					System.out.print("Choose a camp to submit enquiry for (enter the number): ");
					int chosenCampIndex = sc.nextInt();

					// Consume the newline character
					sc.nextLine();

					// Get the camp Name
					String chosenCamp = CampList.getCampInfo(chosenCampIndex-1).getCampName();
					
					//Enter enquiry
					System.out.print("Enter enquiry text: ");
					String text = sc.nextLine();
					
					// Create an enquiry object and add it to the enquiry list
					Enquiry newEnquiry = new Enquiry(text, this, chosenCamp);
					enquiriesMade.addEnquiry(newEnquiry);
				}
				else{
					System.out.println("No camps available");
				}

                break;

            case 4:
					//Output enquiries made by this student instance
					this.viewEnquiriesMade();
                break;

            case 5:
				//Edit Submitted Enquiries  
				if (enquiriesMade.getSize() == 0){
					System.out.println("No enquiries to update.");
				}
				else 
				{
					this.viewEnquiriesMade();
					System.out.print("Choose an enquiry to update (enter the number): ");
					int chosenEnquiryIndex = sc.nextInt();

					// String chosenCamp = EnquiryList.getEnquiry(chosenEnquiryIndex).getCamp();
					
					// Consume the newline character
					sc.nextLine();

					System.out.print("Enter new enquiry text: ");
					String text = sc.nextLine();
					enquiriesMade.getEnquiry(chosenEnquiryIndex-1).updateText(text);
				}
                break;

			case 6:
				//show enquiry submitted first
				//Delete Submitted Enquiries  
				// Check if there are no enquiries
				// if (EnquiryList.getEnquiriesForCamp("Orientation", studentUser).isEmpty()) {
				// 	System.out.println("No enquiries to delete.");
				// 	} 
				if (enquiriesMade.getSize() == 0){
					System.out.println("No enquiries to delete.");
				}

				else {
					this.viewEnquiriesMade();
					System.out.print("Choose an enquiry to delete (enter the number): ");
					int chosenEnquiryIndex = sc.nextInt();
					String chosenCamp = enquiriesMade.getEnquiry(chosenEnquiryIndex).getCamp();

					// Consume the newline character
					sc.nextLine();

					enquiriesMade.deleteEnquiry(chosenCamp, this);
				}
				break;

			case 7:
				// view registered camp
				this.viewRegisteredCamps();
				break;

			case 8:
				// Withdraw from camp
				this.viewRegisteredCamps();
				if (this.registeredCamps.size() != 0){
					System.out.print("Choose a camp registered to withdraw (enter the number): ");
					int chosenCampIndex = sc.nextInt();
					

					if (this.getCommitteeUser()!= null && this.getCommitteeUser().getCommitteeOf().equals(CampList.getCampInfo(chosenCampIndex-1))) {
						System.out.println("Cannot withdraw. Student is a committee for camp: "+ CampList.getCampInfo(chosenCampIndex-1).getCampName());
					}
					else{
						CampList.getCampInfo(chosenCampIndex-1).addWithdrawnStudents(this); //For camp class to keep track of all the students that withdrawn
						this.addWithdrawnCamp(CampList.getCampInfo(chosenCampIndex-1)); //For student class to keep track of camp withdrawn
					}
				}
				break;
				
            case -1:
                // Exit Menu
                System.out.println("Exiting Camp Menu. Goodbye!");
                System.exit(0);
                break;
		}

	}

}