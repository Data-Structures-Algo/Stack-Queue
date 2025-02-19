class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> stack = new Stack<>();
        Map<Integer,Integer> ngeMap = new HashMap<>();

        for(int i=nums2.length-1;i>=0;i--){
            int current = nums2[i];
            // Pop elements smaller or equal to the current element
            while(!stack.isEmpty() && stack.peek()<=current){
                stack.pop();
            }
            // If stack isn't empty, top is the next greater element
            ngeMap.put(current, stack.isEmpty() ? -1 : stack.peek());
            stack.push(current); // Push current element
        }
        int [] result = new int[nums1.length];
        for(int i=0;i<nums1.length;i++){
            result[i] = ngeMap.get(nums1[i]);
        }
        return result;
    }
    
}
