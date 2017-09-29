package features.lambda;

public class Rekrutacja {
    static {
        x =1;
    }
    static int x, y;
    Rekrutacja() {
        int wynik = x++ + ++x;
        System.out.println(wynik);
    }
    public static void main(String[] args){
    new Rekrutacja();
    }
}
