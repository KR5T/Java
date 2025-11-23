package SortingAlgorithms;

public class MergeSort {
     public static void main(String[] arg){
    int array[] = {8, 7, 9, 3, 1, 5, 4, 6};

    mergeSort(array);

    for(int i=0 ; i<array.length; i++){
        System.out.print(array[i]);
        }
    }

    private static void mergeSort(int[] arr){
        int length = arr.length;
        if(length<=1) return;

        int middle = length/2;
        int[] leftArray = new int[middle];
        int[] rightArray = new int[length-middle];

        int i = 0;
        int j = 0;
        for(; i<length; i++){
            if(i<middle){
                leftArray[i] = arr[i];
            }
            else{
                rightArray[j] = arr[i];
                j++;
            }
        }
        mergeSort(leftArray);
        mergeSort(rightArray);
        merge(leftArray, rightArray, arr);
    }

    private static void merge(int[] leftArray, int[] rightArray, int[] array){
        int leftSize = array.length / 2;
        int rightSize = array.length - leftSize;

        int i = 0, l = 0, r = 0;
        do{
            if(leftArray[l]<rightArray[r]){
                array[i] = leftArray[l];
                i++;
                l++;
            }
            else{
                array[i] = rightArray[r];
                i++;
                r++;
            }
        }while(l<leftSize && r<rightSize);

        while(l<leftSize){
            array[i] = leftArray[l];
            i++;
            l++;
        }
        while(r<rightSize){
            array[i] = rightArray[r];
            i++;
            r++;
        }
    }
}
