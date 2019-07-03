package sorting;

public class CombSorter extends Sorter {

    private static final double SHRINK_FACTOR = 1.3;

    public void sort(int[] arr) {
        int gap = arr.length;
        boolean swapped = true;
        while (gap > 1 || swapped) {
            gap = nextGap(gap);
            swapped = false;
            for (int i = 0; i < arr.length - gap; i++)
                if (arr[i] > arr[i + gap]) {
                    swap(arr, i, i + gap);
                    swapped = true;
                }
        }
    }

    private int nextGap(int gap) {
        int nextGap = (int) (gap / SHRINK_FACTOR);
        return nextGap < 1 ? 1: nextGap;
    }
}