public class App {





    public static void main(String[] args) throws Exception {
        var karakter1 = new SWChar("Darth Vader");
        var karakter2 = SWChar.createCharWithNameAndLightsaber("Anakin Skywalker", "Blue");
        var karakter3 = new SWChar("Yoda","Light Side","Green","Dagobah",850);
        IO.println(karakter1);
        IO.println(karakter2);
        IO.println(karakter3);
        //IO.println(karakter1.charCount);
        IO.println(SWChar.charCount);
        //Math.pow(0, 0);
        //Math.PI;
        //Math m = new Math();
        //m.PI;
    }
}
