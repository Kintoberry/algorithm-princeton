import org.junit.Assert;
import org.junit.Test;

public class ConverterTest {
    @Test
    public void fourByFourTest() {
        Converter converter = new Converter(4);
        Assert.assertEquals(1, converter.fromGridToLinear(1, 1));
        Assert.assertEquals(16, converter.fromGridToLinear(4, 4));

        Assert.assertEquals(7, (int) converter.fromGridToLinearEastSite(2, 2));
        Assert.assertEquals(5, (int) converter.fromGridToLinearWestSite(2, 2));
        Assert.assertEquals(2, (int) converter.fromGridToLinearNorthSite(2, 2));
        Assert.assertEquals(10, (int) converter.fromGridToLinearSouthSite(2, 2));

        Assert.assertEquals(10, (int) converter.fromGridToLinearEastSite(3, 1));
        Assert.assertEquals(null, converter.fromGridToLinearWestSite(3, 1));
        Assert.assertEquals(5, (int) converter.fromGridToLinearNorthSite(3, 1));
        Assert.assertEquals(13, (int) converter.fromGridToLinearSouthSite(3, 1));
    }
}
