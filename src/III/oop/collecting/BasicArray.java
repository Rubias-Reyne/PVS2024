package III.oop.collecting;

import java.util.Arrays;

public class BasicArray {

    public static void main(String[] args) {
        //staticky
        int[] numbers = {1,5,6,87};

        //pouze deklarace
        int[] alsoNumbers = new int[10];

        //iterace
        for (int i = 0; i < alsoNumbers.length; i++) {
            alsoNumbers[i] = (int)(Math.random() * 100);
        }

        //co se stane s numbers?
        numbers = alsoNumbers;
//        {5,6,2,48} sezere garbage collector]

//        kopie pole !neni to same jako pole = takyPole
        int[] yetAnotherNumbers = Arrays.copyOf(alsoNumbers, 15);

        yetAnotherNumbers[5] = 20;
        numbers[5] = 30;
        alsoNumbers[5] = 40;

//        int[] je primitivni, nema zadne metody, pro vypis musim zavolat knihovnu
        System.out.println(yetAnotherNumbers);

//        jednoducha ukazka razeni
        Arrays.sort(yetAnotherNumbers); //pouzije quicksort
        System.out.println(Arrays.toString(yetAnotherNumbers));


    }
}
