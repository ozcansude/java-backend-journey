
public class GenericMaxFinder {

    public static <T extends Comparable<T>> T findMax(T[] tComparable){

        if(tComparable.length > 0){
            T max = tComparable[0];
            for(T t : tComparable){
                if(t.compareTo(max) > 0){
                    max = t;
                }
            }
            return max;
        }
        throw new IllegalArgumentException();
    }
}
