import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class App {
    public static void main(String[] args) throws Exception {
        /*
        //Verilen bir dizide en büyük ve en küçük elemanı bulan uygulama

        var dizi = new int[10];//Önce bir dizi tanımla
        var random = new Random();
        for(int i=0;i<dizi.length;i++)            
            dizi[i] = random.nextInt(50);

        for(var eleman:dizi)IO.print(eleman + " ");
        IO.println();

        var enBuyuk = dizi[0];//en büyük değişkeni tanımla
        for(int i=0;i<10;i++)//dizinin her elemanı için
            if(dizi[i]>enBuyuk)//Eğer sıradaki eleman en büyükten büyükse
                enBuyuk = dizi[i];//Artık en büyük sıradaki elemandır
        
        var enKucuk = dizi[0];
        for(var eleman:dizi)//dizinin her elemanı için
            if(eleman<enKucuk)//Eğer sıradaki eleman en küçükten küçükse
                enKucuk = eleman;//En küçük sıradaki elemandır
        //En büyük ve en küçük değerlerini ekrana yazdır
        IO.println(enKucuk);
        IO.print(enBuyuk);    
        IO.println();  
        
        for(int i=0;i<dizi.length;i++)
            for(int j=0;j<dizi.length;j++)
                if(dizi[i]<dizi[j])
                {
                    int temp = dizi[i];
                    dizi[i] = dizi[j];
                    dizi[j] = temp;
                }
        for(var eleman:dizi)IO.print(eleman + " ");
        IO.println();
        IO.println(dizi[0]);
        IO.println(dizi[dizi.length-1]);
    */    
   
   
        //Verilen bir stringde sesli harf sayısını bulan fonksiyon
        int sayac = 0;
        var text = IO.readln().toLowerCase(); //ekrandan bir string al
        var liste = List.of("a","e","ı","i","o","ö","u","ü"); //sesli harfleri bir listede tut        
        for(int i=0;i<text.length();i++){//metnin içerisindeki her karakter için
            var karakter =text.charAt(i);//sıradaki harf sesli harf listesinde var mı bak
            if(varMi(liste, karakter))sayac++; //Varsa sayacı bir arttır
        }
        IO.println(sayac);
    }
    public static boolean varMi(List<String> liste,char karakter){
        for(var eleman:liste){
            if(eleman.charAt(0) == karakter)
                return true;
        }
        return false;
    }
}