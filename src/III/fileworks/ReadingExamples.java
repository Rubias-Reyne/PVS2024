package III.fileworks;

import fileworks.DataImport;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Locale;
import java.util.Scanner;

public class ReadingExamples {
    public static void main(String[] args) throws IOException {
        File file = new File("data\\countries.txt");
        if (file.exists() && file.isFile()){
            DataImport di = new DataImport(file.getPath());
            while (di.hasNext()){
                System.out.println(di.readLine());
            }
            di.finishImport();
        }
        Scanner sc = new Scanner(file);
        sc.useLocale(Locale.TAIWAN);
//        sc.useDelimiter("\n");
        sc.useDelimiter(";");
        while (sc.hasNext()){
            System.out.println(sc.next());
            System.out.println(sc.next());
            System.out.println(sc.nextInt());
            System.out.println(sc.nextDouble());
        }
        sc.close();

        FileReader reader = new FileReader(file);
        int input;
        while ((input = reader.read()) != -1){
            System.out.println((char) input);
        }
        reader.close();
    }
}
