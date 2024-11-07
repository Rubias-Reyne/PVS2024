package III.oop.collecting;

import java.util.EmptyStackException;

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
class Link{
    int data;
    Link next;

}
class LinkStack{
    Link top;
    LinkStack(){
        top = null;
    }

    void push(int toAdd){
        if (top == null){
            top = new Link();
            top.data = toAdd;
        } //Uz tam neco je
        else{
            Link newTop = new Link();
            newTop.data = toAdd;
            newTop.next = top; // stary vrchol bude hned za novym
            top = newTop; //prohlasim za novy vrchol
        }
    }
    int pop(){
        if (top == null){
            //idealne hodit chybu, hodi ji ale i tak
            throw new EmptyStackException();
        }
        int toReturn = top.data;
        top = top.next; //to, co bylo pod topem, je nyni top (me,usi tam byt nic)
        return toReturn;
    }
    int peek(){
//        if (top == null){
//            throw new NullPointerException();
//        }
        return top.data;
    }


}
