package sorting;

public class PancakeSorter extends Sorter {

    public void sort(int[] arr) {
        for (int currSize = arr.length; currSize > 1; currSize--) {
            int maxIdx = maxIdx(arr, currSize);
            if (maxIdx + 1 != currSize) {
                flip(arr, maxIdx + 1);
                flip(arr, currSize);
            }
        }
    }

    private void flip(int[] arr, int size) {
        for (int i = 0; i < size / 2; i++)
            swap(arr, i,  size - i - 1);
    }

    private int maxIdx(int[] arr, int size) {
        int maxIdx = 0;
        for (int i = 1; i < size; i++)
            if (arr[i] > arr[maxIdx])
                maxIdx = i;
        return maxIdx;
    }
}
