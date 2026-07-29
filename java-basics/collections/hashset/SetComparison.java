package hashset;

import java.util.*;


public class SetComparison {
    public static void main(String[] args) {

        testHashSet();
        testLinkedHashSet();
        testTreeSet();

    }


    private static void testHashSet() {
        Set<Integer> hash = new HashSet<>();


        hash.add(31);
        hash.add(15);
        hash.add(7);
        hash.add(34);
        hash.add(15);
        hash.add(5);
        hash.add(31);

        System.out.println("HashSet : " + hash);
        System.out.println("Eleman sayısı : " + hash.size());

        System.out.println("---------------------");
        System.out.println("forEach ile dolaşmak: ");
        hash.forEach(sayi  -> System.out.println(sayi));

        System.out.println("---------------------");
        System.out.println("Enhanced for ile dolaşmak: ");
        for(Integer sayi : hash){
            System.out.println(sayi);
        }

        System.out.println("---------------------");
        Iterator<Integer> iterator = hash.iterator();
        // Set hazırlandıktan sonra iterator oluşturmak daha güvenlidir.
        // Iterator oluşturulduktan sonra set üzerinde doğrudan yapısal değişiklik yapılmamalıdır. !!! add() ,remove()...

        System.out.println("Iterator ile dolaşmak : ");
        while (iterator.hasNext()){
            int sayi = iterator.next();
            System.out.println(sayi);
        }
        System.out.println("---------------------");


    }

    private static void testLinkedHashSet() {
        Set<Integer> linked = new LinkedHashSet<>();

        linked.add(31);
        linked.add(15);
        linked.add(7);
        linked.add(34);
        linked.add(15);
        linked.add(5);
        linked.add(31);

        System.out.println("LinkedHashSet : " + linked);
        System.out.println("Eleman sayısı : " + linked.size());
        System.out.println("---------------------");

        System.out.println("forEach ile dolaşmak: : ");
        linked.forEach(sayi -> System.out.println(sayi));

        System.out.println("---------------------- ");
        System.out.println("Enhanced for ile dolaşmak : ");
        for(Integer sayi : linked){
            System.out.println(sayi);
        }
        System.out.println("---------------------");

        System.out.println("Iterator ile dolaşmak : ");

        Iterator<Integer> iterator = linked.iterator();
        while(iterator.hasNext()){
            int sayi = iterator.next();
            System.out.println(sayi);
        }
        System.out.println("---------------------");



    }

    private static void testTreeSet() {
        Set<Integer> tree = new TreeSet<>();

        tree.add(31);
        tree.add(15);
        tree.add(7);
        tree.add(34);
        tree.add(15);
        tree.add(5);
        tree.add(31);

        System.out.println("TreeSet : " + tree);
        System.out.println("Eleman sayısı : " + tree.size());
        System.out.println("---------------------");

        System.out.println("forEach ile dolaşmak: : ");
        tree.forEach(sayi -> System.out.println(sayi));


        System.out.println("---------------------");
        System.out.println("Enhanced for ile dolaşmak: : ");
        for(Integer sayi : tree){
            System.out.println(sayi);
        }
        System.out.println("---------------------");

        System.out.println("Iterator ile dolaşmak : ");
        Iterator<Integer> iterator = tree.iterator();

        while(iterator.hasNext()){
            int sayi = iterator.next();
            System.out.println(sayi);
        }


    }
}