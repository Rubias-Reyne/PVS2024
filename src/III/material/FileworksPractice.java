package III.material;

import java.io.*;
import java.util.LinkedList;

public class FileworksPractice {
    static void readFromFile(File x, BufferedWriter y) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(x));
        String line;
        while ((line = br.readLine()) != null){
            if (Integer.parseInt(line) % 2 == 0){
                y.write(line);
                y.newLine();
            }
        }
        br.close();
    }
    public static void main(String[] args) throws IOException {

        BufferedWriter bw = new BufferedWriter(new FileWriter("output5.txt"));
        File f1 = new File("C:\\Users\\vladimir.topolcany\\IdeaProjects\\PRG\\output.txt");
        File f2 = new File("C:\\Users\\vladimir.topolcany\\IdeaProjects\\PRG\\output2.txt");
        File f3 = new File("C:\\Users\\vladimir.topolcany\\IdeaProjects\\PRG\\output3.txt");
        File f4 = new File("C:\\Users\\vladimir.topolcany\\IdeaProjects\\PRG\\output4.txt");

        readFromFile(f1, bw);
        readFromFile(f2, bw);
        readFromFile(f3, bw);
        readFromFile(f4, bw);

        bw.close();

    }

}
