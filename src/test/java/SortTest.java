import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 * @author Siarhei Sviarkaltsau
 */

public class SortTest {

    private final MergeSorter sorter = new MergeSorter();

    @Test
    public void test() {
        test(new int[]{1, 2, 3, 4}, new int[]{1, 2, 3, 4});
    }

    private void test(final int[] unsorted, final int[] expectedSorted) {
        final String message = null;
        final int[] actualSorted = sorter.sort(unsorted);
        Assert.assertEquals(message, Arrays.toString(expectedSorted), Arrays.toString(actualSorted));
    }

}
