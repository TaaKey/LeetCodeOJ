package ImplementQueueUsingStacks;

import java.util.Stack;

/**
 * Created by Wentao on 1/15/2017.
 */
public class MyQueue {

    Stack<Integer> stack = new Stack<>();

    // Push element x to the back of queue.
    public void push(int x) {
        Stack<Integer> tmp = new Stack<>();
        while (!stack.isEmpty()) {
            tmp.push(stack.pop());
        }
        tmp.push(x);
        while (!tmp.isEmpty()) {
            stack.push(tmp.pop());
        }
    }

    // Removes the element from in front of queue.
    public void pop() {
        stack.pop();
    }

    // Get the front element.
    public int peek() {
        return stack.peek();
    }

    // Return whether the queue is empty.
    public boolean empty() {
        return stack.isEmpty();
    }
}
