interface Kaydedilebilir{
    void kaydet();
    void rollback();
}




class DosyaIslem implements Kaydedilebilir{
    public void kaydet(){
        IO.println("Dosyaya kaydedildi");
    }

    @Override
    public void rollback() {
    }
}
class VeritabaniIslem implements Kaydedilebilir{
    public void kaydet(){
        IO.println("Veritabanına kaydedildi");
    }

    @Override
    public void rollback() {
    }
}
class NoSQLDbIslem implements Kaydedilebilir{

    @Override
    public void kaydet() {
        IO.println("NoSQL veritabanına kaydedildi");
    }

    @Override
    public void rollback() {
    }
}
class Sinif{
    Kaydedilebilir kaydedilebilir;
    public Sinif(Kaydedilebilir kaydedilebilir){
        this.kaydedilebilir = kaydedilebilir;
    }
    Kaydedilebilir getKaydedilebilir(){
        return kaydedilebilir;
    }
}

public class App {
    public static void kaydet(Kaydedilebilir kaydedilebilir){
        kaydedilebilir.kaydet();
        kaydedilebilir.rollback();
    }
    public static void main(String[] args) throws Exception {
        DosyaIslem di = new DosyaIslem();
        VeritabaniIslem vi = new VeritabaniIslem();
        NoSQLDbIslem ni = new NoSQLDbIslem();
        Sinif sinif = new Sinif(ni);
        kaydet(sinif.getKaydedilebilir());
    }
}
