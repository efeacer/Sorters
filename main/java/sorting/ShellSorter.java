package sorting;

public class ShellSorter extends Sorter {

    public void sort(int[] arr) {
        for (int gap = arr.length; gap > 0; gap /= 2)
            for (int i = gap; i < arr.length; i++) {
                int key = arr[i];
                int j;
                for (j = i - gap; j >= 0 && key < arr[j]; j -= gap)
                    arr[j + gap] = arr[j];
                arr[j + gap] = key;
            }
    }
}