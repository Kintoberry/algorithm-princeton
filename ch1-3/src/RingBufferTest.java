import org.junit.Test;

import static org.junit.Assert.*;

public class RingBufferTest {
    @Test
    public void sizeOneTest() {
        RingBuffer<Integer> buffer = new RingBuffer<>();
        assertTrue(buffer.isEmpty());
        assertFalse(buffer.isFull());
        assertNull(buffer.dequeue());
        assertTrue(buffer.enqueue(1));
        assertFalse(buffer.isEmpty());
        assertEquals(new Integer(1), buffer.dequeue());
        assertTrue(buffer.isEmpty());
    }

    @Test
    public void circularIndexTest() {
        RingBuffer<Integer> buffer = new RingBuffer<>(4);

        assertTrue(buffer.enqueue(1));
        assertTrue(buffer.enqueue(2));
        assertTrue(buffer.enqueue(3));
        assertTrue(buffer.enqueue(4));
        assertTrue(buffer.isFull());
        assertEquals(new Integer(1), buffer.dequeue());
        assertEquals(new Integer(2), buffer.dequeue());
        assertFalse(buffer.isEmpty());
        assertTrue(buffer.enqueue(5));
        assertTrue(buffer.enqueue(6));
        assertTrue(buffer.isFull());
        assertEquals(new Integer(3), buffer.dequeue());
        assertEquals(new Integer(4), buffer.dequeue());
        assertEquals(new Integer(5), buffer.dequeue());
        assertEquals(new Integer(6), buffer.dequeue());
        assertTrue(buffer.isEmpty());
        assertFalse(buffer.isFull());
    }
}
