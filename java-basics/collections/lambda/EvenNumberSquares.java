package lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class EvenNumberSquares {
    public static void main(String[] args){
        List<Integer> squareEvenNumbers = new ArrayList<>();
        List<Integer> numbers = List.of(2, 5, 8, 11, 4, 7);
        Predicate<Integer> isEven = number -> number % 2 == 0;
        Function<Integer,Integer> square = integer -> integer*integer;
        for(Integer number : numbers){
            if(isEven.test(number)){
                squareEvenNumbers.add(square.apply(number));
            }
        }
        System.out.println(squareEvenNumbers);
    }
}
