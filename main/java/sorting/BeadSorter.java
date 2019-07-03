package sorting;

public class BeadSorter extends Sorter {

    public void sort(int[] arr) {
        if (arr.length < 2)
            return;
        boolean didFall = true;
        while (didFall) {
            didFall = false;
            for (int bead = arr.length - 2; bead >= 0; bead--) {
                int diff = arr[bead] - arr[bead + 1];
                if (diff > 0) {
                    arr[bead] -= diff;
                    arr[bead + 1] += diff;
                    didFall = true;
                }
            }
        }
    }

    private void printBeads(int[] beads) {
        for (int bead: beads) {
            for (int i = 0; i < bead; i++)
                System.out.print("*");
            System.out.println();
        }
    }
}
