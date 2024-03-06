package Week_04.UniversityManagementSystem;

public class Assistant extends Academician {
    private String officeHours;

    public String getOfficeHours() {
        return officeHours;
    }

    public void setOfficeHours(String officeHours) {
        this.officeHours = officeHours;
    }

    public Assistant(String nameSurname, String phoneNumber, String email, String faculty, String title) {
        super(nameSurname, phoneNumber, email, faculty, title);
    }


    @Override
    public void goClass(String string) {
        System.out.println(this.getNameSurname() + " assistant entered the class at" + string);
    }
}
