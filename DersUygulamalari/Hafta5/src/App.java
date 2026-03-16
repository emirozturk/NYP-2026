






public class App {
    public static void main(String[] args) throws Exception {
        var kuyruk = new Kuyruk();
        kuyruk.ekle(5);
        kuyruk.yazdir();
        kuyruk.ekle(10);
        kuyruk.yazdir();
        kuyruk.ekle(7);
        kuyruk.yazdir();
        var eleman = kuyruk.cikar();
        IO.println("Çıkan:"+eleman);
        kuyruk.yazdir();
        var eleman2 = kuyruk.cikar();
        IO.println("Çıkan:"+eleman2);
        kuyruk.yazdir();
        kuyruk.ekle(13);
        kuyruk.yazdir();
    }
}
