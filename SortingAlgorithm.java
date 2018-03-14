import java.util.Arrays;
import java.util.Random;

/**
 * Created by Pazuk on 09.03.2018.
 */
public class SortingAlgorithm {

    //static int[] array = {4, 0, 2, 10, 5, 7, 9, 8, 3, 1, 6};

    public static void main(String[] args) {

        //int[] array=randomArray(30);
        //int[] array = {6, 4, 0, 2, 10, 5, 6, 7, 9, 8, 3, 1, 6, 6, 6};
        int[] array={2, 1, 3, 4};
        System.out.println("Unsorted array:");
        System.out.println(Arrays.toString(array));

        // Select sort algorithm:
        bubbleSort(array);
        //bubbleSort1(array);
        //gnomeSort(array);
        //selectionSort(array);
        //insertionSort(array);
        //combSort(array);
        //quickSort(array);
        //quickSort2(array);
        //quickSort3Builtin(array);
        //mergeSort(array); // merge sort code is in developing...

    }

    static int[] randomArray(int arrayLength){
        int[] array=new int[arrayLength];
        Random random=new Random();
        for(int i=0; i<array.length; i++){
            array[i]=random.nextInt(100);
        }
        return array;
    }





    static void bubbleSort(int[] array){
        boolean isThereUnsortedElements=true;
        while (isThereUnsortedElements){
            isThereUnsortedElements=false;
            for(int i=1; i<array.length; i++){
                if(array[i-1]<array[i]){
                    int temp=array[i];
                    array[i]=array[i-1];
                    array[i-1]=temp;
                    isThereUnsortedElements=true;
                }
            }
        }
        System.out.println("Primitive Bubble sort without border of sorted part:");
        System.out.println(Arrays.toString(array));
    }

    static void bubbleSort1(int[] array){
        // Perfomance: O(n^2)
        for(int i=array.length; i>=0; i--){
            for(int j=1; j<i; j++){
                if(array[j-1]>array[j]){
                    int temp=array[j];
                    array[j]=array[j-1];
                    array[j-1]=temp;
                }
            }
        }
        System.out.println("Bubble sort with border of sorted part:");
        System.out.println(Arrays.toString(array));
    }

    static void gnomeSort(int[] array){
        // Perfomance: O(n^2)
        int i=1;
        while (i<array.length){
            if(i==0 || array[i]<=array[i-1]){
                i++;
            } else {
                int temp=array[i];
                array[i]=array[i-1];
                array[i-1]=temp;
                i--;
            }
        }
        System.out.println("Gnome sort:");
        System.out.println(Arrays.toString(array));
    }

    static  void selectionSort(int[] array){
        // Perfomance: O(n^2)
        for(int i=0; i<array.length; i++){
            for (int j=i; j<array.length; j++){
                if(array[j]<array[i]){
                    int temp=array[j];
                    array[j]=array[i];
                    array[i]=temp;

                }
            }
        }
        System.out.println("Selection sort:");
        System.out.println(Arrays.toString(array));
    }

    static void insertionSort(int[] array){
        // Perfomance: O{n^2)
        for(int i=1; i<array.length; i++){
            int key=array[i];
            int j=i-1;
            while (j>=0 && array[j]>key){
                array[j+1]=array[j];
                j--;
            }
            array[j+1]=key;
        }

        System.out.println("Insertion sort:");
        System.out.println(Arrays.toString(array));
    }

    static void combSort(int[] array){
        // Perfomance: O(n^2)
        int gap=array.length;
        boolean isThereUnsortedElements=true;
        while(gap>1 || isThereUnsortedElements){
            if(gap>1){
                gap=(int)(gap/1.247330950103979);
            }
            isThereUnsortedElements=false;
            int i=0;
            while (i+gap<array.length){
                if(array[i]>array[i+gap]){
                    int temp=array[i+gap];
                    array[i+gap]=array[i];
                    array[i]=temp;
                    isThereUnsortedElements=true;
                }
                i++;
            }
        }

        System.out.println("Comb sort:");
        System.out.println(Arrays.toString(array));
    }

    static void quickSort(int[] array){
        // Perfomance: O(n log(n))
        int low=0;
        int high=array.length-1;
        array=quickSortSort(array, low, high);

        System.out.println("Quick sort:");
        System.out.println(Arrays.toString(array));
    }

    static int[] quickSortSort(int[] array, int low, int high){

        int i=low;
        int j=high;
        int pivot=low-(low-high)/2;
        while(i<j){
            while(i<pivot && array[i]<=array[pivot]) i++;
            while(j>pivot && array[j]>=array[pivot]) j--;
            if(i<j){
                int temp=array[j];
                array[j]=array[i];
                array[i]=temp;

                if(i==pivot) pivot=j;
                else if(j==pivot) pivot=i;
            }
        }

        if(low<high){
            quickSortSort(array, low, pivot);
            quickSortSort(array, pivot+1, high);
        }

        return array;

    }

    static void quickSort2(int[] array){
        // Perfomance: O(n log(n))
        int low=0;
        int high=array.length-1;
        array=quickSort2Partition(array, low, high);

        System.out.println("Quick sort 2:");
        System.out.println(Arrays.toString(array));
    }

    static int[] quickSort2Partition(int[] array, int low, int high){

        int i=low;
        int j=low;
        int pivot=high;

        while(j<pivot){
            if(array[j]<array[pivot]){
                int temp=array[j];
                array[j]=array[i];
                array[i]=temp;
                i++;
            }
            j++;
        }
        int temp=array[i];
        array[i]=array[pivot];
        array[pivot]=temp;

        if(low<high){
            quickSortSort(array, low, i-1);
            quickSortSort(array, i+1, high);
        }

        return array;

    }

    static void quickSort3Builtin(int[] array){
        // Perfomance: O(n log(n))
        Arrays.sort(array);

        System.out.println("Quick sort 3, built-in:");
        System.out.println(Arrays.toString(array));
    }

    // end





















    // merge sort code is in developing...

    static void mergeSort(int[] array){
        int low=0;
        int high=array.length-1;
        //array=mergeSortAlgorithm(array, low, high);
        mergeSort3(array, low, high);

        System.out.println("Merge sort:");
        System.out.println(Arrays.toString(array));
    }

    static int[] mergeSortAlgorithm(int[] array, int low, int high){
        //if(low==high) return array;

        int mid=(low+high)/2;
        //System.out.println(array[mid]);
        mergeSortAlgorithm(array, low, mid);
        mergeSortAlgorithm(array, mid+1, high);
        merge(array, low, mid, high);

        return array;
    }

    static void merge(int[] array, int low, int mid, int high){
        int[] left=new int[mid-low+2];
        for(int i=low; i<=mid; i++){
            left[i-low]=array[i];
        }
        System.out.println("left: "+Arrays.toString(left));
        left[mid-low+1]=Integer.MAX_VALUE;
        System.out.println("left with MAX_VALUE: "+Arrays.toString(left));
        int[] right=new int[high-mid+1];
        for(int i=mid+1; i<=high; i++){
            right[i-mid-1]=array[i];
        }
        System.out.println("right: "+Arrays.toString(right));
        right[high-mid]=Integer.MAX_VALUE;
        System.out.println("right with MAX_VALUE: "+Arrays.toString(right));
        int i=0;
        int j=0;
        for(int k=low; k<=high; k++){
            if(left[i]<=right[j]){
                array[k]=left[i];
                i++;
            } else {
                array[k]=right[j];
                j++;
            }
        }

    }

    public static void mergeSort3(int[] array, int low, int high) {
        if (low + 1 < high) {
            int mid = (low + high)/2;
            //System.out.println("[mid]: "+mid);
            //System.out.println("mid: "+array[mid]);
            mergeSort3(array, low, mid);
            mergeSort3(array, mid, high);

            int size = high - low;
            System.out.println("size: "+size);
            int[] tempArray = new int[size];
            int i = low;
            int j = mid;
            for (int k = 0; k < size; k++) {
                if (j >= high || i < mid && array[i] < array[j]) {
                    tempArray[k] = array[i++];
                } else {
                    tempArray[k] = array[j++];
                }
            }
            System.arraycopy(tempArray, 0, array, low, size);
        }

        //System.out.println("Merge sort:");
        //System.out.println(Arrays.toString(array));

    }




}
