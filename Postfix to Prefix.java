class Solution {
    static String postToPre(String post_exp) {
        // code here
        Stack<String> st = new Stack<>();
        
        for(int i=0;i<post_exp.length();i++){
            char ch = post_exp.charAt(i);
            
            if(Character.isLetterOrDigit(ch)){
                st.push(ch + "");
            }else{
                String op2 = st.pop();
                String op1 = st.pop();
                
                String exp = ch + op1 + op2;
                st.push(exp);
            }
        }
        return st.pop();
    }
}
