package SortingAlgorithms;

public class BubbleSort {
    public static void main(String[] arg){
        int array[] = {1, 2, 4, 3, 5, 8, 6, 7, 9};

        bubbleSort(array);

        for(int i=0 ; i<array.length; i++){
            System.out.print(array[i]);
        }
    }

    public static void bubbleSort(int arr[]){
        int temp;
        for(int i=0 ; i<arr.length ; i++){
            for(int j=0 ; j<arr.length-1-i; j++){
                if(arr[j+1]<arr[j]){
                    temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }
}
