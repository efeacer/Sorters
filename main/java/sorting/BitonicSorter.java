package sorting;

public class BitonicSorter extends Sorter {

    public void sort(int[] arr) {
        bitonicSort(arr, 0, arr.length, true);
    }

    private void bitonicSort(int[] arr, int from, int length, boolean ascending) {
        if (length < 2)
            return;
        int newLength = length / 2;
        bitonicSort(arr, from, newLength, !ascending);
        bitonicSort(arr, from + newLength, length - newLength, ascending);
        bitonicMerge(arr, from, length, ascending);
    }

    private void bitonicMerge(int[] arr, int from, int length, boolean ascending) {
        if (length < 2)
            return;
        int comparatorLength = maxPowTwo(length);
        for (int i = from; i + comparatorLength < from + length; i++)
            compareAndSwap(arr, i, i + comparatorLength, ascending);
        bitonicMerge(arr, from, comparatorLength, ascending);
        bitonicMerge(arr, from + comparatorLength, length - comparatorLength, ascending);
    }

    private void compareAndSwap(int[] arr, int index1, int index2, boolean ascending) {
        if (arr[index1] < arr[index2] == !ascending)
            swap(arr, index1, index2);
    }

    private int maxPowTwo(int limit) {
        int result = 1;
        while (result * 2 < limit)
            result *= 2;
        return result;
    }
}
