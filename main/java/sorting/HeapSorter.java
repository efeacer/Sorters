package sorting;

public class HeapSorter extends Sorter {

    public void sort(int[] arr) {
        sort(arr, 0, arr.length);
    }

    public void sort(int[] arr, int from ,int to) {
        buildHeap(arr, from, to);
        int heapSize = to - from;
        while (heapSize > 1) {
            swap(arr, from, from + --heapSize);
            heapify(arr, from, from + heapSize, from);
        }
    }

    private void buildHeap(int[] arr, int from, int to) {
        for (int i = from + (to - from) / 2 - 1; i >= from; i--)
            heapify(arr, i, to, from);
    }

    private void heapify(int[] arr, int root, int end, int offset) {
        int lChild = 2 * (root - offset) + 1 + offset;
        int rChild = 2 * (root - offset) + 2 + offset;
        int swapIndex = root;
        if (lChild < end && arr[lChild] > arr[swapIndex])
            swapIndex = lChild;
        if (rChild < end && arr[rChild] > arr[swapIndex])
            swapIndex = rChild;
        if (swapIndex != root) {
            swap(arr, root, swapIndex);
            heapify(arr, swapIndex, end, offset);
        }
    }
}