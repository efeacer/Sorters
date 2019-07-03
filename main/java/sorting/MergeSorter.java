package sorting;

public class MergeSorter extends Sorter {

    public void sort(int[] arr) {
        if (arr.length <= 1)
            return;
        int mid = arr.length / 2;
        int[] arr1 = subArray(arr, 0, mid);
        int[] arr2 = subArray(arr, mid, arr.length);
        sort(arr1);
        sort(arr2);
        merge(arr, arr1, arr2, 0);
    }

    void merge(int[] arr, int[] arr1, int[] arr2, int i) {
        int i1 = 0;
        int i2 = 0;
        while (i1 < arr1.length && i2 < arr2.length)
            if (arr1[i1] < arr2[i2])
                arr[i++] = arr1[i1++];
            else
                arr[i++] = arr2[i2++];
        while (i1 < arr1.length)
            arr[i++] = arr1[i1++];
        while (i2 < arr2.length)
            arr[i++] = arr2[i2++];
    }

    int[] subArray(int[] arr, int from, int to) {
        int[] subArray = new int[to - from];
        if (to - from >= 0)
            System.arraycopy(arr, from, subArray, 0, to - from);
        else
            return new int[]{};
        return subArray;
    }
}