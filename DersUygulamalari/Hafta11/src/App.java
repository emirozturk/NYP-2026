import java.util.ArrayList;
import java.util.List;

class Kisi{
    public int yas;
}
public class App {
    public static void ekranaYazdir(List<Integer> liste) {
        for (var eleman : liste)
            IO.print(eleman + " ");
        IO.println();
    }

    public static void main(String[] args) throws Exception {
        /*
         * 
         * Liste içerisindeki 50den büyük sayıların 5. elemandan 10. elemana kadar
         * olanlarını alan ve bu sayıların karelerini küçükten büyüğe sıralayıp bir
         * string dizisi olarak döndüren metot
         * 
         */
        var liste = List.of(8, 5, 67, 16, 55, 77, 32, 1881, 1453, 171, 61, 29, 12, 60, 70, 80, 54, 53, 68, 73, 88, 98);
        var ellidenBuyukler = new ArrayList<Integer>();
        for (int i = 0; i < liste.size(); i++) {
            if (liste.get(i) > 50) {
                ellidenBuyukler.add(liste.get(i));
            }
        }
        ekranaYazdir(ellidenBuyukler);
        var aradakiler = new ArrayList<Integer>();
        for (int i = 5; i < 10; i++) {
            aradakiler.add(ellidenBuyukler.get(i));
        }
        ekranaYazdir(aradakiler);
        for (int i = 0; i < aradakiler.size(); i++) {
            var d = aradakiler.get(i) * aradakiler.get(i);
            aradakiler.set(i,d);
        }
        ekranaYazdir(aradakiler);
        for (int i = 0; i < aradakiler.size(); i++) {
            for (int j = 0; j < aradakiler.size(); j++) {
                if(aradakiler.get(i)<aradakiler.get(j)){
                    int temp = aradakiler.get(i);
                    aradakiler.set(i,aradakiler.get(j));
                    aradakiler.set(j, temp);
                }
            }
        }
        ekranaYazdir(aradakiler);

        var sonuc = liste
                        .stream()
                        .filter(x->x>50)
                        .skip(5)
                        .limit(5)
                        .map(x->x*x)
                        .sorted()
                        .toList();

        var kisiler = new ArrayList<Kisi>();

        var sayi = kisiler.stream().filter(x->x.yas>50).count();

        ekranaYazdir(sonuc);
    }
}
