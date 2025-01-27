package III.exceptions;

import java.util.Scanner;

public class Showcase {
    public static void main(String[] args) {
        int number;
        String alsoNumber;

        Scanner sc = new Scanner(System.in);
        System.out.println();

        try {


            //Exception je stejne spatne jako prazdny catch block, neurpesnuje to problem takze se i tezce resi
            //Vzdy byt konkretnejsi, takze radsi napr. ArrayIndexOutOfBoundsException nebo podobne
        }catch (Exception e){
            //Vzdy neco napsat do catch blocku
            //Upresnit problem, pro snadnejsi pouzivani a reseni chyb
        }
    }
}
