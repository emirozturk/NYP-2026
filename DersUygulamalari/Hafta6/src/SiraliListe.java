import java.util.ArrayList;
import java.util.List;

public class SiraliListe<E extends Number> {
    private List<E> liste;

    public SiraliListe() {
        liste = new ArrayList<E>();
    }

    public void ekle(E sayi) {
        int i = 0;
        for (i = 0; i < liste.size(); i++) {
            if (liste.get(i).doubleValue() > sayi.doubleValue()) {
                break;
            }
        }
        liste.add(i, sayi);
    }

    public void tekrarsizEkle(E sayi) {
        if (!liste.contains(sayi))
            ekle(sayi);
    }

    public void ekle(E[] dizi) {
        for (int i = 0; i < dizi.length; i++) {
            ekle(dizi[i]);
        }
    }

    public void sil(E sayi) {
        for (int i = 0; i < liste.size(); i++)
            if (liste.get(i) == sayi) {
                liste.remove(i);
                i--;
            }
    }

    public String toString() {
        String cikti = "";
        for (int i = 0; i < liste.size(); i++)
            cikti += liste.get(i) + " ";
        return cikti;
    }
}
