package sorting;

public class QuickSorter extends Sorter {

    public void sort(int[] arr) {
        quickSort(arr, 0, arr.length);
    }

    private void quickSort(int[] arr, int from, int to) {
        if (to - from > 1) {
            randomizePivot(arr, from, to);
            int pivot = partition(arr, from, to);
            quickSort(arr, from, pivot);
            quickSort(arr, pivot + 1, to);
        }
    }

    int partition(int[] arr, int from, int to) {
        int separator = from - 1;
        for (int i = from; i < to - 1; i++)
            if (arr[i] <= arr[to - 1])
                swap(arr, ++separator, i);
        swap(arr, ++separator, to - 1);
        return separator;
    }

    void randomizePivot(int[] arr, int from, int to) {
        swap(arr, (int) (Math.random() * (to - from)) + from, to - 1);
    }
}