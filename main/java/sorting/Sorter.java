package sorting;

public abstract class Sorter {

    public abstract void sort(int[] arr);

    void swap(int[] arr, int index1, int index2) {
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }

    void clearArray(int[] arr) {
        for (int i = 0; i < arr.length; i++)
            arr[i] = 0;
    }

    public static boolean isSorted(int[] arr) {
        for (int i = 1; i < arr.length; i++)
            if (arr[i] < arr[i - 1])
                return false;
        return true;
    }
}