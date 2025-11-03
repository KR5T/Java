package SortingAlgorithms;

public class InsertionSort {
     public static void main(String[] arg){
    int array[] = {8, 7, 9, 3, 1, 5, 4, 6};

    insertionSort(array);

    for(int i=0 ; i<array.length; i++){
        System.out.print(array[i]);
        }
    }

    public static void insertionSort(int[] arr){
        int temp;
        
        for(int i=0 ; i<arr.length-1; i++){
            temp = arr[i+1];
            int j=i;

            for( ; j>=0 && temp<arr[j] ; j--){
                arr[j+1] = arr[j];
            }
            
            arr[j+1] = temp;
        }
    }
}
