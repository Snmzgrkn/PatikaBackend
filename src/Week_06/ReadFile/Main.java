package Week_06.ReadFile;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try {
            String path = "..........\\ReadFile\\deneme.txt";
            File file = new File(path);

            FileReader fReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fReader);
            String line;
            int total =0;
            while ((line = bufferedReader.readLine()) != null) {
                total+= Integer.parseInt(line);
            }
            System.out.println(total);
        } catch (IOException e) {
            e.getStackTrace();
        }

    }
}
