import java.util.Stack;
class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        if(s.length() % 2 != 0) 
            return false;

        for(char c : s.toCharArray()){
            if(c == '[' || c == '{' || c == '('){
                stack.push(c);
            }
            //Eğer kapanış paranteziyse kontrol edeeriz.
            else{
                if(stack.isEmpty()){
                    return false;
                }
                char top = stack.pop();

                if(c == ']' && top != '['){
                    return false;
                }
                if(c == ')' && top != '('){
                    return false;
                }
                if(c == '}' && top != '{'){
                    return false;
                }

            }
        }
        return stack.isEmpty();
    }
}
