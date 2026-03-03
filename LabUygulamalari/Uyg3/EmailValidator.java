import java.util.Scanner;

public class EmailValidator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("E-posta adresinizi girin: ");
        String email = scanner.nextLine();

        // 1) Boş olmamalı
        if (email.isEmpty()) {
            System.out.println("Hata: E-posta adresi boş olamaz!");
            return;
        }

        // 2) Tam olarak bir adet '@' karakteri içermeli
        int atSayisi = 0;
        for (int i = 0; i < email.length(); i++) {
            if (email.charAt(i) == '@') {
                atSayisi++;
            }
        }
        if (atSayisi != 1) {
            System.out.println("Hata: E-posta tam olarak bir adet '@' içermelidir!");
            return;
        }

        // 3) '@' ilk veya son karakter olmamalı
        if (email.indexOf('@') == 0 || email.indexOf('@') == email.length() - 1) {
            System.out.println("Hata: '@' ilk veya son karakter olamaz!");
            return;
        }

        // 4) '@' sonrasında en az bir '.' olmalı
        String domain = email.substring(email.indexOf('@') + 1);
        if (domain.indexOf('.') == -1) {
            System.out.println("Hata: '@' sonrasında en az bir '.' bulunmalıdır!");
            return;
        }

        // 5) '.' son karakter olmamalı
        if (email.charAt(email.length() - 1) == '.') {
            System.out.println("Hata: '.' son karakter olamaz!");
            return;
        }

        // Tüm kontrollerden geçti
        String kullaniciAdi = email.substring(0, email.indexOf('@'));

        System.out.println("Kullanıcı: " + kullaniciAdi.toUpperCase());
        System.out.println("Domain:    " + domain.toUpperCase());

        scanner.close();
    }
}
