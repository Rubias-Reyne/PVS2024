package III.fileworks;

import fileworks.DataImport;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
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

        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
        String line;
        while ((line = bufferedReader.readLine()) != null){
            System.out.println(line);
        }
        bufferedReader.close();

        List<String> lines = Files.readAllLines(Paths.get("data\\countries.txt"));
        System.out.println(lines);
        System.out.println(lines.size());
    }
}
