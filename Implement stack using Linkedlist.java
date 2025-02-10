public class Stacks {
    static class Node{
        int val ;
        Node head;
        Node next;
        public Node(int val){
            this.val = val;
            next = null;
        }
    }
    public static class Stack{
        public static Node head;
        public static boolean isEmpty(){
            return head==null;
        }
        public static void push(int val){
            Node newNode = new Node(val);
            if(isEmpty()) {
                head = newNode;
                return;
            }
            newNode.next=head;
            head=newNode;
        }
        public static int pop(){
            if(isEmpty()){
                return -1;
            }
            int top = head.val;
            head=head.next;
            return top;
        }
        public static int peek(){
            if(isEmpty()){
                return -1;
            }
            return head.val;
        }



    }

    public static void main(String[] args) {
            Stack s = new Stack();
            s.push(1);
            s.push(2);
            s.push(3);
            s.push(4);

            while(!s.isEmpty()){
                System.out.println(s.peek());
                s.pop();
            }

    }
}
