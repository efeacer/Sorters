import sorting.*;

import java.util.Arrays;

public class Main {

    private static final int NUM_LOWER_BOUND = 0;
    private static final int NUM_UPPER_BOUND = 10000;
    private static final int NUM_TEST_ITERS = 10;
    private static final int LONG_ARR_LENGTH = 1000;
    private static final Sorter[] SORTERS = new Sorter[]{
            new CountingSorter(NUM_LOWER_BOUND, NUM_UPPER_BOUND),
            new BubbleSorter(),
            new CocktailSorter(),
            new CombSorter(),
            new CycleSorter(),
            new GnomeSorter(),
            new HeapSorter(),
            new InsertionSorter(),
            new MergeSorter(),
            new QuickSorter(),
            new RadixSorter(),
            new SelectionSorter(),
            new ShellSorter(),
            new StrandSorter(),
            new BinaryInsertionSorter(),
            new TimSorter(),
            new BeadSorter(),
            new IntroSorter(),
            new PigeonholeSorter(),
            new PancakeSorter(),
            new StoogeSorter(),
            //new BogoSorter(),
            new OddEvenSorter()
    };

    public static void main(String[] args) {
        //TODO: Perform experiments!
    }
}