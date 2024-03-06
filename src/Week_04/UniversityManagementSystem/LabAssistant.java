package Week_04.UniversityManagementSystem;

public class LabAssistant extends  Assistant{

    public LabAssistant(String nameSurname, String phoneNumber, String email, String faculty, String title) {
        super(nameSurname, phoneNumber, email, faculty, title);
    }

    public void goLabs(){
        System.out.println(this.getNameSurname() + "Lab Assistant entered the Lab");
    }

    @Override
    public  void goClass(String string){
        System.out.println(this.getNameSurname() + "Lab Assistant entered the Lab at " + string);
    }
}
