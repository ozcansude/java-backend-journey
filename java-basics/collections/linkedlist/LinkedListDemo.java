package linkedlist;

import java.util.LinkedList;
import java.util.List;

//java.util.LinkedList<String> --> Burada Node, head ve next bağlantılarını yönetmeyiz. Java bunları içeride kendisi yönetir.
// SinglyLinkedList bunarı biz yazarız. addFirst, addLast ve displayList metotlarını yazdık.
public class LinkedListDemo {
    public static void main(String[] args){


        List<String> meyveler = new LinkedList<>();
        SinglyLinkedList list= new SinglyLinkedList();

        meyveler.add("Çilek");
        meyveler.add("Karpuz");
        meyveler.add("Kiraz");
        meyveler.add("Üzüm");

        meyveler.addFirst("Ayva");

        meyveler.addLast("Şeftali");

        System.out.println(meyveler);


        list.addLast("a");
        list.addLast("b");
        list.addLast("c");
        list.addLast("d");
        list.addFirst("x");

        list.displayList();

        System.out.println("Ters çevrilmeden önce:");
        list.displayList();
        System.out.println("---------------");
        list.reverse();

        System.out.println("Ters çevrildikten sonra:");
        list.displayList();


    }

}
