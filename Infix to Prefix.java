import java.util.ArrayList;
import java.util.Stack;

public class Stacks {
    private static int precedence(char c){
        return switch (c) {
            case '+', '-' -> 1;
            case '*', '/' -> 2;
            case '^' -> 3;
            default -> -1;
        };
    }
    public static String infixToPrefix(String infix){
        // Step-1 reverse the infix expression
        StringBuilder sb = new StringBuilder(infix).reverse();
        //Step-2 replace '(' with ')'
        for(int i=0;i<sb.length();i++){
            if(sb.charAt(i)=='('){
                sb.setCharAt(i, ')');
            }else if(sb.charAt(i)==')'){
                sb.setCharAt(i, '(');
            }
        }
        //Step-3 convert reversed infix to postfix
        String postfix = infixToPostfix(sb.toString());
        //Step-4 return reverse postfix
        return new StringBuilder(postfix).reverse().toString();
    }

    private static String infixToPostfix(String s) {
        StringBuilder result = new StringBuilder();
        Stack<Character> st = new Stack<>();

        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);

            if(Character.isLetterOrDigit(c)){
                result.append(c);
            }
            else if(c=='('){
                st.push(c);
            }else if(c==')'){
                while(!st.isEmpty() && st.peek() != '('){
                    result.append(st.pop());
                }
                st.pop();
            }
            else{
                while(!st.isEmpty() && precedence(st.peek()) >= precedence(c)){
                    result.append(st.pop());
                }
                st.push(c);
            }
        }
        while(!st.isEmpty()){
            result.append(st.pop());
        }
        return result.toString();
    }

    public static void main(String[] args) {
        String infix = "(A-B/C)*(A/K-L)";
        System.out.println("Prefix: " + infixToPrefix(infix));
    }
}
