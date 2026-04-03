import java.util.ArrayList;
import java.util.Arrays;

class Pizza {

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
    private String boyut;
    private String kenarTipi;
    private ArrayList<String> malzemeler;

    private static int toplamSiparis = 0;
    private final int siparisNo;

    // ---------- Public Constructor (tam parametreli) ----------
    public Pizza(String boyut, String kenarTipi, ArrayList<String> malzemeler) {
        setBoyut(boyut);
        setKenarTipi(kenarTipi);
        this.malzemeler = new ArrayList<>();
        if (malzemeler != null) {
            for (String m : malzemeler) {
                malzemeEkle(m);
            }
        }
        this.siparisNo = ++toplamSiparis;
    }

    // ---------- Public Constructor (basit / overload) ----------
    public Pizza(String boyut) {
        this(boyut, "İnce", new ArrayList<>());
    }

    // ---------- Getter / Setter (validasyonlu) ----------
    public String getBoyut() {
        return boyut;
    }

    public void setBoyut(String boyut) {
        if (!GECERLI_BOYUTLAR.contains(boyut)) {
            System.out.println("HATA: Geçersiz boyut '" + boyut
                    + "'. Seçenekler: " + GECERLI_BOYUTLAR);
            return;
        }
        this.boyut = boyut;
    }

    public String getKenarTipi() {
        return kenarTipi;
    }

    public void setKenarTipi(String kenarTipi) {
        if (!GECERLI_KENARLAR.contains(kenarTipi)) {
            System.out.println("HATA: Geçersiz kenar tipi '" + kenarTipi
                    + "'. Seçenekler: " + GECERLI_KENARLAR);
            return;
        }
        this.kenarTipi = kenarTipi;
    }

    public ArrayList<String> getMalzemeler() {
        return malzemeler;
    }

    public int getSiparisNo() {
        return siparisNo;
    }

    public static int getToplamSiparis() {
        return toplamSiparis;
    }

    public static ArrayList<String> getGecerliBoyutlar() {
        return GECERLI_BOYUTLAR;
    }

    public static ArrayList<String> getGecerliKenarlar() {
        return GECERLI_KENARLAR;
    }

    public static ArrayList<String> getGecerliMalzemeler() {
        return GECERLI_MALZEMELER;
    }

    public static int getMaxMalzeme() {
        return MAX_MALZEME;
    }

    // ---------- ArrayList işlemleri (validasyonlu) ----------
    public void malzemeEkle(String malzeme) {
        if (!GECERLI_MALZEMELER.contains(malzeme)) {
            System.out.println("HATA: '" + malzeme + "' menüde yok. "
                    + "Seçenekler: " + GECERLI_MALZEMELER);
            return;
        }
        if (malzemeler.contains(malzeme)) {
            System.out.println("UYARI: '" + malzeme + "' zaten ekli.");
            return;
        }
        if (malzemeler.size() >= MAX_MALZEME) {
            System.out.println("HATA: En fazla " + MAX_MALZEME
                    + " malzeme eklenebilir. Şu anki: " + malzemeler);
            return;
        }
        malzemeler.add(malzeme);
    }

    public void malzemeCikar(String malzeme) {
        if (!malzemeler.remove(malzeme)) {
            System.out.println("UYARI: '" + malzeme + "' listede bulunamadı.");
        }
    }

    // ---------- Fiyat hesaplama ----------
    public double fiyatHesapla() {
        double toplam = boyut.equals("Büyük") ? 89.99 : 49.99;
        toplam += malzemeler.size() * 5.0;
        return toplam;
    }

    // ---------- toString OVERLOAD ----------

    // 1) Override – Object.toString() üzerine yazma
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("╔══════════════════════════════════════╗\n");
        sb.append(String.format("  Sipariş #%d\n", siparisNo));
        sb.append("╠══════════════════════════════════════╣\n");
        sb.append(String.format("  Boyut    : %s\n", boyut));
        sb.append(String.format("  Kenar    : %s\n", kenarTipi));
        sb.append(String.format("  Malzeme  : %s\n", malzemeler));
        sb.append("╠══════════════════════════════════════╣\n");
        sb.append(String.format("  TOPLAM   : %.2f TL\n", fiyatHesapla()));
        sb.append("╚══════════════════════════════════════╝");
        return sb.toString();
    }

    // 2) Overload – kısa özet versiyonu (parametre alır)
    public String toString(boolean kisaOzet) {
        if (kisaOzet) {
            return String.format("[#%d] %s | %.2f TL",
                    siparisNo, boyut, fiyatHesapla());
        }
        return toString();
    }
}
    // ==================== MAIN ====================
    public class Main{
    public static void main(String[] args) {

        System.out.println("=== MENÜ ===");
        System.out.println("Boyutlar  : " + Pizza.getGecerliBoyutlar());
        System.out.println("Kenarlar  : " + Pizza.getGecerliKenarlar());
        System.out.println("Malzemeler: " + Pizza.getGecerliMalzemeler());
        System.out.println("Maks malzeme: " + Pizza.getMaxMalzeme());
        System.out.println();

        // ---------- Sipariş listesi (ArrayList<Pizza>) ----------
        ArrayList<Pizza> siparisler = new ArrayList<>();

        // 1) Tam parametreli constructor
        ArrayList<String> m1 = new ArrayList<>(Arrays.asList("Mozzarella", "Sucuk", "Zeytin"));
        Pizza p1 = new Pizza("Büyük", "Kalın", m1);
        siparisler.add(p1);

        // 2) Basit constructor (overload)
        Pizza p2 = new Pizza("Küçük");
        p2.malzemeEkle("Mozzarella");
        p2.malzemeEkle("Biber");
        siparisler.add(p2);

        // 3) Basit constructor + setter'larla özelleştirme
        Pizza p3 = new Pizza("Büyük");
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
        for (Pizza p : siparisler) {
            System.out.println(p);
            System.out.println();
        }

        // Kısa özet (toString overload)
        System.out.println("--- Sipariş Özeti ---");
        for (int i = 0; i < siparisler.size(); i++) {
            System.out.println(siparisler.get(i).toString(true));
        }

        System.out.println("\nToplam Sipariş: " + Pizza.getToplamSiparis());
    }
}