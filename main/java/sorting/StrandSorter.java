package sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StrandSorter extends Sorter {

    public void sort(int[] arr) {
        List<Integer> output = new ArrayList<>();
        output = strandSort(Arrays.stream(arr).boxed().collect(Collectors.toList()), output);
        for (int i = 0; i < arr.length; i++)
            arr[i] = output.get(i);
    }

    private List<Integer> strandSort(List<Integer> input, List<Integer> output) {
        if (input.isEmpty())
            return output;
        List<Integer> sublist = new ArrayList<>();
        sublist.add(input.remove(0));
        for (int i = 0; i < input.size(); i++)
            if (input.get(i) >= sublist.get(sublist.size() - 1))
                sublist.add(input.remove(i--));
        output = merge(sublist, output);
        return strandSort(input, output);
    }

    private List<Integer> merge(List<Integer> sublist, List<Integer> output) {
        int i1 = 0;
        int i2 = 0;
        int i = 0;
        int[] arr = new int[sublist.size() + output.size()];
        while (i1 < sublist.size() && i2 < output.size())
            if (sublist.get(i1) < output.get(i2))
                arr[i++] = sublist.get(i1++);
            else
                arr[i++] = output.get(i2++);
        while (i1 < sublist.size())
            arr[i++] = sublist.get(i1++);
        while (i2 < output.size())
            arr[i++] = output.get(i2++);
        return Arrays.stream(arr).boxed().collect(Collectors.toList());
    }
}