# Pizza Sipariş Sistemi – Uygulama Sorusu

## Senaryo

Bir pizzacı için basit bir sipariş sistemi tasarlamanız istenmektedir. Aşağıdaki kurallara uygun şekilde `Pizza` sınıfını yazınız.

---

## Kurallar

### Menü Seçenekleri

Aşağıdaki seçenekler **sınıf düzeyinde sabit `ArrayList`** olarak tanımlanmalıdır:

| Özellik    | Geçerli Değerler                              |
|------------|------------------------------------------------|
| Boyut      | Küçük, Büyük                                  |
| Kenar Tipi | İnce, Kalın                                   |
| Malzemeler | Mozzarella, Sucuk, Zeytin, Biber, Mantar       |

- Bir pizzaya **en fazla 3 malzeme** eklenebilir.
- Aynı malzeme birden fazla kez eklenemez.
- Menüde olmayan bir malzeme eklenemez.
- Boyut ve kenar tipi yalnızca yukarıdaki değerlerden biri olabilir.

### Fiyatlandırma

- Küçük pizza: **49.99 TL**
- Büyük pizza: **89.99 TL**
- Her malzeme ek **5.00 TL**

### Sipariş Numarası

Her pizza oluşturulduğunda otomatik artan bir sipariş numarası almalıdır. Bu numara dışarıdan değiştirilemez.

---

## İstenenler

### 1. Alanlar (Fields)

Sınıfın tüm alanları `private` olmalıdır. Hangi alanların gerektiğine yukarıdaki kurallara göre karar veriniz.

### 2. Constructor'lar

İki farklı constructor yazınız:

- **Tam parametreli:** Boyut, kenar tipi ve malzeme listesini alır.
- **Basit (overload):** Yalnızca boyut alır. Kenar tipi varsayılan olarak `"İnce"`, malzeme listesi boş olur.

> **İpucu:** Basit constructor, tam parametreli constructor'ı `this(...)` ile çağırabilir.

### 3. Getter / Setter

- Tüm alanlar için uygun getter ve setter yazınız.
- `setBoyut` ve `setKenarTipi` metodları geçersiz değer geldiğinde konsola hata mesajı yazdırmalı ve değeri **değiştirmemelidir**.

### 4. Malzeme İşlemleri

- `malzemeEkle(String malzeme)` → Menüde var mı, zaten ekli mi, maksimum sınıra ulaşılmış mı kontrol eder. Uygun değilse konsola hata/uyarı basar.
- `malzemeCikar(String malzeme)` → Listede yoksa uyarı basar.

### 5. Fiyat Hesaplama

`fiyatHesapla()` metodu yukarıdaki fiyatlandırma kurallarına göre toplam fiyatı döndürmelidir.

### 6. toString (Override ve Overload)

İki farklı `toString` metodu yazınız:

- **Parametresiz (Override):** Aşağıdaki formatta detaylı çıktı üretir:

```
╔══════════════════════════════════════╗
  Sipariş #1
╠══════════════════════════════════════╣
  Boyut    : Büyük
  Kenar    : Kalın
  Malzeme  : [Mozzarella, Sucuk, Zeytin]
╠══════════════════════════════════════╣
  TOPLAM   : 104.99 TL
╚══════════════════════════════════════╝
```

- **Parametreli (Overload):** `toString(boolean kisaOzet)` → `true` geldiğinde tek satırlık özet döner:

```
[#1] Büyük | 104.99 TL
```

---

## ArrayList Hatırlatmaları

```java
// Boş ArrayList oluşturma
ArrayList<String> liste = new ArrayList<>();

// Birden fazla elemanla ArrayList oluşturma
ArrayList<String> liste = new ArrayList<>(Arrays.asList("A", "B", "C"));

// Eleman ekleme / çıkarma
liste.add("D");
liste.remove("B");

// Eleman var mı kontrolü
if (liste.contains("A")) { ... }

// Eleman sayısı
liste.size()

// Döngü ile gezme
for (String eleman : liste) { ... }

// Yazdırma – toString() otomatik çalışır
System.out.println(liste);   // Çıktı: [A, C, D]
```

> **Not:** `Arrays.asList(...)` kullanabilmek için `import java.util.Arrays;` gerekir.

---

## Genel İpuçları

- **`private` alan + `public` getter/setter:** Alanlara doğrudan erişimi kapatıp kontrollü erişim sağlar. Setter içinde validasyon yaparak geçersiz değerlerin atanmasını engelleyebilirsiniz.

- **`static` alan:** Tüm nesneler arasında paylaşılır. Sipariş sayacı gibi sınıfa ait bilgiler için uygundur. Erişimi `static` getter ile sağlayınız.

- **`final` alan:** Bir kez atandıktan sonra değiştirilemez. Sipariş numarası gibi sabit kalması gereken değerler için kullanınız.

- **Constructor zinciri (`this(...)`):** Basit constructor'dan tam parametreli constructor'ı çağırarak kod tekrarından kaçınabilirsiniz.

- **`@Override` vs Overload:** Aynı isim + aynı parametre = override (üst sınıfın metodunu ezer). Aynı isim + farklı parametre = overload (yeni bir versiyon).

- **Validasyonda erken çıkış:** Setter ve ekleme metodlarında geçersiz durumu önce kontrol edip `return` ile çıkınız; geçerli durumu `if` bloğunun dışında yazınız. Bu, iç içe `if`'lerden kaçınmanızı sağlar.

- **`String` karşılaştırma:** String değerleri `==` yerine `.equals()` ile karşılaştırınız.

- **`String.format()`:** Formatlı çıktı için `%s` (String), `%d` (int), `%.2f` (ondalık) gibi yer tutucuları kullanabilirsiniz.

---

## Test (main metodu)

Aşağıdaki `main` metodunu yazarak programınızı test ediniz:

```java
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
        p3.setKenarTipi("Peynir Dolgulu");      // HATA: geçersiz kenar

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
```

---

## Beklenen Konsol Çıktısı

```
=== MENÜ ===
Boyutlar  : [Küçük, Büyük]
Kenarlar  : [İnce, Kalın]
Malzemeler: [Mozzarella, Sucuk, Zeytin, Biber, Mantar]
Maks malzeme: 3

--- Hata / Uyarı Senaryoları ---
HATA: En fazla 3 malzeme eklenebilir. Şu anki: [Mozzarella, Mantar, Biber]
HATA: 'Ananas' menüde yok. Seçenekler: [Mozzarella, Sucuk, Zeytin, Biber, Mantar]
HATA: Geçersiz boyut 'Dev'. Seçenekler: [Küçük, Büyük]
HATA: Geçersiz kenar tipi 'Dolgulu'. Seçenekler: [İnce, Kalın]

--- Malzeme Çıkar / Ekle ---
Mantar çıkarıldı: [Mozzarella, Biber]
Sucuk eklendi   : [Mozzarella, Biber, Sucuk]

--- Tüm Siparişler ---
╔══════════════════════════════════════╗
  Sipariş #1
╠══════════════════════════════════════╣
  Boyut    : Büyük
  Kenar    : Kalın
  Malzeme  : [Mozzarella, Sucuk, Zeytin]
╠══════════════════════════════════════╣
  TOPLAM   : 104.99 TL
╚══════════════════════════════════════╝

╔══════════════════════════════════════╗
  Sipariş #2
╠══════════════════════════════════════╣
  Boyut    : Küçük
  Kenar    : İnce
  Malzeme  : [Mozzarella, Biber]
╠══════════════════════════════════════╣
  TOPLAM   : 59.99 TL
╚══════════════════════════════════════╝

╔══════════════════════════════════════╗
  Sipariş #3
╠══════════════════════════════════════╣
  Boyut    : Büyük
  Kenar    : Kalın
  Malzeme  : [Mozzarella, Biber, Sucuk]
╠══════════════════════════════════════╣
  TOPLAM   : 104.99 TL
╚══════════════════════════════════════╝

--- Sipariş Özeti ---
[#1] Büyük | 104.99 TL
[#2] Küçük | 59.99 TL
[#3] Büyük | 104.99 TL

Toplam Sipariş: 3
```

