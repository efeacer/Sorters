package sorting;

public class TimSorter extends Sorter {

    private static final int MIN_RUN = 32;

    private Sorter binaryInsertionSorter = new BinaryInsertionSorter();
    private Sorter mergeSorter = new MergeSorter();

    public void sort(int[] arr) {
        for (int i = 0; i < arr.length; i += MIN_RUN)
            ((BinaryInsertionSorter) binaryInsertionSorter).sort(arr, i, Math.min(i + MIN_RUN, arr.length));
        for (int i = MIN_RUN; i < arr.length; i *= 2)
            for (int j = 0; j < arr.length; j += 2 * i)
                ((MergeSorter) mergeSorter).merge(arr,
                        ((MergeSorter) mergeSorter).subArray(arr, j, Math.min(j + i, arr.length)),
                        ((MergeSorter) mergeSorter).subArray(arr, Math.min(j + i, arr.length),
                                Math.min(j + 2 * i, arr.length)), j);
    }
}