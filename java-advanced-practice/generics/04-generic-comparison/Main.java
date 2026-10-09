
public class Main {
    public static void main(String[] args){

        Pair<Integer, String> p1 = new Pair<>(1, "Apple");
        Pair<Integer, String> p2 = new Pair<>(1, "Apple");
        Pair<Integer, String> p3 = new Pair<>(2, "Pear");

        boolean sonuc1 = Util.compare(p1,p2);
        boolean sonuc2 = Util.compare(p1,p3);

        System.out.println(sonuc1);
        System.out.println(sonuc2);

    }
}
