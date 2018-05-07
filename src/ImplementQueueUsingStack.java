import java.util.Stack;

class MyQueue {
	//Can be implemented using two stacks
	//Input Stack : push the incoming elements
	//Output Stack : used to pop/peek
	//Move elements from input to output stack when needed (when needed to peek/pop and output stack is empty)
	//When output stack is empty, move all elements from input to output stack and hence reversing the order
	
	Stack<Integer> inputStack = new Stack() ;
    Stack<Integer> outputStack = new Stack() ;
    
	/** Initialize your data structure here. */
    public MyQueue() {
    		
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
    		inputStack.push(x);
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
    		//Call peek to reverse the order of the element
        peek();
        return outputStack.pop();
    }
    
    /** Get the front element. */
    public int peek() {
        if(outputStack.isEmpty()) {
        		while(!inputStack.isEmpty()) {
        			outputStack.push(inputStack.pop());
        		}
        }
        return outputStack.peek();
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        return inputStack.isEmpty() && outputStack.isEmpty();
    }
}
