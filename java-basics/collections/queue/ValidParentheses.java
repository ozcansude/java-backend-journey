package queue;

import java.util.ArrayDeque;
import java.util.Deque;

// {}[]() , ({[]}) LŞEKLİNDE İFADELER
public class ValidParentheses {
    public static boolean isValid(String text) {
        Deque<Character> deque = new ArrayDeque<>();
        for(char c: text.toCharArray()){
            if(c == '(' || c == '{' || c == '['){
                deque.push(c);
            }
            if(c == ')' || c == '}' || c == ']'){
                if(deque.size() == 0){
                    return false;
                }
                char opening = deque.pop();

                if(c == ')' && opening != '('){
                    return false;
                }
                if(c == '}' && opening != '{'){
                    return false;
                }
                if(c == ']' && opening != '['){
                    return false;
                }

            }
        }

        return deque.isEmpty();
    }
}
