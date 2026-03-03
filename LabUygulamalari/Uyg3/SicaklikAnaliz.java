public class SicaklikAnaliz {
    public static void main(String[] args) {
        double[] sicakliklar = {55.5, 11.1, 44.4, 33.3};

        // a) En yüksek ve en düşük
        double enYuksek = sicakliklar[0];
        double enDusuk = sicakliklar[0];
        for (double s : sicakliklar) {
            if (s > enYuksek) enYuksek = s;
            if (s < enDusuk) enDusuk = s;
        }
        System.out.println("En yüksek sıcaklık: " + enYuksek);
        System.out.println("En düşük sıcaklık: " + enDusuk);

        // b) Ortalama
        double toplam = 0;
        for (double s : sicakliklar) {
            toplam += s;
        }
        double ortalama = toplam / sicakliklar.length;
        System.out.println("Ortalama sıcaklık: " + ortalama);

        // c) Ortalamanın üzerindeki günler
        int sayac = 0;
        System.out.print("Ortalamanın üzerindeki değerler: ");
        for (int i = 0; i < sicakliklar.length; i++) {
            if (sicakliklar[i] > ortalama) {
                System.out.print(sicakliklar[i] + " ");
                sayac++;
            }
        }
        System.out.println("\nOrtalamanın üzerindeki gün sayısı: " + sayac);

        // d) Diziyi tersten yazdırma
        System.out.print("Ters sıralama: ");
        for (int i = sicakliklar.length - 1; i >= 0; i--) {
            System.out.print(sicakliklar[i] + " ");
        }
        System.out.println();
    }
}
