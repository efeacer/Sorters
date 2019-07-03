package sorting;

public class BinaryInsertionSorter extends Sorter {

    public void sort(int[] arr) {
        sort(arr, 0, arr.length);
    }

    void sort(int[] arr, int from, int to) {
        for (int i = from + 1; i < to; i++) {
            int loc = binarySearch(arr, arr[i], from, i - 1);
            int key = arr[i];
            if (i - loc >= 0)
                System.arraycopy(arr, loc, arr, loc + 1, i - loc);
            arr[loc] = key;
        }
    }

    private int binarySearch(int[] arr, int item, int low, int high) {
        if (low > high)
            return low;
        int mid = (low + high) / 2;
        if (item < arr[mid])
            return binarySearch(arr, item, low, mid - 1);
        else if (item > arr[mid])
            return binarySearch(arr, item, mid + 1, high);
        return mid + 1;
    }
}