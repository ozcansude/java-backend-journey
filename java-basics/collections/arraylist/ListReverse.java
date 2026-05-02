package collections.arraylist;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class ListReverse {
    public static void main(String[] args){
        List<String> sehirler = new ArrayList<>();
        sehirler.add("İstanbul");
        sehirler.add("Kahramanmaraş");
        sehirler.add("Tekirdağ");
        sehirler.add("İzmir");
        System.out.println("Orijinal liste : " + sehirler);
        reverseMyList(sehirler);
        System.out.println("Ters çevrilmiş liste : " + sehirler);
    }
    public static void reverseMyList(List list){
        Collections.reverse(list);
    }
}
