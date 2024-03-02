package Week_02.SortArrayElements;

import javax.sound.midi.Soundbank;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        System.out.println("Array Size n :");
        int size = scanner.nextInt();
        int array[] = new int[size];
        System.out.println("Please Enter Array Elements :");
        for (int i = 0,start=1; i < size; i++) {
            System.out.println(start + ".Element :");
            int inputElement= scanner.nextInt();
            array[i] = inputElement;
            start++;
        }
        Arrays.sort(array);
        System.out.println("Sıralama : "+Arrays.toString(array));
    }
}
