package easy;
import java.util.LinkedList;
import java.util.Queue;

class MyStack {
	
	//Newly pushed element is always at the front of q1 and hence pop operation dequeues from q1
	Queue<Integer> q1 = new LinkedList<>();
	Queue<Integer> q2 = new LinkedList<>();
	int currentSize;
	
	/** Initialize your data structure here. */
    public MyStack() {
    		currentSize = 0;
    }
    
    /** Push element x onto stack. */
    public void push(int x) {
        //Make push operation costly
    		//Enqueue x to q2
    		//One by one dequeue all elements from q1 to q2
    		//Swap the names of q1 and q2
    		currentSize ++;
    		q2.add(x);
    		while(!q1.isEmpty()) {
    			q2.add(q1.remove());
    		}
    		//Swap the names
    		Queue<Integer> q = q1;
    		q1 = q2;
        q2 = q;
    }
    
    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        if(q1.isEmpty()) {
        		return -1;
        }
        currentSize --;
        return q1.remove();
    }
    
    /** Get the top element. */
    public int top() {
    		if(q1.isEmpty()) {
    			return -1;
    		}
    		return q1.peek();
    }
    
    /** Returns whether the stack is empty. */
    public boolean empty() {
        return q1.isEmpty();
    }
}
