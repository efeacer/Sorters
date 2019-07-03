package sorting;

public class BubbleSorter extends Sorter {

    public void sort(int[] arr) {
        for (int i = arr.length - 1; i > 0; i--)
            for (int j = 0; j < i; j++)
                if (arr[j + 1] < arr[j])
                    swap(arr, j, j + 1);
    }
}