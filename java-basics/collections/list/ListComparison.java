package list;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ListComparison {
    public static void main(String[] args){
        List<String> names = new ArrayList<>();
        List<String> queue = new LinkedList<>();

        names.add("Sude");
        names.add("Berke");
        names.add("İklima");
        names.add("Rabia");
        names.add("Dicle");

        System.out.println(names);
        System.out.println("indexle bulunan : "+names.get(1));

        names.set(4,"Aysun"); // indexle değişim
        System.out.println("Güncellenmiş liste : "+ names);

        names.remove("Rabia"); // clear ise listedeki elemanların hepsini siler
        System.out.println("Güncellenmiş liste : "+ names);

        System.out.println("Aysun listede var mı? : " + names.contains("Aysun"));
        System.out.println("Dicle listede var mı? : " + names.contains("Dicle"));

        System.out.println("Aysun listede hangi indexte : "+ names.indexOf("Aysun"));
        System.out.println("Dicle listede hangi indexte : "+ names.indexOf("Dicle")); // Dicle listede yok -> -1

        names.add("Hatice");

        System.out.println("Listede kaç eleman var? : " + names.size());

        queue.add("Kiraz");
        queue.add("Muz");
        queue.add("Karpuz");
        queue.add("Elma");
        queue.add("Vişne");
        queue.add("Mango");

        System.out.println("Liste : " + queue );

        System.out.println("1.indexteki meyve : "+ queue.get(1));

        queue.set(3,"Üzüm");
        System.out.println("Güncellenmiş liste: "+ queue);

        queue.remove("Vişne");
        System.out.println("Yeni güncellenmiş liste: "+ queue);

        System.out.println("Listede üzüm var mı? : "+queue.contains("Üzüm"));
        System.out.println("Listede elma var mı? : "+queue.contains("Elma"));

        System.out.println("Mango listede kaçıncı indexte? : " + queue.indexOf("Mango"));
        System.out.println("Portakal listede kaçıncı indexte? : " + queue.indexOf("Portakal")); // -1


    }
}
