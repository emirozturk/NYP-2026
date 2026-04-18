class KarmasikSayi{
    private double gercel;
    private double sanal;
    public KarmasikSayi(double gercel,double sanal){
        this.gercel=gercel;
        this.sanal=sanal;
    }
    public double getGercel(){
        return this.gercel;
    }
    public double getSanal(){
        return this.sanal;
    }
    @Override
    public String toString(){
        return this.getGercel()+" + "+this.getSanal()+"i";
    }
}
class Islemler{
    public static double topla(double a,double b){
        return a+b;
    }
    public static double topla(double[] dizi){
        double toplam=0;
        for (double eleman:dizi){
            toplam+=eleman;
        }
        return toplam;
    }
    public static KarmasikSayi topla(KarmasikSayi a,KarmasikSayi b){
        return new KarmasikSayi(a.getGercel()+b.getGercel(),a.getSanal()+b.getSanal());
    }
}

public class Main {
    public static void main() {
        IO.println(Islemler.topla(3,4));
        double[] s={3.5,0.4};
        IO.println(Islemler.topla(s));
        KarmasikSayi k1=new KarmasikSayi(1,2);
        IO.print(
                Islemler.topla(k1, new KarmasikSayi(3.2, 4.2))
        );


    }

}