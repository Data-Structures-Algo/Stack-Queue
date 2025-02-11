public class Queues {
    static class Node{
        int data;
        Node next;

        Node(int data){
            Node next=null;
            this.data=data;
        }
    }
    static class Queue {
        static Node head = null;
        static Node tail = null;

        public static boolean isEmpty(){
            return head==null && tail==null;
        }
        public static void add(int data){
            Node newnode = new Node(data);
            if(tail==null){
              head = tail = newnode;
              return;
            }
            tail.next=newnode;
            tail=newnode;
        }
        public static int remove(){
            if(head==null){
                return -1;
            }
            int result=head.data;
            head=head.next;
            if(head==tail){
                tail=null;
            }
            return result;
        }
        public static int peek(){
            return head.data;
        }


    }

    public static void main(String[] args) {
        Queue q = new Queue(); // Provide size

        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);

        while (!q.isEmpty()) {
            System.out.println(q.peek());
            q.remove();
        }
    }
}


//GFG question
class MyQueue
{
    QueueNode front, rear;
    
    //Function to push an element into the queue.
	void push(int a)
	{
        // Your code here
        QueueNode newnode = new QueueNode(a);
        if(rear==null){
            front=rear=newnode;
            return;
        }
        rear.next=newnode;
        rear=newnode;
	}
	
    //Function to pop front element from the queue.
	int pop()
	{
        // Your code here
        if(rear==null){
            return -1;
        }
        int result = front.data;
        front=front.next;
        if(front==null){
            rear=null;
        }
        return result;
	}
}
