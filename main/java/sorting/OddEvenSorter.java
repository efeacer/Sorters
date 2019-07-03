package sorting;

public class OddEvenSorter extends Sorter {

    public void sort(int[] arr) {
        boolean swapped = true;
        while (swapped) {
            swapped = false;
            for (int i = 1; i < arr.length; i += 2)
                if (arr[i - 1] > arr[i]) {
                    swap(arr, i, i - 1);
                    swapped = true;
                }
            for (int i = 2; i < arr.length; i += 2)
                if (arr[i - 1] > arr[i]) {
                    swap(arr, i, i - 1);
                    swapped = true;
                }
        }
    }
}
