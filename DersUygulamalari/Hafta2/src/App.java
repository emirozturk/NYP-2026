import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class App {
    
    public static boolean varMi(List<String> liste,char karakter){
        for(var eleman:liste)
            if(eleman.charAt(0) == karakter)
                return true;
        return false;
    } 
    public static void main(String[] args) throws Exception {
        /*
         * // Verilen bir dizide en büyük ve en küçük elemanı bulan fonksiyon
         * 
         * // Bir dizi açılması lazım
         * var dizi = new int[10];
         * var random = new Random();
         * for (int i = 0; i < dizi.length; i++)
         * dizi[i] = random.nextInt(50);
         * 
         * for (var eleman : dizi)
         * IO.print(eleman + " ");
         * 
         * // Dizinin ilk elemanını en büyük kabul et
         * var max = dizi[0];
         * var min = dizi[0];
         * // dizinin her elemanı için
         * for (var x : dizi) {
         * if (x > max) // Eğer sıradaki eleman en büyükten büyükse
         * max = x;// artık sıradaki eleman en büyük olacak
         * if (x < min)
         * min = x;
         * }
         * IO.println();
         * IO.println(max);
         * IO.println(min);
         * 
         * // İkinci yol
         * // diziyi sırala
         * for (int i = 0; i < dizi.length; i++)
         * for (int j = 0; j < dizi.length; j++) {
         * if(dizi[i]<dizi[j]){
         * int temp = dizi[i];
         * dizi[i] = dizi[j];
         * dizi[j] = temp;
         * }
         * }
         * for (var eleman : dizi)IO.print(eleman + " ");
         * IO.println();
         * IO.println(dizi[0]);// dizinin ilk elemanı en küçük
         * IO.print(dizi[dizi.length-1]);// dizinin son elemanı en büyük olacak
         */
        // Verilen bir stringde sesli harf sayısını bulan fonksiyon
        int sayac=0;//sayac tanımla
        var text = IO.readln();//Ekrandan bir string al
        var liste = List.of("a","e","ı","i","o","u","ö","ü");//Seslilerin olduğu bir liste tanımla 
        for(int i=0;i<text.length();i++){//String üzerinde bir döngü kur
            var karakter = text.toLowerCase().charAt(i);//Döngü içerisinde her karakter için bu listede var mı diye kontrol et
            if(varMi(liste, karakter))sayac++; //varsa sayacı bir arttır
        }
        IO.println(sayac);
    }
}