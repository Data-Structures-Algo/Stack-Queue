class Solution {
    static String preToInfix(String pre_exp) {
        // code here
        Stack<String> st = new Stack<>();
        
        for(int i=pre_exp.length()-1;i>=0;i--){
            char ch = pre_exp.charAt(i);
            //if operand push into stack
            if(Character.isLetterOrDigit(ch)){
                st.push(ch + ""); //convert char to string
            }else{ 
                //if operator pop two elements from stack
                String op1 = st.pop();
                String op2 = st.pop();
                //form expression
                String expression = "(" + op1 + ch + op2 + ")";
                //push -> stack
                st.push(expression);
            }
        }
        //pop <- stack
        return st.pop();
    }
}
