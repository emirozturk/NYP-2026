import java.util.Scanner;

public class NotHesapla {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Vize notunu girin: ");
        double vize = scanner.nextDouble();

        System.out.print("Final notunu girin: ");
        double finalNotu = scanner.nextDouble();

        double gecmeNotu = vize * 0.30 + finalNotu * 0.70;

        System.out.printf("Geçme Notu: %.2f\n", gecmeNotu);

        if (gecmeNotu >= 60) {
            System.out.println("Başarı Durumu: Başarılı");
        } else if (gecmeNotu >= 50) {
            System.out.println("Başarı Durumu: Koşullu Geçti");
        } else {
            System.out.println("Başarı Durumu: Başarısız");
        }

        scanner.close();
    }
}