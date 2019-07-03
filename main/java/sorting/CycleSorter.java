package sorting;

public class CycleSorter extends Sorter {

    public void sort(int[] arr) {
        for (int cycle = 0; cycle < arr.length - 1; cycle++) {
            int key = arr[cycle];
            int pos = cycle;
            for (int i = pos + 1; i < arr.length; i++)
                if (arr[i] < key)
                    pos++;
            if (pos == cycle)
                continue;
            while (arr[pos] == key)
                pos++;
            int temp = arr[pos];
            arr[pos] = key;
            key = temp;
            while (pos != cycle) {
                pos = cycle;
                for (int i = pos + 1; i < arr.length; i++)
                    if (arr[i] < key)
                        pos++;
                while (arr[pos] == key)
                    pos++;
                temp = arr[pos];
                arr[pos] = key;
                key = temp;
            }
        }
    }
}