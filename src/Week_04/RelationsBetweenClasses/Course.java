package Week_04.RelationsBetweenClasses;

public class Course {
    private String courseName;
    private String code;
    private Instructor instructor;

    public Course(String courseName,String code,Instructor instructor){
        this.courseName=courseName;
        this.code=code;
        this.instructor=instructor;
    }


    //Course uses a Student (Course sınıfı Student sınıfına bağlı)
    public double calcAverage(Student[] students){
        double average = 0;
        for (Student student : students) {
            average += student.getNote();
        }

        return average / students.length;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Instructor getInstructor() {
        return instructor;
    }

    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }
}
