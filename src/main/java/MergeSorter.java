/**
 * @author Siarhei Sviarkaltsau
 */
public class MergeSorter implements Sorter {

    @Override
    public int[] sort(int[] array) {
        return mergeSort(array);
    }

    private int[] mergeSort(int[] array) {

        if (array.length <= 1) { // nothing to divide
            return array;
        }

        final int midpoint = array.length / 2;

        int[] left = new int[midpoint];
        int[] right = new int[array.length - midpoint]; // as array can contain odd number of elements

        for (int i = 0; i < left.length; i++) {
            left[i] = array[i];
        }

        for (int j = 0; j < right.length; j++) {
            right[j] = array[midpoint + j];
        }

        left = mergeSort(left);
        right = mergeSort(right);

        return merge(left, right);
    }

    private int[] merge(final int[] left, final int[] right) {
        final int[] result = new int[left.length + right.length];

        int leftPointer = 0;
        int rightPointer = 0;
        int resultPointer = 0;

        while (leftPointer < left.length || rightPointer < right.length) {
            if (leftPointer < left.length && rightPointer < right.length) {
                if (left[leftPointer] < right[rightPointer]) {
                    result[resultPointer++] = left[leftPointer++];
                } else {
                    result[resultPointer++] = right[rightPointer++];
                }
            } else if (leftPointer < left.length) {
                result[resultPointer++] = left[leftPointer++];
            } else if (rightPointer < right.length) {
                result[resultPointer++] = right[rightPointer++];
            }
        }

        return result;
    }

}
