package III.fileworks;

import java.io.*;

public class ReadPractice {
    public static void main(String[] args) throws IOException {

        //FileReader >>> BufferReader

        File file = new File("C:\\Users\\vladimir.topolcany\\IdeaProjects\\PRG\\PraciceText.txt");

        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
        String line;
        int sentenceCount = 0, lineCount = 0, wordCount = 0;
        while ((line = bufferedReader.readLine()) != null){
            if(bufferedReader.read() == '.' || bufferedReader.read() == '!' || bufferedReader.read() == '?' ){
                sentenceCount++;
            }
            System.out.println(line);
            lineCount++;
        }
        bufferedReader.close();
        System.out.println(lineCount);
        System.out.println(sentenceCount);
        System.out.println(wordCount);
    }
}
