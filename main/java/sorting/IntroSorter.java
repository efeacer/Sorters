package sorting;

public class IntroSorter extends Sorter {

    private static final int LIMIT = 16;

    private Sorter insertionSorter = new InsertionSorter();
    private Sorter quickSorter = new QuickSorter();
    private Sorter heapSorter = new HeapSorter();

    public void sort(int[] arr) {
        introSort(arr, 0, arr.length,
                (int) (2 * Math.floor(Math.log(arr.length) / Math.log(2))));
    }

    private void introSort(int[] arr, int from, int to, int depthLimit) {
        if (to - from <= LIMIT)
            ((InsertionSorter) insertionSorter).sort(arr, from, to);
        else if (depthLimit == 0)
            ((HeapSorter) heapSorter).sort(arr, from, to);
        else {
            ((QuickSorter) quickSorter).randomizePivot(arr, from , to);
            int pivot = ((QuickSorter) quickSorter).partition(arr, from, to);
            introSort(arr, from, pivot, depthLimit - 1);
            introSort(arr, pivot + 1, to, depthLimit - 1);
        }
    }
}
