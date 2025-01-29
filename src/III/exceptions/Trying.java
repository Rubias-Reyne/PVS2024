package III.exceptions;

import java.io.*;
import java.util.Random;

public class Trying {
    public static void main(String[] args) {
        Random r = new Random();
        try{
            PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(new File("ss"))));
            for (int i = 0; i < 10; i++) {
                pw.println(r.nextInt(0,1000));
            }
            pw.close();
        }catch (IOException e){
            System.out.println("Problem se cteni souboru");
        }finally {
            System.out.println("Prace se souborem ");
        }
    }
}
