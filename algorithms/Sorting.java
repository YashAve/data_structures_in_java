package algorithms;

import java.util.Random;

public class Sorting {

    private static int swaps = 0;

    public static int[] getArray(final int length) {
        Random random = new Random();
        int[] array = new int[length];
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(1, 20);
        }
        return array;
    }

    private static int pivot(int[] array, final int start, final int end) {
        int pivot = array[start];
        int i = start, j = end;
        while (i < j) {
            while (i < j && array[--j] > pivot) ;
            if (i < j) {
                array[i] = array[j];
            }
            while (i < j && array[++i] < pivot) ;
            if (i < j) {
                array[j] = array[i];
            }
        }
        array[j] = pivot;
        return j;
    }

    public static void quickSort(int[] array, final int start, final int end) {
        if (end - start < 2) {
            return;
        }
        int pivotIndex = pivot(array, start, end);
        quickSort(array, start, pivotIndex);
        quickSort(array, pivotIndex + 1, end);
    }

    private static int getDigit(int position, int value, int radix) {
        // 4792 / 1 % 10 = 4792 % 10 = 2
        // 4792 / 10 % 10 = 4792 % 10 = 9
        return value / (int) Math.pow(10, position) % radix;
    }

    private static void singleRadixSort(int[] array, int position, int radix) {
        // {4792, 4725, 4586, 1330, 8792, 5729}
        int length = array.length;
        int[] countArray = new int[radix]; // 10 elements array
        // {0, 0, 2, 1, 0, 0, 0, 0, 1, 2}
        for (var value : array) {
            //here we are going to extract the digit first and then increment the count array from 0 to 9, which are 10 elements
            countArray[getDigit(position, value, radix)]++;
        }
        /* now let's adjust the counting array
           {0, 0, 2, 3, 3, 3, 3, 3, 4, 6}
         */
        for (int i = 1; i < radix - 1; i++) {
            countArray[i] += countArray[i - 1];
        }
        countArray[radix - 1] = length;
        int[] temp = new int[length];
        /* k starts at 5, value is 5729, digit is 2
           {0, 5729, 0, 0, 0, 0} -> {0, 0, 1, 3, 3, 3, 3, 3, 4, 6}
        */
        for (int k = length - 1; k >= 0; k--) {
            temp[--countArray[getDigit(position, array[k], radix)]] = array[k];
        }
        System.arraycopy(temp, 0, array, 0, length);
        /*for (int i = 0, count = 0; i < length; i++) {
            array[count++] = temp[i];
        }*/
    }

    public static void radixSort(int[] array, int radix, int width) {
        for (int i = 0; i < width; i++) {
            singleRadixSort(array, i, radix);
        }
    }

    public static void countingSort(int[] array) {
        int minimum = array[0], maximum = minimum;
        for (var i : array) {
            minimum = Math.min(i, minimum);
            maximum = Math.max(i, maximum);
        }
        int[] countArray = new int[(maximum - minimum) + 1];
        for (var i : array) {
            countArray[i - minimum]++;
        }
        for (int i = minimum, count = 0; i <= maximum; i++) {
            for (int j = countArray[i - minimum]; j > 0; j--) {
                array[count++] = i;
            }
        }
    }

    private static void swap(int[] array, int x, int y) {
        if (array[x] != array[y]) {
            int temp = array[x];
            array[x] = array[y];
            array[y] = temp;
        }
    }

    public static void selectionSort(int[] array) {
        for (int lastUnsortedIndex = array.length - 1; lastUnsortedIndex > 0; lastUnsortedIndex--) {
            int largest = 0;
            for (int i = 1; i < lastUnsortedIndex; i++) {
                largest = array[i] > array[largest] ? i : largest;
            }
            if (array[largest] > array[lastUnsortedIndex]) {
                swap(array, largest, lastUnsortedIndex);
            }
        }
    }

    public static void bubbleSort(int[] array) {
        for (int gap = array.length; gap > 0; gap /= 2) {
            for (int lastUnsortedIndex = array.length - gap; lastUnsortedIndex > 0; lastUnsortedIndex -= gap) {
                for (int i = 0; i < lastUnsortedIndex; i += gap) {
                    if (array[i] > array[i + gap]) {
                        swap(array, i, i + gap);
                    }
                }
            }
        }
    }

    public static void insertionSort(int[] array) {
        for (int firstUnsortedIndex = 1; firstUnsortedIndex < array.length; firstUnsortedIndex++) {
            int newElement = array[firstUnsortedIndex];
            int i;
            for (i = firstUnsortedIndex; i > 0 && array[i - 1] > newElement; i--) {
                array[i] = array[i - 1];
            }
            array[i] = newElement;
        }
    }
}
