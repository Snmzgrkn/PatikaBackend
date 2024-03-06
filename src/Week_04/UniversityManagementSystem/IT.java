package Week_04.UniversityManagementSystem;

public class IT extends Officer{
    private String duty;

    public IT(String nameSurname, String phoneNumber, String email, String department, String shift) {
        super(nameSurname, phoneNumber, email, department, shift);
    }

    public String getDuty() {
        return duty;
    }

    public void setDuty(String duty) {
        this.duty = duty;
    }

    public void networkSetup(){
        System.out.println(this.getNameSurname() + " completed the Network Setup !");
    }
}
