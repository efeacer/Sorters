package sorting;

public class SelectionSorter extends Sorter {

    public void sort(int[] arr) {
        for (int i = 0; i < arr.length -1; i++) {
            int minIndex = findMinIndex(arr, i);
            swap(arr, i, minIndex);
        }
    }

    private int findMinIndex(int[] arr, int from) {
        int minIndex = from;
        for (int i = from; i < arr.length; i++)
            if (arr[i] < arr[minIndex])
                minIndex = i;
        return minIndex;
    }
}