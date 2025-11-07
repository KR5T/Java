package SortingAlgorithms;

public class ShellSort {
    public static void main(String[] arg) {
        int array[] = {8, 7, 9, 3, 1, 5, 4, 6};

        shellSort(array);

        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }

    public static void shellSort(int[] arr) {
        int n = arr.length;

        // Başlangıçta aralık (gap) dizinin yarısı
        for (int gap = n / 2; gap > 0; gap /= 2) {

            // gap aralıklı insertion sort
            for (int i = gap; i < n; i++) {
                int temp = arr[i];
                int j = i;

                // gap kadar gerideki elemanları karşılaştır
                for (; j >= gap && arr[j - gap] > temp; j -= gap) {
                    arr[j] = arr[j - gap];
                }

                arr[j] = temp;
            }
        }
    }
}
