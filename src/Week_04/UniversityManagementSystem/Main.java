package Week_04.UniversityManagementSystem;

public class Main {
    public static void main(String[] args) {
        Employee e1 = new Employee("Gürkan Sönmez","05011111111","gurkan@gmail.com");

        //Academician a1 = new Academician("Görkem Sönmez","05010510505","faruk@gmail.com","Engineering","Prof.");

        //Officer o1 = new Officer("Ali Veli","1234","office@gmail.com","Security","50");

        Lecturer l1 = new Lecturer("Mahmut Çetindağ","1234","mahmut@gmail.com","CENG0","Dr.","11");

        l1.goClass("10:00");
        //Employee e2 = new Academician("Patika","1234","patika@gmail.com","CENG","Mr.");
        //Overloading

        Assistant as1= new Assistant("Emine","1235","asdasd","SOFTWARE","Plt.");

        as1.goClass("9:00");




    }
}
