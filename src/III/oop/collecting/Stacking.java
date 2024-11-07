package III.oop.collecting;

public class Stacking {
    public static void main(String[] args) {


    }

}
class ArrayStack{
    int[] data;
    int freeIndex;

    void expandArray(){
        int[] newOne = new int[data.length * 2];
        for (int i = 0; i < data.length; i++) {
            newOne[i] = data[i];
        }
        data = newOne;
    }

    ArrayStack(int capacity){
        data = new int[capacity];
        freeIndex = 0;
    }

    void push(int toAdd){
        if (freeIndex > data.length){
            data[freeIndex] = toAdd;
            freeIndex++;
        }else {
            System.out.println("out of capacity :(");
        }
    }

    int pop(){
        if (freeIndex > 0){
            int toReturn = data[freeIndex-1];
            freeIndex--;
//            return data[freeIndex--];
        }
        return -1;
    }

    int peek(){
        if (freeIndex > 0 ){
            return data[freeIndex-1];
        }
        return -1;
    }
}
