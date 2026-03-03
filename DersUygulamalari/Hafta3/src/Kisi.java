public class Kisi{
    private String ad;
    private int yas;
    public String getAd(){return ad;}
    public int getYas(){return yas;}
    public String toString(){return ad + "-" + yas;}
    public boolean buyukMu(Kisi oteki){return yas>oteki.yas;}
    public Kisi(String ad, int yas){
        this.ad = ad;
        this.yas = yas;
    }
}