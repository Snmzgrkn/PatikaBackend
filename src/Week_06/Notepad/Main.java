package Week_06.Notepad;

import java.io.*;
import java.util.Scanner;

public class Main {
    static final String path = "deneme.txt";
    public static void main(String[] args) {
        BufferedReader okuyucu = new BufferedReader(new InputStreamReader(System.in));

        // Kullanıcıdan metin girişi al
        System.out.println("Lütfen metni girin:");
        String metin = "";
        try {
            metin = okuyucu.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Metni dosyaya kaydet
        dosyayaYaz(path, metin);

        // En son kaydedilen metni ekrana yazdır
        String sonKaydedilenMetin = dosyadanOku(path);
        System.out.println("En son kaydedilen metin:");
        System.out.println(sonKaydedilenMetin);

    }
    private static void dosyayaYaz(String dosyaYolu, String metin) {
        try (FileWriter yazici = new FileWriter(dosyaYolu)) {
            yazici.write(metin);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String dosyadanOku(String dosyaYolu) {
        StringBuilder metin = new StringBuilder();
        try (FileReader okuyucu = new FileReader(dosyaYolu)) {
            int karakter;
            while ((karakter = okuyucu.read()) != -1) {
                metin.append((char) karakter);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return metin.toString();
    }

}
