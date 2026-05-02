package collections.arraylist;
//iki listeyi bu listeleri bozmadan birleştir.

import java.util.ArrayList;
import java.util.List;

public class MergeTwoList {
    public static void main(String[] args){
        List<String> list1 = new ArrayList<>(List.of("dicle","cansu"));
        List<String> list2 = new ArrayList<>(List.of("Sude","İklima"));

        List<String> mergeList = new ArrayList();

        mergeList.addAll(list1);
        mergeList.addAll(list2);

        System.out.println(mergeList);

    }
}
