package collections.arraylist;

import java.util.ArrayList;

public class FindMaxInArrayList {
    public static void main(String[] args){
        ArrayList<Integer> list = new ArrayList<>();
        // önce boş olan list'e elemanları ekledim.
        list.add(34);
        list.add(90);
        list.add(57);
        list.add(70);
        list.add(23);
        list.add(59);

        //şimdi burdaki max'ı bulacağım.
        //referans seçerim ilk indextekini.
        int max = list.get(0);
        for(int i = 0; i < list.size(); i++){
               if(list.get(i) > max){
                   max = list.get(i);
               }
        }
        System.out.println("Max value in this list : "+ max);
    }
}
