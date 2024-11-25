package III.oop.collecting;

import java.awt.image.AreaAveragingScaleFilter;
import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Setting {
    public static void main(String[] args) {
        int[] array = new int[100];
        for (int i = 0; i < array.length; i++) {
            array[i] = (int)(Math.random()*121);
        }

        System.out.println(Arrays.toString(array));
        Set<Integer> uniqueNumbers = new HashSet<>();
        uniqueNumbers.add(5);
        System.out.println(uniqueNumbers);
        //vygeneruj 100 unikatnich cisel
        ArrayList<Integer> trulyUniqNumbers = new ArrayList<>();
        while (uniqueNumbers.size() < 100){
            uniqueNumbers.add((int)(Math.random()*121));
        }
        System.out.println(uniqueNumbers);

        //je neco v setu? a)
        System.out.println(uniqueNumbers.contains(6));

        //nevijde tak vypise false
        System.out.println(uniqueNumbers.add(6));

        //vytvor arrayList, vygenerovat dalsich hodne unikatnich cisel a pak porovnat uniq
        ArrayList<Integer> subsetNumbers = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            subsetNumbers.add((int)(Math.random()*200));
        }
        System.out.println(subsetNumbers);
        HashSet<Integer> subSet = new HashSet<>(subsetNumbers);
        System.out.println(subSet);
        //kolik cisel je unikatnich:
        System.out.println(subSet.size());

        //kolikrat tam byly non-uniq
        System.out.println(subsetNumbers.size() - subSet.size());

        //frontyu, list, stack (mozna)
    }
}
