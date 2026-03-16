import java.util.ArrayList;
import java.util.List;





public class Kuyruk {
    List<Integer> liste;
    public Kuyruk() {
        liste = new ArrayList<>();
    }
    public int ekle(int eklenecek) {
        liste.add(eklenecek);
        return 1;
    }
    public int cikar() {
        var deger = liste.get(0);
        liste.remove(0);
        return deger;
    }
    public void yazdir() {
        for (int i = 0; i < liste.size(); i++)
            System.out.print(liste.get(i)+" ");
        System.out.println();
    }
}
