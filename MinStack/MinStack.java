package MinStack;

import java.util.PriorityQueue;
import java.util.Stack;

/**
 * Created by whong53 on 1/19/17.
 */
public class MinStack {

    PriorityQueue<Integer> queue;
    Stack<Integer> stack;

    /**
     * initialize your data structure here.
     */
    public MinStack() {
        this.queue = new PriorityQueue<Integer>();
        this.stack = new Stack<>();
    }

    public void push(int x) {
        queue.add(x);
        stack.push(x);
    }

    public void pop() {
        queue.remove(stack.peek());
        stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return queue.peek();
    }
}

class MinStack2 {

    long min;
    Stack<Long> stack;

    /**
     * initialize your data structure here.
     */
    public MinStack2() {
        this.stack = new Stack<>();
    }

    public void push(int x) {
        if (stack.isEmpty()) {
            stack.push(0L);
            this.min = x;
        } else {
            stack.push(x - min);
            if (x < min) {
                min = x;
            }
        }
    }

    public void pop() {
        if (stack.isEmpty()) {
            return;
        }
        long pop = stack.pop();
        if (pop < 0) {
            min = min - pop;
        }
    }

    public int top() {
        long top = stack.peek();
        if (top > 0) {
            return (int) (min + top);
        } else {
            return (int) min;
        }
    }

    public int getMin() {
        return (int) this.min;
    }
}
