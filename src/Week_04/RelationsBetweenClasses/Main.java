package Week_04.RelationsBetweenClasses;

public class Main {
    public static void main(String[] args) {

        Student student1 = new Student("Gürkan","Sönmez","123","AA",85);
        Student student2 = new Student("Ali","Kaplan","321","BB",85);
        Student student3 = new Student("Veli","Aslan","145","CC",85);


        Instructor teacher = new Instructor("Mahmut","Çetindağ","CENG");
        Instructor t2 = new Instructor("a","b","CENG");

        //Kalıtım (Inheritance)
        //Composition , Aggretation
        //Course has a Instructor (Sınıfın bir öğretmeni vardır.)
        Course mat = new Course("MAT101","MAT",teacher);
        System.out.println(mat.getInstructor().getName());


        /*
        Student[] stu = {student1,student2,student3};
        System.out.println("Ortalama : " + mat.calcAverage(stu));
        */


    }
}

