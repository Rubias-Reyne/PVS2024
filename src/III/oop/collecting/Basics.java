package III.oop.collecting;

import III.oop.import_export.Compare;

public class Basics {

    static <E> void printArray(E[] array){
        System.out.println();
        for(E type: array){
            System.out.println(type + " ");
        }
        System.out.println();
    }

    public static <T extends Comparable<T> > void sort(T[] data){
        int n = data.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (data[j].compareTo(data[j+1]) > 0){
                    T temp = data[j];
                    data[j] = data[j + 1];
                    data[j + 1] = temp;
                }
            }
        }
    }
    public static void main(String[] args) {

        Integer[] numbers = {1, 56, 789, 1563, 15};
        String[] words = {"delta", "alpha", "beta", "gamma"};
        Double[] realNumbers = {Math.PI, -Math.sqrt(5), 456.4, 7.5,4.78};

        sort(numbers);
        sort(words);
        sort(realNumbers);

        printArray(numbers);
        printArray(words);
        printArray(realNumbers);
    }
}
