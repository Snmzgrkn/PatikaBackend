package Week_04.UniversityManagementSystem;

public class Lecturer extends Academician{

    private String doorNo;

    public Lecturer(String nameSurname, String phoneNumber, String email, String faculty, String title, String doorNo) {
        super(nameSurname, phoneNumber, email, faculty, title);
        this.doorNo = doorNo;
    }

    public String getDoorNo() {
        return doorNo;
    }

    public void setDoorNo(String doorNo) {
        this.doorNo = doorNo;
    }

    public void senateMeeting(){
        System.out.println(this.getNameSurname() + "do Senate Meeting !");
    }

    public void doExam(){
        System.out.println(this.getNameSurname() + "do Exam !!");
    }

    @Override
    public  void entrance(){
        System.out.println(this.getNameSurname() + " lecturer entered the University from A Gate !!");
    }

    @Override
    public void goClass(String hour){
        System.out.println(this.getNameSurname() + " lecturer entered the class at " + hour);
    }
}
