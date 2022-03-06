import org.junit.Assert;
import org.junit.Test;

public class PercolationTest {
    @Test
    public void oneByOneTest() {
        Percolation p = new Percolation(1);
        Assert.assertEquals(false, p.isFull(1, 1));
        Assert.assertEquals(false, p.isOpen(1, 1));
        Assert.assertEquals(false, p.percolates());

        p.open(1, 1);
        Assert.assertEquals(true, p.isFull(1, 1));
        Assert.assertEquals(true, p.isOpen(1, 1));
        Assert.assertEquals(true, p.percolates());
    }
    @Test
    public void twoByTwoTest() {
        Percolation p = new Percolation(2);
        Assert.assertEquals(false, p.isFull(1, 1));
        Assert.assertEquals(false, p.isOpen(1, 1));
        Assert.assertEquals(false, p.percolates());

        p.open(1, 1);
        Assert.assertEquals(true, p.isFull(1, 1));
        Assert.assertEquals(true, p.isOpen(1, 1));
        Assert.assertEquals(false, p.percolates());

        p.open(2, 1);
        Assert.assertEquals(true, p.isFull(2, 1));
        Assert.assertEquals(true, p.isOpen(2, 1));
        Assert.assertEquals(true, p.percolates());

        p.open(2, 2);
        Assert.assertEquals(true, p.isFull(2, 2));
        Assert.assertEquals(true, p.isOpen(2, 2));
        Assert.assertEquals(true, p.percolates());

        Assert.assertEquals(false, p.isFull(1, 2));
        Assert.assertEquals(false, p.isOpen(1, 2));
        Assert.assertEquals(true, p.percolates());
    }

    @Test
    public void shouldNeverPercolateTest() {
        Percolation p = new Percolation(3);
        Assert.assertEquals(false, p.isFull(3, 1));
        Assert.assertEquals(false, p.isOpen(3, 1));
        Assert.assertEquals(false, p.percolates());

        p.open(3, 1);
        Assert.assertEquals(false, p.isFull(3, 1));
        Assert.assertEquals(true, p.isOpen(3, 1));
        Assert.assertEquals(false, p.percolates());

        p.open(3, 2);
        Assert.assertEquals(false, p.isFull(3, 2));
        Assert.assertEquals(true, p.isOpen(3, 2));
        Assert.assertEquals(false, p.percolates());

        p.open(2, 1);
        Assert.assertEquals(false, p.isFull(2, 1));
        Assert.assertEquals(true, p.isOpen(2, 1));
        Assert.assertEquals(false, p.percolates());

        p.open(2, 2);
        Assert.assertEquals(false, p.isFull(2, 2));
        Assert.assertEquals(true, p.isOpen(2, 2));
        Assert.assertEquals(false, p.percolates());

        p.open(2, 2);
        Assert.assertEquals(false, p.isFull(2, 2));
        Assert.assertEquals(true, p.isOpen(2, 2));
        Assert.assertEquals(false, p.percolates());

        p.open(3, 3);
        Assert.assertEquals(false, p.isFull(3, 3));
        Assert.assertTrue(p.isOpen(3, 3));
        Assert.assertFalse(p.percolates());

        p.open(2, 3);
        Assert.assertEquals(false, p.isFull(2, 3));
        Assert.assertEquals(true, p.isOpen(2, 3));
        Assert.assertEquals(false, p.percolates());
    }

    @Test
    public void perColatedLastTest() {
        Percolation p = new Percolation(3);
        Assert.assertEquals(false, p.isFull(1, 1));
        Assert.assertEquals(false, p.isOpen(1, 1));
        Assert.assertEquals(false, p.percolates());

        p.open(1, 1);
        Assert.assertEquals(true, p.isFull(1, 1));
        Assert.assertEquals(true, p.isOpen(1, 1));
        Assert.assertEquals(false, p.percolates());

        p.open(1, 2);
        Assert.assertEquals(true, p.isFull(1, 2));
        Assert.assertEquals(true, p.isOpen(1, 2));
        Assert.assertEquals(false, p.percolates());

        p.open(1, 3);
        Assert.assertEquals(true, p.isFull(1, 3));
        Assert.assertEquals(true, p.isOpen(1, 3));
        Assert.assertEquals(false, p.percolates());

        p.open(2, 1);
        Assert.assertEquals(true, p.isFull(2, 1));
        Assert.assertEquals(true, p.isOpen(2, 1));
        Assert.assertEquals(false, p.percolates());

        p.open(2, 2);
        Assert.assertEquals(true, p.isFull(2, 2));
        Assert.assertEquals(true, p.isOpen(2, 2));
        Assert.assertEquals(false, p.percolates());

        p.open(2, 3);
        Assert.assertEquals(true, p.isFull(2, 3));
        Assert.assertTrue(p.isOpen(2, 3));
        Assert.assertFalse(p.percolates());

        p.open(3, 2);
        Assert.assertEquals(true, p.isFull(3, 2));
        Assert.assertEquals(true, p.isOpen(3, 2));
        Assert.assertEquals(true, p.percolates());
    }


    @Test
    public void connectMiddleRowAndCheckIsFullTest() {
        Percolation p = new Percolation(3);

        p.open(2, 1);
        Assert.assertEquals(false, p.isFull(2, 1));
        Assert.assertEquals(true, p.isOpen(2, 1));
        Assert.assertEquals(false, p.percolates());

        p.open(2, 2);
        Assert.assertEquals(false, p.isFull(2, 2));
        Assert.assertEquals(true, p.isOpen(2, 2));
        Assert.assertEquals(false, p.percolates());

        p.open(2, 3);
        Assert.assertEquals(false, p.isFull(2, 3));
        Assert.assertTrue(p.isOpen(2, 3));
        Assert.assertFalse(p.percolates());

        p.open(1, 2);
        Assert.assertEquals(true, p.isFull(1, 2));
        Assert.assertEquals(true, p.isOpen(1, 2));
        Assert.assertEquals(false, p.percolates());

        Assert.assertEquals(true, p.isFull(2, 1));
        Assert.assertEquals(true, p.isFull(2, 2));
        Assert.assertEquals(true, p.isFull(2, 3));
    }

    @Test
    public void fourByFourTest() {
        Percolation p = new Percolation(4);
        Assert.assertEquals(false, p.isFull(1, 1));
        Assert.assertEquals(false, p.isOpen(1, 1));
        Assert.assertEquals(false, p.percolates());

        p.open(1, 1);
        Assert.assertEquals(true, p.isFull(1, 1));
        Assert.assertEquals(true, p.isOpen(1, 1));
        Assert.assertEquals(false, p.percolates());

        p.open(2, 1);
        Assert.assertEquals(true, p.isFull(2, 1));
        Assert.assertEquals(true, p.isOpen(2, 1));
        Assert.assertEquals(false, p.percolates());

        p.open(2, 2);
        Assert.assertEquals(true, p.isFull(2, 2));
        Assert.assertEquals(true, p.isOpen(2, 2));
        Assert.assertEquals(false, p.percolates());

        p.open(3, 3);
        Assert.assertEquals(false, p.isFull(3, 3));
        Assert.assertEquals(true, p.isOpen(3, 3));
        Assert.assertEquals(false, p.percolates());

        p.open(4, 3);
        Assert.assertEquals(false, p.isFull(4, 3));
        Assert.assertEquals(true, p.isOpen(4, 3));
        Assert.assertEquals(false, p.percolates());

        p.open(3, 2);
        Assert.assertEquals(true, p.isFull(3, 2));
        Assert.assertEquals(true, p.isOpen(3, 2));
        Assert.assertEquals(true, p.percolates());

        p.open(1, 4);
        Assert.assertEquals(true, p.isFull(1, 4));
        Assert.assertEquals(true, p.isOpen(1, 4));
        Assert.assertEquals(true, p.percolates());

        Assert.assertEquals(false, p.isFull(3, 4));
        Assert.assertEquals(false, p.isOpen(3, 4));

        p.open(1, 3);
        Assert.assertEquals(true, p.isFull(1, 3));
        Assert.assertEquals(true, p.isOpen(1, 3));
        Assert.assertEquals(true, p.percolates());
    }
}
