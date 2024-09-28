import java.util.* ;
import java.io.*; 
import java.util.Queue;
import java.util.*;

public class Solution {
    public static void reverse(Queue<Integer> queue, int k){
        Stack<Integer>st=new Stack<>();// push the k ele in stack
        for(int i=0;i<k;i++){
            st.push(queue.remove()); 
        }
        for(int i=0;i<k;i++){
            queue.offer(st.pop()); //put back the element in stack
        }
        int count=queue.size()-k;
        for(int i=0;i<count;i++){
            queue.offer(queue.remove()); //rest elements of the queue to their initial postion
        }
    }
}
