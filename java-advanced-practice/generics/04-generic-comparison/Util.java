
public class Util {
    public static <K,V> boolean compare(Pair<K,V> p1, Pair<K,V> p2){
        if(p1.getKey().equals(p2.getKey()) &&
                p1.getValue().equals(p2.getValue())){
            return true;
        }
        return false;
    }
}
