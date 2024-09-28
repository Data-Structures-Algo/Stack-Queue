//top interview 150
class Solution {
    public boolean isSubsequence(String s, String t) {
        int i=0;
        int j=0;

        while(i<s.length()&& j<t.length()){ // i checks at s & j checks at j if matches then i increments
            if(s.charAt(i)==t.charAt(j)){
                i++;

            }
            j++;  //if not match then j increment
        }
        return i==s.length(); // return if i==s.length()
    }
}
