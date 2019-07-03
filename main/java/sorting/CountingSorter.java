package sorting;

public class CountingSorter extends Sorter {

    private int from;
    private int[] countingArray;

    public CountingSorter(int from, int to) {
        setRange(from, to);
    }

    public void sort(int[] arr) {
        fillCountingArray(arr);
        computePositionArray(arr);
        int[] result = new int[arr.length];
        for (int i = arr.length - 1; i >= 0; i--)
            result[--countingArray[arr[i] - from]] = arr[i];
        System.arraycopy(result, 0, arr, 0, arr.length);
    }

    void radixHelper(int[] arr, int base) {
        clearCountingArray();
        fillCountingArrayRadix(arr, base);
        computePositionArray(arr);
        int[] result = new int[arr.length];
        for (int i = arr.length - 1; i >= 0; i--)
            result[--countingArray[(arr[i] / base) % 10 - from]] = arr[i];
        System.arraycopy(result, 0, arr, 0, arr.length);
    }

    private void computePositionArray(int[] arr) {
        for (int i = 1; i < countingArray.length; i++)
            countingArray[i] += countingArray[i - 1];
    }

    private void fillCountingArray(int[] arr) {
        for (int key: arr)
            countingArray[key - from]++;
    }

    private void fillCountingArrayRadix(int[] arr, int i) {
        for (int key: arr)
            countingArray[(key / i) % 10 - from]++;
    }

    public void setRange(int from, int to) {
        this.from = from;
        countingArray = new int[to - from];
    }

    public void clearCountingArray() {
        clearArray(countingArray);
    }
}