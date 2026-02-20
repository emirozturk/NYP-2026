import java.util.Scanner;


    public static double alan(double r){
        return 3.14*r*r;
    }
    public static double cevre(double r){
        return 2*3.14*r;
    }
    void main(String[] args) {
        Scanner ekran= new Scanner(System.in);
        System.out.print("Yarıçap:");
        double r=ekran.nextDouble();
        System.out.println("Alan="+alan(r)+"\n"+"Cevre:"+cevre(r));

}