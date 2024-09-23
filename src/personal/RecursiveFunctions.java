package personal;

import org.w3c.dom.ls.LSOutput;

public class RecursiveFunctions {
    public static void main(String[] args) {

    }

    public void quicksort(int[] arr) {
        int index = arr.length / 2;
        int[] smallerArray = new int[arr.length-1];
        int[] greaterArray = new int[arr.length-1];;
        int smallerArrayCount = 0;
        int greaterArrayCount = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[index] < arr[i]){
                smallerArray[smallerArrayCount] = arr[i];
                smallerArrayCount ++;
            }else {
                greaterArray[greaterArrayCount] = arr[i];
                greaterArrayCount ++;
            }
        }
        return ;
    }
}


