package collections.arraylist;

import java.util.ArrayList;

public class RemoveDuplicate {
    public static void main(String[] args){
        ArrayList<String> fruits = new ArrayList<>();
        fruits.add("Erik");
        fruits.add("Muz");
        fruits.add("Çilek");
        fruits.add("Karpuz");
        fruits.add("Erik");
        fruits.add("Çilek");

        // burada bi referans seçelim ama referans harici tekrar eden de olabilir
        // bu yüzden seçtiğimiz referansta değişecek yani iç içe döngü yaparsam
        // dışardaki döngünün verdiğiyle içerdeki döngüdekini karşılaştırıp aynıysa tekrar edeni silerim.
        for(int i = 0 ; i < fruits.size(); i++){
            for(int j = i+1; j < fruits.size(); j++){
                if(fruits.get(i).equals(fruits.get(j))){
                    fruits.remove(j);
                    j--;
                }
            }
        }
        System.out.println(fruits); //[Erik, Muz, Çilek, Karpuz]

    }
}
