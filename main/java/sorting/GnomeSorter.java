package sorting;

public class GnomeSorter extends Sorter {

    public void sort(int[] arr) {
        int i = 1;
        while (i < arr.length) {
            if (i == 0)
                i++;
            if (arr[i] < arr[i - 1]) {
                swap(arr, i, i - 1);
                i--;
            } else
                i++;
        }
    }
}
