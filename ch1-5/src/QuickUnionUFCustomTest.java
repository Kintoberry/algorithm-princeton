import edu.princeton.cs.algs4.QuickFindUF;
import edu.princeton.cs.algs4.QuickUnionUF;
import edu.princeton.cs.algs4.StdRandom;
import org.junit.Test;
import static org.junit.Assert.*;

public class QuickUnionUFCustomTest {
    @Test
    public void RandomizedTest() {
        int size = 100;
        UF myUF = new QuickUnionUFCustom(size);
        QuickUnionUF correctUF = new QuickUnionUF(size);

        int repeat = 100000;
        while (repeat-- > 0) {
            int operationNumber = StdRandom.uniform(0, 4);
            int randomIndexOne = StdRandom.uniform(0, 100);
            int randomIndexTwo = StdRandom.uniform(0, 100);
            switch (operationNumber) {
                case 0:
                    myUF.union(randomIndexOne, randomIndexTwo);
                    correctUF.union(randomIndexOne, randomIndexTwo);
                case 1:
                    assertEquals(correctUF.find(randomIndexOne), myUF.find(randomIndexOne));
                case 2:
                    assertEquals(correctUF.connected(randomIndexOne, randomIndexTwo), myUF.connected(randomIndexOne, randomIndexTwo));
                case 3:
                    assertEquals(correctUF.count(), myUF.count());
            }
        }
        System.out.println(myUF.count());
    }
}
