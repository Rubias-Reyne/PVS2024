import java.util.Arrays;
import java.util.Random;


interface ISortingAlgorithm {

    public void sort(int[] data);

}

class QuickSort implements ISortingAlgorithm {

    int split(int[] data, int left, int right) {
        int pivot = data[right];
        while
        (true) {
            while ((pivot > data[left]) && (left < right))
                left++;
            if (left < right) {
                data[right] = data[left];
                right--;
            } else break;
            while ((pivot < data[right]) && (left < right))
                right--;
            if (left < right) {
                data[left] = data[right];
                left++;
            } else break;
        }
        data[left] = pivot;
        return (left);
    }


    @Override
    public void sort(int[] data) {
        quickSort(data, 0, data.length - 1);
    }


    public void quickSort(int[] data, int start, int end) {
        if (end <= start) return;
        int i = split(data, start, end);
        quickSort(data, start, i - 1);
        quickSort(data, i + 1, end);
    }

}

class InsertSort implements ISortingAlgorithm {

    @Override
    public void sort(int[] data) {
        for (int i = 1; i < data.length; i++) {
            int v = data[i];
            int j = i - 1;
            while ((j >= 0) && data[j] > v) {
                data[j + 1] = data[j];
                j--;
            }
            data[j + 1] = v;
        }
    }

}

class BubbleSort implements ISortingAlgorithm {

    @Override
    public void sort(int[] data) {
        int n = data.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (data[j] > data[j + 1]) {
                    int temp = data[j];
                    data[j] = data[j + 1];
                    data[j + 1] = temp;
                }
            }
        }
    }
}

class SelectionSort implements ISortingAlgorithm {

    @Override
    public void sort(int[] data) {
        int n = data.length;
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (data[j] < data[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = data[minIndex];
            data[minIndex] = data[i];
            data[i] = temp;
        }
    }
}


public class SortingTest {
    static int[] generateArray(int length){
        int[] array = new int[length];
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (Math.random()*1000000);
        }
        return array;
    }
    public static void main(String[] args) {
        int[] toSort = generateArray(1000000);
        int[] another;
        long stop,start;
        ISortingAlgorithm[] algorithms = {new BubbleSort(), new SelectionSort(), new InsertSort(), new QuickSort()};
        for (int i = 0; i < algorithms.length; i++) {
            another = Arrays.copyOf(toSort,toSort.length);
            start = System.currentTimeMillis();
            algorithms[i].sort(another);
            stop = System.currentTimeMillis();
            System.out.println(algorithms[i].getClass() + ": " + (stop - start) + " ms");

        }

        another = toSort;
        start = System.currentTimeMillis();
        BubbleSort bubbleSort = new BubbleSort();
        bubbleSort.sort(another); //zmereni casu
        stop = System.currentTimeMillis();
        System.out.println("Bubble: " + (stop - start) + " ms");

        another = toSort;
        start = System.currentTimeMillis();
        SelectionSort selectionSort = new SelectionSort();
        selectionSort.sort(another);
        stop = System.currentTimeMillis();
        System.out.println("Selection: " + (stop - start) + " ms");

//        int[] arr = new int[10_000_000];
//        for (int i = 0; i < arr.length; i++) {
//            arr[i] = 10_000_000 - i;
//        }
//        System.out.println(Arrays.toString(arr));
//        Arrays.sort(arr);
//        System.out.println(Arrays.toString(arr));
//        System.out.println("Default sort done!");
//        QuickSort qs = new QuickSort();
//        qs.sort(arr);
//        System.out.println(Arrays.toString(arr));
    }
}
