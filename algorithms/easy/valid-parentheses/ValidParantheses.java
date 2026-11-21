import java.util.Stack;

public class ValidParantheses {
    public static void main(String[] args){
        String text = "[{[]{}}]";
        String text2 = "([{}])";
        String text3 = "([)]";

        System.out.println(isValid(text));
        System.out.println(isValid(text2));
        System.out.println(isValid(text3));
    }
    static boolean isValid(String text){
        Stack<Character> stack = new Stack<>();

        if(text.length() % 2 != 0){
            return false;
        }
        for(Character c : text.toCharArray()){
            if(c.equals('[') || c.equals('{') || c.equals('(')){
                stack.push(c);
            }else{
                if(stack.isEmpty()){
                    return false;
                }
            }

            if(c.equals(')') && stack.peek().equals('(')){
                stack.pop();
            }
            else if(c.equals(']') && stack.peek().equals('[')){
                stack.pop();
            }
            else if(c.equals('}') && stack.peek().equals('{')){
                stack.pop();
            }
        }
        return stack.isEmpty();

    }
}
