package SortingAlgorithms;

import java.util.Arrays;
import java.util.Random;

public class Main {


    // INSERTION SORT
   
    public static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int j = i - 1;

            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }


    // SELECTION SORT

    public static void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int minIndex = i;

            for (int j = i + 1; j < arr.length; j++)
                if (arr[j] < arr[minIndex])
                    minIndex = j;

            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }
    }


    // MERGE SORT

    public static void mergeSort(int[] arr) {
        if (arr.length <= 1) return;

        int mid = arr.length / 2;

        int[] left = Arrays.copyOfRange(arr, 0, mid);
        int[] right = Arrays.copyOfRange(arr, mid, arr.length);

        mergeSort(left);
        mergeSort(right);

        merge(arr, left, right);
    }

    private static void merge(int[] arr, int[] L, int[] R) {
        int i = 0, j = 0, k = 0;

        while (i < L.length && j < R.length)
            arr[k++] = (L[i] <= R[j]) ? L[i++] : R[j++];

        while (i < L.length) arr[k++] = L[i++];
        while (j < R.length) arr[k++] = R[j++];
    }


    // HEAP SORT

    public static void heapSort(int[] arr) {
        int n = arr.length;

        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(arr, n, i);

        for (int i = n - 1; i >= 0; i--) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            heapify(arr, i, 0);
        }
    }

    private static void heapify(int[] arr, int n, int i) {
        int largest = i;
        int L = 2 * i + 1;
        int R = 2 * i + 2;

        if (L < n && arr[L] > arr[largest]) largest = L;
        if (R < n && arr[R] > arr[largest]) largest = R;

        if (largest != i) {
            int temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp;

            heapify(arr, n, largest);
        }
    }


    // COUNTING SORT

    public static void countingSort(int[] arr) {
        if (arr.length == 0) return;

        int max = Arrays.stream(arr).max().getAsInt();
        int min = Arrays.stream(arr).min().getAsInt();
        int range = max - min + 1;

        int[] count = new int[range];
        int[] output = new int[arr.length];

        for (int num : arr) count[num - min]++;

        for (int i = 1; i < count.length; i++)
            count[i] += count[i - 1];

        for (int i = arr.length - 1; i >= 0; i--) {
            output[count[arr[i] - min] - 1] = arr[i];
            count[arr[i] - min]--;
        }

        System.arraycopy(output, 0, arr, 0, arr.length);
    }


    // QUICK SORT

    public static void quickSort(int[] arr) {
        quickSortRec(arr, 0, arr.length - 1);
    }

    private static void quickSortRec(int[] arr, int low, int high) {
        if (low < high) {
            int p = partition(arr, low, high);
            quickSortRec(arr, low, p - 1);
            quickSortRec(arr, p + 1, high);
        }
    }

    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;

        for (int j = low; j < high; j++)
            if (arr[j] < pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }

        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }


    // RADIX SORT

   public static void radixSort(int[] arr) {
        int max = getMax(arr);
        // Basamak basamak sırala
        for (int exp = 1; max / exp > 0; exp *= 10) {
            countingSortByDigit(arr, exp);
        }
    }

    // Dizideki maksimum değeri bul
    public static int getMax(int[] arr) {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++)
            if (arr[i] > max)
                max = arr[i];
        return max;
    }

    // Belirli basamağa göre Counting Sort
    public static void countingSortByDigit(int[] arr, int exp) {
        int n = arr.length;
        int output[] = new int[n];
        int count[] = new int[10]; // 0-9 basamakları

        // Basamak değerlerine göre say
        for (int i = 0; i < n; i++) {
            int digit = (arr[i] / exp) % 10;
            count[digit]++;
        }

        // Count dizisini toplamsal hale getir
        for (int i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }

        // Diziyi sırala
        for (int i = n - 1; i >= 0; i--) {
            int digit = (arr[i] / exp) % 10;
            output[count[digit] - 1] = arr[i];
            count[digit]--;
        }

        // Orijinal diziyi güncelle
        for (int i = 0; i < n; i++) {
            arr[i] = output[i];
        }
    }

    // TIME MEASUREMENT

    public static double measure(Runnable algorithm) {
        long start = System.nanoTime();
        algorithm.run();
        long end = System.nanoTime();
        return (end - start) / 1_000_000_000.0;  // seconds
    }


    // TEST FUNCTION

    public static void testAlgorithm(String name, int[] original, Runnable sortMethod) {
        int[] arr = Arrays.copyOf(original, original.length);

        double time = measure(() -> sortMethod.run());

        System.out.printf("%-15s : %.6f saniye%n", name, time);
    }

    public static void main(String[] args) {
        int[] testSizes = {1000, 10_000, 100_000, 1_000_000};

        for (int n : testSizes) {
            System.out.println("\n===== N = " + n + " =====");

            int[] original = new Random().ints(n, 0, 1_000_000).toArray();

            testAlgorithm("Quick Sort",     original, () -> quickSort(original));
            testAlgorithm("Merge Sort",     original, () -> mergeSort(original));
            testAlgorithm("Insertion Sort", original, () -> insertionSort(original));
            testAlgorithm("Selection Sort", original, () -> selectionSort(original));
            testAlgorithm("Heap Sort",      original, () -> heapSort(original));
            testAlgorithm("Counting Sort",  original, () -> countingSort(original));
            testAlgorithm("Radix Sort",     original, () -> radixSort(original));
        }
    }

}
