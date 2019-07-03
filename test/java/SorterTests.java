import org.junit.Before;
import org.junit.Test;
import sorting.*;

import java.util.Random;

import static junit.framework.TestCase.assertTrue;

public class SorterTests {

    private Sorter[] sorters;
    private Random rand;
    private static final int NUM_LOWER_BOUND = 0;
    private static final int NUM_UPPER_BOUND = 10000;
    private static final int NUM_TEST_ITERS = 10;
    private static final int LONG_ARR_LENGTH = 1000;

    @Before
    public void setUp() {
        sorters = new Sorter[]{
                new CountingSorter(NUM_LOWER_BOUND, NUM_UPPER_BOUND),
                new RadixSorter(),
                new BubbleSorter(),
                new CocktailSorter(),
                new CombSorter(),
                new CycleSorter(),
                new GnomeSorter(),
                new HeapSorter(),
                new InsertionSorter(),
                new MergeSorter(),
                new QuickSorter(),
                new SelectionSorter(),
                new ShellSorter(),
                new StrandSorter(),
                new TreeSorter(),
                new BinaryInsertionSorter(),
                new TimSorter(),
                new BeadSorter(),
                new IntroSorter(),
                new PigeonholeSorter(),
                new PancakeSorter(),
                new StoogeSorter()
        };
        rand = new Random();
    }

    @Test
    public void testWithArraysOfLengthOne() {
        int[] arr = new int[]{randInt()};
        boolean allSortersCanSort = true;
        ((CountingSorter) sorters[0]).clearCountingArray();
        for (Sorter sorter: sorters) {
            int[] arrCopy = arr.clone();
            sorter.sort(arrCopy);
            boolean sorterCanSort =  Sorter.isSorted(arrCopy);
            if (!sorterCanSort)
                System.out.println(sorter.getClass() + " cannot sort.");
            allSortersCanSort = allSortersCanSort && sorterCanSort;
        }
        assertTrue(allSortersCanSort);
    }

    @Test
    public void testWithArraysOfLengthTwo() {
        int[] arrSorted = new int[] {100, 1000};
        int[] arrUnsorted = new int[] {1000, 100};
        boolean allSortersCanSort = true;
        ((CountingSorter) sorters[0]).clearCountingArray();
        for (Sorter sorter: sorters) {
            int[] arrSortedCopy = arrSorted.clone();
            sorter.sort(arrSortedCopy);
            boolean sorterCanSortSorted = Sorter.isSorted(arrSortedCopy);
            if (!sorterCanSortSorted)
                System.out.println(sorter.getClass() + " cannot sort the sorted array.");
            allSortersCanSort = allSortersCanSort && sorterCanSortSorted;
        }
        ((CountingSorter) sorters[0]).clearCountingArray();
        for (Sorter sorter: sorters) {
            int[] arrUnsortedCopy = arrUnsorted.clone();
            sorter.sort(arrUnsortedCopy);
            boolean sorterCanSortUnsorted = Sorter.isSorted(arrUnsortedCopy);
            if (!sorterCanSortUnsorted)
                System.out.println(sorter.getClass() + " cannot sort the unsorted array.");
            allSortersCanSort = allSortersCanSort &&  sorterCanSortUnsorted;
        }
        assertTrue(allSortersCanSort);
    }

    @Test
    public void testWithArraysOfLengthThree() {
        boolean allSortersCanSort = true;
        for (int i = 0; i < NUM_TEST_ITERS; i++) {
            int[] arr = new int[]{randInt(), randInt(), randInt()};
            ((CountingSorter) sorters[0]).clearCountingArray();
            for (Sorter sorter: sorters) {
                int[] arrCopy = arr.clone();
                sorter.sort(arrCopy);
                boolean sorterCanSort =  Sorter.isSorted(arrCopy);
                if (!sorterCanSort)
                    System.out.println(sorter.getClass() + " cannot sort.");
                allSortersCanSort = allSortersCanSort && sorterCanSort;
            }
        }
        assertTrue(allSortersCanSort);
    }

    @Test
    public void testWithLongArrays() {
        boolean allSortersCanSort = true;
        for (int i = 0; i < NUM_TEST_ITERS; i++) {
            int[] arr = new int[LONG_ARR_LENGTH];
            for (int j = 0; j < LONG_ARR_LENGTH; j++)
                arr[j] = randInt();
            ((CountingSorter) sorters[0]).clearCountingArray();
            for (Sorter sorter: sorters) {
                int[] arrCopy = arr.clone();
                sorter.sort(arrCopy);
                boolean sorterCanSort =  Sorter.isSorted(arrCopy);
                if (!sorterCanSort)
                    System.out.println(sorter.getClass() + " cannot sort.");
                allSortersCanSort = allSortersCanSort && sorterCanSort;
            }
        }
        assertTrue(allSortersCanSort);
    }

    @Test
    public void testWithSortedLongArray() {
        boolean allSortersCanSort = true;
        for (int i = 0; i < NUM_TEST_ITERS; i++) {
            int[] arr = new int[LONG_ARR_LENGTH];
            for (int j = 0; j < LONG_ARR_LENGTH; j++)
                arr[j] = j;
            ((CountingSorter) sorters[0]).clearCountingArray();
            for (Sorter sorter: sorters) {
                int[] arrCopy = arr.clone();
                sorter.sort(arrCopy);
                boolean sorterCanSort =  Sorter.isSorted(arrCopy);
                if (!sorterCanSort)
                    System.out.println(sorter.getClass() + " cannot sort.");
                allSortersCanSort = allSortersCanSort && sorterCanSort;
            }
        }
        assertTrue(allSortersCanSort);
    }

    @Test
    public void testWithReverseSortedLongArray() {
        boolean allSortersCanSort = true;
        for (int i = 0; i < NUM_TEST_ITERS; i++) {
            int[] arr = new int[LONG_ARR_LENGTH];
            for (int j = 0; j < LONG_ARR_LENGTH; j++)
                arr[j] = LONG_ARR_LENGTH - j - 1;
            ((CountingSorter) sorters[0]).clearCountingArray();
            for (Sorter sorter: sorters) {
                int[] arrCopy = arr.clone();
                sorter.sort(arrCopy);
                boolean sorterCanSort =  Sorter.isSorted(arrCopy);
                if (!sorterCanSort)
                    System.out.println(sorter.getClass() + " cannot sort.");
                allSortersCanSort = allSortersCanSort && sorterCanSort;
            }
        }
        assertTrue(allSortersCanSort);
    }

    @Test
    public void testWithNegativeLongArray() {
        boolean allSortersCanSort = true;
        for (int i = 0; i < NUM_TEST_ITERS; i++) {
            int[] arr = new int[LONG_ARR_LENGTH];
            for (int j = 0; j < LONG_ARR_LENGTH; j++)
                arr[j] = -randInt();
            for (int k = 2; k < sorters.length; k++) {
                Sorter sorter = sorters[k];
                int[] arrCopy = arr.clone();
                sorter.sort(arrCopy);
                boolean sorterCanSort =  Sorter.isSorted(arrCopy);
                if (!sorterCanSort)
                    System.out.println(sorter.getClass() + " cannot sort.");
                allSortersCanSort = allSortersCanSort && sorterCanSort;
            }
        }
        assertTrue(allSortersCanSort);
    }

    @Test
    public void testWithMixedSignLongArray() {
        boolean allSortersCanSort = true;
        for (int i = 0; i < NUM_TEST_ITERS; i++) {
            int[] arr = new int[LONG_ARR_LENGTH];
            for (int j = 0; j < LONG_ARR_LENGTH; j++) {
                arr[j] = randInt();
                if (Math.random() < 0.5)
                    arr[j] *= -1;
            }
            for (int k = 2; k < sorters.length; k++) {
                Sorter sorter = sorters[k];
                int[] arrCopy = arr.clone();
                sorter.sort(arrCopy);
                boolean sorterCanSort =  Sorter.isSorted(arrCopy);
                if (!sorterCanSort)
                    System.out.println(sorter.getClass() + " cannot sort.");
                allSortersCanSort = allSortersCanSort && sorterCanSort;
            }
        }
        assertTrue(allSortersCanSort);
    }

    private int randInt() {
        return rand.nextInt(NUM_UPPER_BOUND) + NUM_LOWER_BOUND;
    }
}