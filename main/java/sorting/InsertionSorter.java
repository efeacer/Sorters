package sorting;

public class InsertionSorter extends Sorter {

    public void sort(int[] arr) {
        sort(arr, 0, arr.length);
    }

    void sort(int[] arr, int from, int to) {
        for (int i = from + 1; i < to; i++) {
            int key = arr[i];
            int j;
            for (j = i - 1; j != -1 && key < arr[j]; j--)
                arr[j + 1] = arr[j];
            arr[j + 1] = key;
        }
    }
}