package III.oop.collecting;

import java.lang.reflect.Array;
import java.net.Inet4Address;
import java.util.ArrayList;
import java.util.LinkedList;

public class Lisitng {
    public static void main(String[] args) {
        ArrayList<Integer> numbers = new ArrayList<>();
//        LinkedList<Integer> alsoNumbers = new LinkedList<>(); //Ma first, last, data (muze chodit tam i zpet)

        numbers.add(5);
        System.out.println(numbers);
        ArrayList<Integer> stillNumbers = new ArrayList<>();
        stillNumbers.add(5);
        stillNumbers.add(10);
        stillNumbers.add(12);
        stillNumbers.add(8);
        numbers.addAll(stillNumbers); //prida na konec
        System.out.println(numbers);

        //problematicke s Integer protoze muze urcit jen index, nikoliv hodnotu
        numbers.remove(5);

        //reseni
        ArrayList<Integer> stillAlsoNumbers = new ArrayList<>();
        stillAlsoNumbers.add(5);
        numbers.removeAll(stillAlsoNumbers);

        //skvele funguje pro String etc.
        ArrayList<String> words = new ArrayList<>();
        words.add("Hello");
        words.add("World");
        words.remove("Hello");
        words.remove(1);

        System.out.println(numbers.get(5));
        System.out.println(numbers.contains(6)); //vraci boolean ig?
        System.out.println(numbers.indexOf(12));
        System.out.println(numbers.lastIndexOf(12));
        System.out.println(numbers.size());
        System.out.println(numbers);

        //pouze objekty (ne int)
//        String[] simpleWords = (String[]) words.toArray();

        numbers.add(5,10);  //prida na index x hodnotu y, zbytek posune dale
        numbers.set(5,20);  //zmeni na indexu x hodnotu na y




    }
}
