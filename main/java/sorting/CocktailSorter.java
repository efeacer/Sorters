package sorting;

public class CocktailSorter extends Sorter {

    public void sort(int[] arr) {
        for (int i = 1; i <= arr.length / 2; i++) {
            for (int j = i - 1; j < arr.length - i; j++)
                if (arr[j] > arr[j + 1])
                    swap(arr, j, j + 1);
            for (int j = arr.length - 1 - i; j >= i; j--)
                if (arr[j] < arr[j - 1])
                    swap(arr, j, j - 1);
        }
    }
}