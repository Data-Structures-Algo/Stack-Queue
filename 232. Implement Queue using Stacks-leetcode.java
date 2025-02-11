class MyQueue {
    Stack<Integer> s1;
    Stack<Integer> s2;
    public MyQueue() {
        s1 = new Stack<>();
        s2 = new Stack<>();
    }
    //push x element at the back of the queue
    public void push(int x) {
        //move all elements from s1 to s2
        while(!s1.isEmpty()){
            s2.push(s1.pop());
        }
        //push new elements in s1
        s1.push(x);
        //move all elements back to s1
        while(!s2.isEmpty()){
            s1.push(s2.pop());
        }
    }
    
    public int pop() {
        if(s1.isEmpty()){
            return -1;
        }
        return s1.pop();

    }
    
    public int peek() {
        if(s1.isEmpty()){
            return -1;
        }
        return s1.peek();
    }
    
    public boolean empty() {
        return s1.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
