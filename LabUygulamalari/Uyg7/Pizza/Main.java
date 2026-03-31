import java.util.ArrayList;
import java.util.Arrays;

class PizzaSablon {

    // ---------- Geçerli seçenekler (ArrayList) ----------
    private static final ArrayList<String> GECERLI_BOYUTLAR = new ArrayList<>(
        Arrays.asList("Küçük", "Büyük")
    );
    private static final ArrayList<String> GECERLI_KENARLAR = new ArrayList<>(
        Arrays.asList("İnce", "Kalın")
    );
    private static final ArrayList<String> GECERLI_MALZEMELER = new ArrayList<>(
        Arrays.asList("Mozzarella", "Sucuk", "Zeytin", "Biber", "Mantar")
    );
    private static final int MAX_MALZEME = 3;

    // ---------- Alanlar (Fields) ----------
    // BURAYI SİZ YAZIN
    // İpucu: boyut, kenarTipi, malzemeler, toplamSiparis, siparisNo
    //        Hangileri private/static/final olmalı? Tipleri ne olmalı?



    // ---------- Public Constructor (tam parametreli) ----------
    public PizzaSablon(String boyut, String kenarTipi, ArrayList<String> malzemeler) {
        // BURAYI SİZ YAZIN
        // İpucu: setBoyut ve setKenarTipi kullanarak validasyonlu atama yapın.
        //        malzemeler listesini boş oluşturup, döngü ile malzemeEkle çağırın.
        //        siparisNo'yu toplamSiparis'ten türetin.


    }

    // ---------- Public Constructor (basit / overload) ----------
    // BURAYI SİZ YAZIN
    // İpucu: Sadece boyut parametresi alsın.
    //        Kenar varsayılan "İnce", malzemeler boş ArrayList olsun.
    //        this(...) ile tam parametreli constructor'ı çağırın.



    // ---------- Getter / Setter (validasyonlu) ----------

    public String getBoyut() { return boyut; }

    public void setBoyut(String boyut) {
        // BURAYI SİZ YAZIN
        // İpucu: GECERLI_BOYUTLAR.contains(...) ile kontrol edin.
        //        Geçersizse hata mesajı yazdırıp return ile çıkın.
        //        Geçerliyse this.boyut = boyut atayın.


    }

    public String getKenarTipi() { return kenarTipi; }

    public void setKenarTipi(String kenarTipi) {
        // BURAYI SİZ YAZIN
        // İpucu: setBoyut ile aynı mantık, GECERLI_KENARLAR kullanın.


    }

    public ArrayList<String> getMalzemeler() { return malzemeler; }

    public int getSiparisNo()                      { return siparisNo; }
    public static int getToplamSiparis()           { return toplamSiparis; }

    public static ArrayList<String> getGecerliBoyutlar()    { return GECERLI_BOYUTLAR; }
    public static ArrayList<String> getGecerliKenarlar()    { return GECERLI_KENARLAR; }
    public static ArrayList<String> getGecerliMalzemeler()  { return GECERLI_MALZEMELER; }
    public static int getMaxMalzeme()                       { return MAX_MALZEME; }

    // ---------- ArrayList işlemleri (validasyonlu) ----------

    public void malzemeEkle(String malzeme) {
        // BURAYI SİZ YAZIN
        // 3 kontrol yapılmalı (her biri geçersizse hata basıp return ile çıkın):
        //   1) Menüde var mı?       → GECERLI_MALZEMELER.contains(...)
        //   2) Zaten ekli mi?       → malzemeler.contains(...)
        //   3) Maksimum aşıldı mı?  → malzemeler.size() >= MAX_MALZEME
        // Hepsi geçerliyse → malzemeler.add(malzeme)


    }

    public void malzemeCikar(String malzeme) {
        // BURAYI SİZ YAZIN
        // İpucu: malzemeler.remove(malzeme) false dönerse uyarı yazdırın.


    }

    // ---------- Fiyat hesaplama ----------
    public double fiyatHesapla() {
        // BURAYI SİZ YAZIN
        // İpucu: Büyük → 89.99, Küçük → 49.99 (taban fiyat)
        //        + malzeme sayısı * 5.0

        return 0; // Bu satırı değiştirin
    }

    // ---------- toString (Override) ----------
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("╔══════════════════════════════════════╗\n");
        // BURAYI SİZ YAZIN
        // İpucu: String kullanarak siparisNo, boyut, kenarTipi,
        //        malzemeler ve fiyatHesapla() değerlerini ekleyin.
        //        Beklenen çıktı formatına bakınız.

        sb.append("╚══════════════════════════════════════╝");
        return sb.toString();
    }

    // ---------- toString (Overload) ----------
    // BURAYI SİZ YAZIN
    // İpucu: toString(boolean kisaOzet) imzasıyla yeni bir metot yazın.
    //        true gelirse → "[#1] Büyük | 104.99 TL" formatında döndürün.
    //        false gelirse → toString() çağırın.


}
    // ==================== MAIN ====================
     public class Main{

    public static void main(String[] args) {

        System.out.println("=== MENÜ ===");
        System.out.println("Boyutlar  : " + PizzaSablon.getGecerliBoyutlar());
        System.out.println("Kenarlar  : " + PizzaSablon.getGecerliKenarlar());
        System.out.println("Malzemeler: " + PizzaSablon.getGecerliMalzemeler());
        System.out.println("Maks malzeme: " + PizzaSablon.getMaxMalzeme());
        System.out.println();

        // ---------- Sipariş listesi (ArrayList<Pizza>) ----------
        ArrayList<PizzaSablon> siparisler = new ArrayList<>();

        // 1) Tam parametreli constructor
        ArrayList<String> m1 = new ArrayList<>(Arrays.asList("Mozzarella", "Sucuk", "Zeytin"));
        PizzaSablon p1 = new PizzaSablon("Büyük", "Kalın", m1);
        siparisler.add(p1);

        // 2) Basit constructor (overload)
        PizzaSablon p2 = new PizzaSablon("Küçük");
        p2.malzemeEkle("Mozzarella");
        p2.malzemeEkle("Biber");
        siparisler.add(p2);

        // 3) Basit constructor + setter'larla özelleştirme
        PizzaSablon p3 = new PizzaSablon("Büyük");
        p3.setKenarTipi("Kalın");
        p3.malzemeEkle("Mozzarella");
        p3.malzemeEkle("Mantar");
        p3.malzemeEkle("Biber");
        siparisler.add(p3);

        // --- Hata senaryoları ---
        System.out.println("--- Hata / Uyarı Senaryoları ---");
        p3.malzemeEkle("Zeytin");        // HATA: zaten 3 malzeme var
        p3.malzemeEkle("Ananas");        // HATA: menüde yok
        p3.setBoyut("Dev");              // HATA: geçersiz boyut
        p3.setKenarTipi("Dolgulu");      // HATA: geçersiz kenar

        // --- Silme ve tekrar ekleme ---
        System.out.println("\n--- Malzeme Çıkar / Ekle ---");
        p3.malzemeCikar("Mantar");
        System.out.println("Mantar çıkarıldı: " + p3.getMalzemeler());
        p3.malzemeEkle("Sucuk");
        System.out.println("Sucuk eklendi   : " + p3.getMalzemeler());

        // --- ArrayList üzerinde döngü ile tüm siparişler ---
        System.out.println("\n--- Tüm Siparişler ---");
        for (PizzaSablon p : siparisler) {
            System.out.println(p);
            System.out.println();
        }

        // Kısa özet (toString overload)
        System.out.println("--- Sipariş Özeti ---");
        for (int i = 0; i < siparisler.size(); i++) {
            System.out.println(siparisler.get(i).toString(true));
        }

        System.out.println("\nToplam Sipariş: " + PizzaSablon.getToplamSiparis());
    }
}
