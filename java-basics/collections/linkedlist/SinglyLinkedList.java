package linkedlist;

public class SinglyLinkedList {
     Node head;
     int size = 0;

    public void addFirst(String data){
        Node n1 = new Node(data);
        n1.next = head;
        head = n1;
        size++;
    }

    public void addLast(String data){
        Node n2 = new Node(data);
        Node current;

        if(head == null){
            head = n2;
            size++;
            return;
        }

        current = head;
        while(current.next!=null){
            current = current.next;
            // current.next = n2;
            size++;
        }
        current.next = n2;
    }

    public void displayList(){ // mantığı addLAstteki gibi aynı yol, yazarken de println ile yazdırırız.
        Node current = head;
        if(head == null){
            System.out.println( current.getData() );
            size++;
        }

        while(current != null){
            System.out.println(current.getData() + " ");
            current = current.next;
        }
    }

    /*
    public void reverse()

metodunu aç ve bu beş hareketi while döngüsüne çevirmeye çalış. Sonra LinkedListDemo içinde:

önce displayList
reverse                               list      :       [a] -> [b] -> [c] -> [d]
sonra displayList

şeklinde test et.

başlangıç durumu :
prev : null
current : head
next : tanımlanmadı
     */

    public void reverse(){
        Node previous = null;
        Node current = head; // bu da a olmuş oluyo
        Node next;

        while(current != null){
             next = current.next;
             current.next = previous;
             previous = current;
             current = next;
        }
        head = previous;

    }







}
