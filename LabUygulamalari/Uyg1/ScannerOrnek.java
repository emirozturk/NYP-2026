import java.util.Scanner;

public class ScannerOrnek {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Adınız: ");
        String ad = scanner.nextLine();

        System.out.print("Yaşınız: ");
        int yas = scanner.nextInt();

        System.out.print("Boy (m): ");
        double boy = scanner.nextDouble();

        System.out.println(ad + ", " + yas + " yaşında, boyu " + boy + " m");

        scanner.close();
    }
}