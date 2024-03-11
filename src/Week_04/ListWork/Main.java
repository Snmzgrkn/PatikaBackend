package Week_04.ListWork;

public class Main {
    public static void main(String[] args) {
        MyList<Integer> liste = new MyList<>();
        liste.add(10);
        liste.add(20);
        liste.add(30);
        System.out.println("2. indisteki değer : " + liste.get(2));
        liste.remove(2);
        liste.add(40);
        liste.set(0, 100);
        System.out.println("2. indisteki değer : " + liste.get(2));
        System.out.println(liste.toString());
    }
    }

