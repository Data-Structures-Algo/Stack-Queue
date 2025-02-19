public class Solution {
    public int[] prevSmaller(int[] A) {
        Stack<Integer> stack = new Stack<>();
        int [] result = new int[A.length];
        int n = A.length;
        for(int i=0;i<n;i++){
            while(!stack.isEmpty() && stack.peek()>=A[i]){
                stack.pop();
            }
            result[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(A[i]);
        }
        return result;
    }
}
