package III.fileworks;

import fileworks.DataExport;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class WritingExamples {
    public static void main(String[] args) throws IOException {
        DataExport de = new DataExport("output.txt");
        for (int i = 0; i < 1000; i++) {
            de.writeLine(String.valueOf((int)(Math.random()*4001)));
        }
        de.finishExport();

        //Scanner - nema write variantu

        //po znacich
        FileWriter fw = new FileWriter("output2.txt");

        for (int i = 0; i < 1000; i++) {
            fw.write(String.valueOf((int)(Math.random()*4001)));
            fw.write('\n');
        }
        fw.close();

        //po radcich
        BufferedWriter bw = new BufferedWriter(new FileWriter("output3.txt"), 5460); //sz predstavuje velikost souboru v Bajtech
        for (int i = 0; i < 1000; i++) {
            bw.write(String.valueOf((int)(Math.random()*4001)));
            bw.newLine();
        }
        //possible moznost
        //Vezme data z Bufferu a hodi je do souboru
        //Hodi se napr pri savovani her, pri navratu zase potrebuji pracovat s daty
//        bw.flush();

        //Vzdycky zakoncit .close
//        bw.close();

        //Vystup s formatem
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(new File("output4.txt"))));
        for (int i = 0; i < 1000; i++) {
            pw.println((int)(Math.random()*4001));
        }
        pw.close();

        String text = "abcdefghijklmnopqrstuvwxyz";
        System.out.println(text);
        System.out.println(Arrays.toString(text.getBytes()));





    }
}
