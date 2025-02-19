public class Queues {
    static class Queue {
        int arr[];
        int size;
        int rear;

        // Constructor
        public Queue(int n) {
            arr = new int[n];
            this.size = n;
            this.rear = -1;
        }

        public boolean isEmpty() {
            return rear == -1;
        }

        // Enqueue O(1)
        public void add(int data) {
            if (rear == size - 1) {
                System.out.println("Full Queue");
                return;
            }
            rear++;
            arr[rear] = data;
        }

        // Dequeue O(n)
        public int remove() {
            if (isEmpty()) {
                System.out.println("Queue is Empty");
                return -1;
            }
            int front = arr[0]; // Front points to the first element of the array
            for (int i = 0; i < rear; i++) {
                arr[i] = arr[i + 1]; // Shift elements to the left
            }
            rear--; // Reduce rear index
            return front;
        }

        public int peek() {
            if (isEmpty()) {
                System.out.println("Empty Queue");
                return -1;
            }
            return arr[0];
        }
    }

    public static void main(String[] args) {
        Queue q = new Queue(5); // Provide size

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


// GFG Question
class MyQueue {

    int front, rear;
	int arr[] = new int[100005];

    MyQueue()
	{
		front=0;
		rear=0;
	}
	
	//Function to push an element x in a queue.
	void push(int x)
	{
	    // Your code here
	    if(rear==arr.length){
	        return ;
	    }
	    
	    arr[rear]=x;
	    rear++;
	} 

    //Function to pop an element from queue and return that element.
	int pop()
	{
		// Your code here
		if(front ==rear){
		    return -1;
		}
		int result = arr[front];
		front++;
		return result;
	} 
}
