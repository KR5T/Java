package SortingAlgorithms;

public class SelectionSort {
    public static void main(String[] arg){
        int array[] = {8, 7, 9, 3, 1, 5, 4, 6};

        selectionSort(array);

        for(int i=0 ; i<array.length; i++){
            System.out.print(array[i]);
            }
    }

    public static void selectionSort(int[] arr){
        int minIndex, temp;

        for(int i=0 ; i<arr.length ; i++){
            minIndex = i;
            for(int j=i ; j<arr.length-1 ; j++){
                if(arr[j]<arr[minIndex]){
                    minIndex = j;
                }
            }
            temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }
    }
}

//O(n^2)