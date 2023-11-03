package src;
public class CampCommittee extends Student {
    // Instances
    private int points;

    // Constructors
    public CampCommittee(String userID, String name, Faculty faculty, String email, int points){
        super(userID, name, faculty, email);
        this.setStatus("Camp Committee");
        this.points = points;
    }

    // Accessors
    public int getPoints(){
        return this.points;
    }

    // Mutators
    public void setPoints(int points){
        this.points = points;
    }
}