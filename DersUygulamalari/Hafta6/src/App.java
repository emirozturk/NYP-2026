





public class App {
    public static void main(String[] args) throws Exception {
        var liste = new SiraliListe<Integer>();
        liste.ekle(3);
        liste.ekle(3);
        liste.tekrarsizEkle(3);
        liste.ekle(5);
        liste.ekle(1);
        liste.ekle(new Integer[]{10,9,8});
        IO.println(liste);
        liste.sil(3);
        IO.println(liste);

        var liste2 = new SiraliListe<Double>();
        liste2.ekle(3.0);
        liste2.ekle(3.0);
        liste2.tekrarsizEkle(3.0);
        liste2.ekle(5.0);
        liste2.ekle(1.0);
        liste2.ekle(new Double[]{10.0,9.0,8.0});
        IO.println(liste2);
        liste2.sil(3.0);
        IO.println(liste2);
    }
}
