






public class KuyrukOld {
    private int[] dizi; 
    private int sayac;
    public KuyrukOld() {
        dizi = new int[10];
        sayac = 0;
    }
    public int ekle(int eklenecek) {
        if(sayac<10){
            dizi[sayac] = eklenecek;
            sayac++;
            return 1;
        }else
            return -1;
    }
    public int cikar() {
        if(sayac>0){
            int deger = dizi[0];
            for(int i=0;i<sayac;i++)
                dizi[i]=dizi[i+1];
            sayac--;
            return deger;
        }else
            return -1;        
    }
    public void yazdir() {
        for (int i = 0; i < sayac; i++)
            System.out.print(dizi[i]+" ");
        System.out.println();
    }
}
