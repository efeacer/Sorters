package sorting;

import java.util.ArrayList;
import java.util.List;

public class PigeonholeSorter extends Sorter {

    private class IntegerList extends ArrayList<Integer> {}

    public void sort(int[] arr) {
        int[] minAndMax = minAndMax(arr);
        int min = minAndMax[0];
        int max = minAndMax[1];
        int range = max - min + 1;
        int idx = 0;
        List<Integer>[] pigeonholes = initHoles(arr, range, min);
        for (List<Integer> pigeonhole: pigeonholes)
            for (int item: pigeonhole)
                arr[idx++] = item;
    }

    private List<Integer>[] initHoles(int[] arr, int range, int min) {
        List<Integer>[] pigeonholes =  new IntegerList[range];
        for (int i = 0; i < range; i++)
            pigeonholes[i] = new IntegerList();
        for (int item: arr) {
            pigeonholes[item - min].add(item);
        }
        return pigeonholes;
    }

    private int[] minAndMax(int[] arr) {
        int min = arr[0];
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < min)
                min = arr[i];
            if (arr[i] > max)
                max = arr[i];
        }
        return new int[]{min, max};
    }
}
