class Solution {
    static String postToInfix(String exp) {
        // code here
        Stack<String> st = new Stack<>();
        
        for(int i=0;i<exp.length();i++){
            char ch = exp.charAt(i);
            //if Operand -> push it into stack
            if(Character.isLetterOrDigit(ch)){
                st.push(ch + ""); //convert char to String
            }
            else{
                //if operator -> pop two elements from stack
                String op2 = st.pop();
                String op1 = st.pop();
                //from new Expression
                String expression = "(" + op1 + ch + op2 + ")";
                //push into stack
                st.push(expression);
            }
        }
        //return result -> pop
        return st.pop();
    }
}
