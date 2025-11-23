package SortingAlgorithms;

public class RadixSort {
    public static void main(String[] arg){
        int array[] = {8, 7, 9, 3, 1, 5, 4, 6};

        radixSort(array);

        for(int i = 0; i < array.length; i++){
            System.out.print(array[i] + " ");
        }
    }

    // Radix Sort metodu
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
}
