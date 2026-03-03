import java.util.Scanner;

public class HesapMakinesi {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Hesap Makinesi ===");
        System.out.println("Çıkmak için 'q' yazın.\n");

        while (true) {
            System.out.print("İlk sayı (veya 'q'): ");
            String ilkGirdi = scanner.nextLine().trim();

            if (ilkGirdi.equalsIgnoreCase("q")) {
                System.out.println("Program sonlandırıldı.");
                break;
            }

            double sayi1, sayi2;

            try {
                sayi1 = Double.parseDouble(ilkGirdi);
            } catch (NumberFormatException e) {
                System.out.println("Geçersiz sayı girdiniz!\n");
                continue;
            }

            System.out.print("İşlem (+, -, *, /): ");
            String islem = scanner.nextLine().trim();

            if (!islem.equals("+") && !islem.equals("-") &&
                    !islem.equals("*") && !islem.equals("/")) {
                System.out.println("Geçersiz işlem!\n");
                continue;
            }

            System.out.print("İkinci sayı: ");
            String ikinciGirdi = scanner.nextLine().trim();

            try {
                sayi2 = Double.parseDouble(ikinciGirdi);
            } catch (NumberFormatException e) {
                System.out.println("Geçersiz sayı girdiniz!\n");
                continue;
            }

            double sonuc;

            try {
                sonuc = hesapla(sayi1, islem, sayi2);
            } catch (ArithmeticException e) {
                System.out.println("Sıfıra bölme hatası!\n");
                continue;
            }

            System.out.printf("Sonuç: %.2f %s %.2f = %.2f%n%n",
                    sayi1, islem, sayi2, sonuc);
        }

        scanner.close();
    }

    private static double hesapla(double a, String op, double b) {
        return switch (op) {
            case "+" -> a + b;
            case "-" -> a - b;
            case "*" -> a * b;
            case "/" -> {
                if (b == 0) throw new ArithmeticException();
                yield a / b;
            }
            default -> throw new IllegalArgumentException();
        };
    }
}