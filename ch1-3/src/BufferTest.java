import comparisonClassesForRandomTesting.BufferComparisonImplementation;
import edu.princeton.cs.algs4.StdRandom;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BufferTest {
    @Test
    public void insertTest() {
        String str = "Hi, I'm Hansu.";
        Buffer buffer = new Buffer();
        for (int i = 0; i < str.length(); i++) {
            buffer.insert(str.charAt(i));
        }
        assertEquals(str, buffer.toString());
    }

    @Test
    public void testSize() {
        String str = "This is the next generation technology";
        Buffer buffer = new Buffer();
        for (int i = 0; i < str.length(); i++) {
            buffer.insert(str.charAt(i));
        }
        assertEquals(str.length(), buffer.size());
        buffer.left(10);
        assertEquals(str.length(), buffer.size());
        buffer.insert(' ');
        buffer.insert('s');
        buffer.insert('o');
        buffer.insert('i');
        buffer.insert('l');
        buffer.insert(' ');
        assertEquals(str.length()+6, buffer.size());
    }

    @Test
    public void testLeftRight() {
        String str = "Happy birther to you~ Y Kameneva";
        Buffer buffer = new Buffer();
        for (int i = 0; i < str.length(); i++) {
            buffer.insert(str.charAt(i));
        }
        buffer.left(20);
        assertEquals('r', buffer.delete());
        buffer.left(1);
        assertEquals('e', buffer.delete());
        buffer.insert('d');
        buffer.insert('a');
        buffer.insert(('y'));

        buffer.right(10);
        buffer.insert('u');
        buffer.insert('l');
        buffer.insert('i');
        buffer.insert('a');

        assertEquals("Happy birthday to you~ Yulia Kameneva", buffer.toString());
    }

    @Test
    public void RandomizedTesting() {
        Buffer myBuffer = new Buffer();
        BufferComparisonImplementation<Character> otherBuffer = new BufferComparisonImplementation<>();
        int repeat = 100000;
        while (repeat-- > 0) {
            int operation = StdRandom.uniform(0, 7);
            switch (operation) {
                case 0: // test insert()
                    char ascii = (char) StdRandom.uniform(32, 127);
                    myBuffer.insert(ascii);
                    otherBuffer.insert(ascii);
                    break;
                case 1: // test delete()
                    if (myBuffer.size() == 0 || otherBuffer.size() == 0)
                        break;
                    Character other = otherBuffer.delete();
                    if (other == null) {
                        break;
                    }
                    char other2 = (char) other;
                    char my = myBuffer.delete();
                    assertEquals(other2, my);
                    break;
                case 2: // test left()
                    int nextCursorToLeft = StdRandom.uniform(0, Math.max(myBuffer.size(), 1));
                    myBuffer.left(nextCursorToLeft);
                    otherBuffer.left(nextCursorToLeft);
                    break;
                case 3:
                    int nextCursorToRight =  StdRandom.uniform(0, Math.max(myBuffer.size(), 1));
                    myBuffer.right(nextCursorToRight);
                    otherBuffer.right(nextCursorToRight);
                    break;
                case 4:
                    assertEquals(otherBuffer.size(), myBuffer.size());
                    break;
                case 5:
                    if (myBuffer.size() == 0 && otherBuffer.size() == 0)
                        break;
                    Character temp = otherBuffer.get();
                    if (temp == null) {
                        break;
                    }
                    char otherChar = (char) temp;
                    assertEquals(otherChar, myBuffer.get());
                    System.out.println("other: " + otherChar + ", my: " + myBuffer.get());
            }
        }
    }
}
