public class App {
    public static void main(String[] args) throws Exception {
        var ahmet = new Kisi("Ahmet",19);
        var emir = new Kisi("Emir",45);
        IO.println(ahmet);
        IO.println(emir);   
        IO.println(ahmet.buyukMu(emir));
    }
}