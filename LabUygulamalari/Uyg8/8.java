public class Main {
    public static void main() {
        IO.println(Islemler.topla(3,4));
        double[] s={3.5,.4};
        IO.println(Islemler.topla(s));
        KarmasikSayi k1=new KarmasikSayi(1,2);
        IO.print(
                Islemler.topla(k1, new KarmasikSayi(3.2, 4.2))
        );
    }
    /*
    Beklenen çıktı
    7.0
    3.9
    4.2 + 6.2i
     */
}