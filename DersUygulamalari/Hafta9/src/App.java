class Sekil {
    public String turAl() {
        return "Şekil";
    }
}

class Dortgen extends Sekil {
    protected int birinciKenar;
    protected int ikinciKenar;
    protected int ucuncuKenar;
    protected int dorduncuKenar;

    public Dortgen(int birinciKenar, int ikinciKenar, int ucuncuKenar, int dorduncuKenar) {
        this.birinciKenar = birinciKenar;
        this.ikinciKenar = ikinciKenar;
        this.ucuncuKenar = ucuncuKenar;
        this.dorduncuKenar = dorduncuKenar;
    }

    public int cevreHesapla() {
        System.out.println("Burası baz sınıf");
        return birinciKenar + ikinciKenar + ucuncuKenar + dorduncuKenar;
    }
}

class Dikdortgen extends Dortgen {
    public Dikdortgen(int kisaKenar, int uzunKenar) {
        super(kisaKenar,kisaKenar,uzunKenar,uzunKenar);
    }
}

class Kare extends Dikdortgen {
    public Kare(int kenar) {
        super(kenar, kenar);
    }
}

class Daire extends Sekil {
    private int yaricap;

    public Daire(int yaricap) {
        this.yaricap = yaricap;
    }

    public double cevreHesapla() {
        return 2 * yaricap * Math.PI;
    }

    @Override
    public String turAl() {
        return "Köşeli olmayan bir şekil";
    }

    public void daireMetodu() {
        IO.println("Bu bir daire metodu");
    }
}

public class App {
    public static void turYazdir(Sekil s) {
        IO.println(s.turAl());
        if (s instanceof Daire) {
            ((Daire) s).daireMetodu();
        }
    }

    public static void main(String[] args) throws Exception {
        var dortgen = new Dortgen(3, 5, 4, 2);
        IO.println("Çevre: " + dortgen.cevreHesapla());
        var dikdortgen = new Dikdortgen(5, 10);
        IO.println("Çevre: " + dikdortgen.cevreHesapla());
        var kare = new Kare(5);
        IO.println("Çevre: " + kare.cevreHesapla());
        var daire = new Daire(3);
        IO.println("Çevre: " + daire.cevreHesapla());
        IO.println("---------------------");
        turYazdir(dortgen);
        turYazdir(dikdortgen);
        turYazdir(kare);
        turYazdir(daire);
    }
}