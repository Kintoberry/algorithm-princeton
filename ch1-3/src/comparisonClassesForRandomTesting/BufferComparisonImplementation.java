/**
 * Source: https://github.com/reneargento/algorithms-sedgewick-wayne/blob/master/src/chapter1/section3/Exercise44_TextEditorBuffer.java
 * I took this class from the above link. He claims that he managed to solve every problem in the book.
 * So I'm using his work to compare my work in randomized testing
 */

package comparisonClassesForRandomTesting;

public class BufferComparisonImplementation<Item> {

    private class Node {
        Item item;
        Node next;
    }

    private int sizeLeft;
    private int sizeRight;
    private Node firstLeftStack;
    private Node firstRightStack;

    public BufferComparisonImplementation() {
        sizeLeft = 0;
        sizeRight = 0;
        firstLeftStack = null;
        firstRightStack = null;
    }

    public void insert(Item item) {
        Node oldFirstLeft = firstLeftStack;
        firstLeftStack = new Node();
        firstLeftStack.item = item;
        firstLeftStack.next = oldFirstLeft;

        sizeLeft++;
    }

    private void insertOnRightStack(Item item) {
        Node oldFirstRight = firstRightStack;
        firstRightStack = new Node();
        firstRightStack.item = item;
        firstRightStack.next = oldFirstRight;

        sizeRight++;
    }

    public Item get() {
        if (sizeRight == 0) {
            return null;
        }

        return firstRightStack.item;
    }

    public Item delete() {
        if (sizeRight == 0) {
            return null;
        }

        Item item = firstRightStack.item;
        firstRightStack = firstRightStack.next;
        sizeRight--;

        return item;
    }

    public void left(int k) {
        int count = 0;

        while (count < k && sizeLeft > 0) {
            Item item = firstLeftStack.item;

            insertOnRightStack(item);

            firstLeftStack = firstLeftStack.next;
            sizeLeft--;

            count++;
        }
    }

    public void right(int k) {
        int count = 0;

        while (count < k && sizeRight > 0) {
            Item item = firstRightStack.item;

            insert(item);

            firstRightStack = firstRightStack.next;
            sizeRight--;

            count++;
        }
    }

    public int size() {
        return sizeLeft + sizeRight;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("Left Stack: ");
        for (Node current = firstLeftStack; current != null; current = current.next) {
            stringBuilder.append(current.item).append(" ");
        }

        stringBuilder.append("\nRight Stack: ");
        for (Node current = firstRightStack; current != null; current = current.next) {
            stringBuilder.append(current.item).append(" ");
        }

        return stringBuilder.toString();
    }

}