package easy;
import java.util.Stack;

public class MinStack {

    /** initialize your data structure here. */
    
        int min = Integer.MAX_VALUE;
        Stack<Integer> stack=new Stack<>();
        
    public void push(int x) {
        if(x<=min){
        	//Store previous minimum value(If pushed value is minimum) as the second element on the stack 
        	//as when popped value is minimum previous minimum value can be retrieved
            stack.push(min);
            min=x;
        }
       stack.push(x);
    }
    
    public void pop() {
        if(stack.pop() == min) {
        	//If popped value is minimum retrieve the previous minimum value(from the stack)
            min=stack.pop();
        }	
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return min;
    }
}