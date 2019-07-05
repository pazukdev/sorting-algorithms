/**
 * @author Siarhei Sviarkaltsau
 */
public class BubbleSorter implements Sorter {

    @Override
    public int[] sort(final int[] array) {
        return bubbleSort(array);
    }

    /**
     * time complexity: O(n^2)
     * space complexity: O(n)
     */
    private int[] bubbleSort(final int[] array){
        boolean unsorted = array.length > 1;

        while (unsorted) {
            unsorted = false;
            for (int i = 1; i < array.length; i++) {
                final int current = array[i];
                final int previous = array[i - 1];

                if (current < previous) {
                    array[i] = previous;
                    array[i - 1] = current;
                    unsorted = true;
                }
            }
        }

        return array;
    }

}
