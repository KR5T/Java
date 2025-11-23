package SortingAlgorithms;

public class CountingSort {
    public static void main(String[] arg){
        int array[] = {8, 7, 9, 3, 1, 5, 4, 6};

        countingSort(array);

        for(int i=0 ; i<array.length; i++){
            System.out.print(array[i] + " ");
        }
    }

    private static void countingSort(int[] arr){
        if(arr.length <= 1) return;

        int max = arr[0];
        for(int i=1; i<arr.length; i++){
            if(arr[i] > max){
                max = arr[i];
            }
        }

        int[] count = new int[max + 1];

        for(int i=0; i<arr.length; i++){
            count[arr[i]]++;
        }

        int index = 0;
        for(int i=0; i<count.length; i++){
            while(count[i] > 0){
                arr[index] = i;
                index++;
                count[i]--;
            }
        }
    }
}

