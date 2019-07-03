package sorting;

public class StoogeSorter extends Sorter {

    public void sort(int[] arr) {
        stoogeSort(arr, 0, arr.length);
    }

    private void stoogeSort(int[] arr, int from, int to) {
        if (from + 1 >= to)
            return;
        if (arr[from] > arr[to - 1])
            swap(arr, from, to - 1);
        if (to - from > 2) {
            int k = (to - from) / 3;
            stoogeSort(arr, from, to - k);
            stoogeSort(arr, from + k, to);
            stoogeSort(arr, from, to - k);
        }
    }
}