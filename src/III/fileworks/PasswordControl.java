package III.fileworks;

import java.awt.image.AreaAveragingScaleFilter;
import java.io.*;
import java.util.ArrayList;

public class PasswordControl {
    static ArrayList<String> getFilesByType(String dirPath,String dirPath2) throws IOException {
        ArrayList<String> rightCombinations = new ArrayList<>();
        String line;
        String line2;
        File tempFile = new File(dirPath);
        File tempFile2 = new File(dirPath2);
        BufferedReader br = new BufferedReader(new FileReader(dirPath));
        BufferedReader br2 = new BufferedReader(new FileReader(dirPath2));

        //overi jestli soubory vubec existuji
        if (!tempFile.exists() && !tempFile2.exists()){
            return null;
        }
        //dokud jeden ze souboru ma co psat, uklada si kombinaci radku do listu
        while ((line = br.readLine()) != null && (line2 = br2.readLine()) != null){
            rightCombinations.add(line + "=" + line2);
        }
        br.close();
        br2.close();
        return rightCombinations;
    }
    static void isCorrect (ArrayList list) throws IOException {
        int count = 0;
        int lineCount = 0;
        String line;
        BufferedWriter bw = new BufferedWriter(new FileWriter("validLogins.txt"));

        //projede 5 souboru
        for (int i = 1; i <= 5; i++) {
            BufferedReader br = new BufferedReader(new FileReader("textFiles/dataPsswd/attempts_" + i + ".txt"));
            int a = 0;
            //dokud program nedorazi na konec souboru, overuje pravdivost jednotlivych radek
            while ((line = br.readLine()) != null){
                a++;
                lineCount++;
                //zde overuje
                if (list.contains(line)){
                    bw.write(line);
                    bw.newLine();
                    System.out.println("attepmpts_" + i + ": " + a + " valid");
                    count++;
                }
            }
            br.close();
        }
        bw.close();
        System.out.println("Count: " + count);
        System.out.println("% of all valid: " + (double)count/lineCount*100 + "%");
    }

    public static void main(String[] args) throws IOException {
        ArrayList<String> attemptList = getFilesByType(
                "C:\\Users\\vladimir.topolcany\\IdeaProjects\\PRG\\textFiles\\dataPsswd\\usernames.txt",
                "C:\\Users\\vladimir.topolcany\\IdeaProjects\\PRG\\textFiles\\dataPsswd\\AllPINs.txt");
        isCorrect(attemptList);
    }
}
