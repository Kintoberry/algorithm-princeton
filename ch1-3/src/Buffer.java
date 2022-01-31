/*
Solution to Exercise 1.3.44
Author: Kinto
 */
import edu.princeton.cs.algs4.Stack;
public class Buffer {
    Stack<Character> leftStack, rightStack;
    public Buffer() {
        leftStack = new Stack<>();
        rightStack = new Stack<>();
    }
    public void insert(char c) {
        rightStack.push(c);
    }
    public char delete() {
        if (leftStack.isEmpty())
            return rightStack.pop();
        else
            return leftStack.pop();
    }
    public void left(int k) {
        while (k-- > 0 && !rightStack.isEmpty()) {
            leftStack.push(rightStack.pop());
        }
    }
    public void right (int k) {
        while (k-- > 0 && !leftStack.isEmpty()) {
            rightStack.push(leftStack.pop());
        }
    }
    public int size() {
        return leftStack.size() + rightStack.size();
    }

    public char get() {
        if (leftStack.isEmpty())
            return rightStack.peek();
        else
            return leftStack.peek();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(this.size());
        while (!rightStack.isEmpty()) {
            leftStack.push(rightStack.pop());
        }
        while (!leftStack.isEmpty())
            sb.append(leftStack.pop());
        return sb.toString();
    }
    public void printBuffer() {
        while (!rightStack.isEmpty()) {
            leftStack.push(rightStack.pop());
        }
        while (!leftStack.isEmpty())
            System.out.print(leftStack.pop());
    }
}
