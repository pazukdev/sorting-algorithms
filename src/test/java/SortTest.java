import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 * @author Siarhei Sviarkaltsau
 */

public class SortTest {

    private Sorter sorter;

    @Test
    public void mergeSorterTest() {
        sorter = new MergeSorter();
        test();
    }

    public void test() {
        test(new int[]{0}, new int[]{0}); // length = 1
        test(new int[]{1, 2, 3, 4}, new int[]{1, 2, 3, 4}); // even, sorted
        test(new int[]{4, 2, 3, 1}, new int[]{1, 2, 3, 4}); // even, unsorted
        test(new int[]{1, 2, 3, 4, 5}, new int[]{1, 2, 3, 4, 5}); // odd, sorted
        test(new int[]{5, 4, 2, 3, 1}, new int[]{1, 2, 3, 4, 5}); // odd, unsorted
    }

    private void test(final int[] unsorted, final int[] expectedSorted) {
        final String message = null;
        final int[] actualSorted = sorter.sort(unsorted);
        Assert.assertEquals(message, Arrays.toString(expectedSorted), Arrays.toString(actualSorted));
    }

}
