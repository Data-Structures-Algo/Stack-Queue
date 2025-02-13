class Solution {
    // Function to convert an infix expression to a postfix expression.
    public static String infixToPostfix(String s) {
        // Your code here
        StringBuilder result = new StringBuilder();
        Stack<Character> st = new Stack<>();
            
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            //if (A-Z or 0-9) then directly into result    
            if(Character.isLetterOrDigit(c)){
                result.append(c);
            }
            //if open bracket ( then push in stack
            else if(c=='('){
                st.push(c);
            }
            //if closed bracket ) then pop until stack -> empty and '(' is found
            else if(c==')'){
                while(!st.isEmpty() && st.peek() !='('){
                    result.append(st.pop());
                }
                st.pop();
            }
            //for operator
            else{
                //check precedence then add to output
                while(!st.isEmpty() && precedence(st.peek()) >= precedence(c)){
                    result.append(st.pop());
                }
                st.push(c); //if smaller then peek then push into stack
            }
        }
        //remaining 
        while(!st.isEmpty()){
            result.append(st.pop());
        }
        return result.toString();
        
    }
    private static int precedence(char ch){
        switch(ch){
            case '+' : case '-' : return 1;
            case '*' : case '/' : return 2;
            case '^' : return 3;
        }
        return -1;
    }
}
