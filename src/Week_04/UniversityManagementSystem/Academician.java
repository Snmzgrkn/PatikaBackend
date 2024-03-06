package Week_04.UniversityManagementSystem;

public abstract class Academician extends Employee{
    private String faculty;
    private String title;


    public Academician(String nameSurname, String phoneNumber, String email, String faculty, String title) {
        super(nameSurname, phoneNumber, email);
        this.faculty = faculty;
        this.title = title;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public abstract void goClass(String string );

    @Override
    public  void entrance(){
        System.out.println(this.getNameSurname() + " acedemician entered from B Gate to the University !");
    }
}
