class MinStack {
    private Stack<Long> s;
    private long min;
    public MinStack() {
        s = new Stack<>();
    }
    
    public void push(int val) {
        if(s.isEmpty()){
            s.push((long)val);
            min = val;
        }else{
            if(val<min){
                s.push(2L * val - min);
                min = val;
            }else{
                s.push((long)val);
            }
        }
    }
    
    public void pop() {
        if(s.isEmpty()) return;
        long top = s.pop();
        if(top<min){
            min = 2 * min - top;
        }
    }
    
    public int top() {
        if(s.isEmpty()) return -1;
        long top = s.peek();
        return (top<min) ? (int) min : (int) top;
        
    }
    
    public int getMin() {
        return (int)min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */

 /*
Idea
Push(x):
If stack is empty, push x and set min to x.
If x is smaller than min, push a modified value instead of x:
Store 2 * x - min in the stack.
Update min = x.
The stored value acts as a marker for the previous min when popped.

Pop():
If the top element is less than the current min, it means it was encoded when push(x) was called.
Decode the previous min using:
min=2×current min−top element
Then, pop the top element.
getMin():

Always return min in O(1).
 */ 
