package Week_05.MostUsedWord;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Kullanıcıdan metni al
        Scanner scanner = new Scanner(System.in);
        System.out.print("Metni giriniz: ");
        String metin = scanner.nextLine();

        // Metni kelimelere ayır
        String[] kelimeler = metin.split("\\s+");

        // Kelimeleri saymak için bir HashMap oluştur
        Map<String, Integer> kelimeSayac = new HashMap<>();

        // Kelimeleri döngüyle tek tek dolaşarak HashMap'e ekle
        for (String kelime : kelimeler) {
            if (kelimeSayac.containsKey(kelime)) {
                // Eğer kelime zaten HashMap'te varsa, sayacını bir artır
                kelimeSayac.put(kelime, kelimeSayac.get(kelime) + 1);
            } else {
                // Eğer kelime HashMap'te yoksa, yeni bir giriş oluştur ve sayacı 1 yap
                kelimeSayac.put(kelime, 1);
            }
        }

        // En çok tekrar eden kelimeyi bul
        String enCokGecenKelime = "";
        int enCokGecenKelimeSayisi = 0;
        for (Map.Entry<String, Integer> entry : kelimeSayac.entrySet()) {
            if (entry.getValue() > enCokGecenKelimeSayisi) {
                enCokGecenKelime = entry.getKey();
                enCokGecenKelimeSayisi = entry.getValue();
            }
        }

        // Sonucu ekrana yazdır
        System.out.println("En çok geçen kelime: " + enCokGecenKelime + ", Sayısı: " + enCokGecenKelimeSayisi);
    }
}
