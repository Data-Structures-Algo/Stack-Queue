class Solution {
    static String preToPost(String pre_exp) {
        // code here
        Stack<String> st = new Stack<>();
        
        for(int i=pre_exp.length()-1;i>=0;i--){
            char ch = pre_exp.charAt(i);
            
            if(Character.isLetterOrDigit(ch)){
                st.push(ch+"");
            }else{
                String op1 = st.pop();
                String op2 = st.pop();
                String exp = op1 + op2 + ch;
                st.push(exp);
            }
        }
        return st.pop();
    }
}
