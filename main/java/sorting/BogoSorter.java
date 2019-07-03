package sorting;

import java.util.Random;

public class BogoSorter extends Sorter {

    private Random rand = new Random();

    public void sort(int[] arr) {
        while (!isSorted(arr))
            shuffle(arr);
    }

    private void shuffle(int[] arr) {
        for (int i = arr.length - 1; i > 0; i--) {
            swap(arr, i, rand.nextInt(i + 1));
        }
    }
}
