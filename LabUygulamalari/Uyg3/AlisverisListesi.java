import java.util.ArrayList;
import java.util.Scanner;

public class AlisverisListesi {
    public static void main(String[] args) {
        ArrayList<String> liste = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        int secim;

        do {
            System.out.println("\n--- Alışveriş Listesi ---");
            System.out.println("1) Ürün ekle");
            System.out.println("2) Ürün sil (isme göre)");
            System.out.println("3) Listeyi göster");
            System.out.println("4) Listede ürün ara");
            System.out.println("5) Çıkış");
            System.out.print("Seçiminiz: ");
            secim = sc.nextInt();
            sc.nextLine();

            switch (secim) {
                case 1:
                    System.out.print("Eklenecek ürün: ");
                    String urun = sc.nextLine();
                    liste.add(urun);
                    System.out.println("\"" + urun + "\" listeye eklendi.");
                    break;

                case 2:
                    System.out.print("Silinecek ürün: ");
                    String silinecek = sc.nextLine();
                    if (liste.remove(silinecek)) {
                        System.out.println("\"" + silinecek + "\" listeden silindi.");
                    } else {
                        System.out.println("Ürün bulunamadı!");
                    }
                    break;

                case 3:
                    if (liste.isEmpty()) {
                        System.out.println("Liste boş!");
                    } else {
                        System.out.println("Alışveriş Listesi:");
                        for (int i = 0; i < liste.size(); i++) {
                            System.out.println((i + 1) + ". " + liste.get(i));
                        }
                    }
                    break;

                case 4:
                    System.out.print("Aranacak ürün: ");
                    String aranan = sc.nextLine();
                    if (liste.contains(aranan)) {
                        System.out.println("\"" + aranan + "\" listede mevcut. (Sıra: " + (liste.indexOf(aranan) + 1) + ")");
                    } else {
                        System.out.println("Ürün bulunamadı!");
                    }
                    break;

                case 5:
                    System.out.println("Toplam " + liste.size() + " ürün ile çıkıldı.");
                    break;

                default:
                    System.out.println("Geçersiz seçim!");
            }
        } while (secim != 5);

        sc.close();
    }
}