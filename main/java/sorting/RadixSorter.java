package sorting;

public class RadixSorter extends Sorter {

    private CountingSorter countingSorter;

    public RadixSorter() {
        countingSorter = new CountingSorter(0, 10);
    }

    public void sort(int[] arr) {
        int max = max(arr);
        for (int base = 1; max / base > 0; base *= 10)
            countingSorter.radixHelper(arr, base);
    }

    private int max(int[] arr) {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++)
            if (arr[i] > max)
                max = arr[i];
        return max;
    }
}