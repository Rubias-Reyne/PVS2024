package III.tests;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;

public class FileFilterTest {

    //        Filtering .txt files
    static ArrayList<File> getFilesByType(String dirPath, String fileType){
        ArrayList<File> filteredFiles = new ArrayList<>();
        File tempFile = new File(dirPath);
        if (!tempFile.exists() && tempFile.isDirectory()){
            return null;
        }
        File[] dirContent = tempFile.listFiles();
        for (File file : dirContent){
            if (file.isFile() && file.getName().endsWith(fileType)){
                filteredFiles.add(file);
            }
        }

        return filteredFiles;
    }
//    Comparator comparing by size
        final static Comparator<File> BY_SIZE = new Comparator<File>() {
            @Override
            public int compare(File o1, File o2) {
                return Long.compare(o1.length(),o2.length());
        }
    };
//    Function for printing sorted files
    static void printSortedFiles(ArrayList<File> files){
        files.sort(BY_SIZE);
        for (File file: files){
            System.out.println(file + ": " + file.length());
        }
    }
//    Formating output file
    static void readFromFile(File x, BufferedWriter y) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(x));
        String line;
        while ((line = br.readLine()) != null){
                y.write(line);
                y.newLine();
        }
        br.close();
    }
    public static void main(String[] args) throws IOException {
        String dirPath = "C:\\Users\\vladimir.topolcany\\IdeaProjects\\PRG\\testData";
        String fileType = "txt";
        String name = null;
//        getFilesByType(dirPath,fileType).sort(BY_SIZE);
        ArrayList<File> actuallyFilteredFiles = getFilesByType(dirPath,fileType);
        BufferedWriter bw = new BufferedWriter(new FileWriter("po-et-ry.txt"));

//        DEBUG
//        printSortedFiles(actuallyFilteredFiles);
//        assert actuallyFilteredFiles != null
        if(actuallyFilteredFiles != null){
            for (File file: actuallyFilteredFiles){
                readFromFile(file, bw);
            }
        }
        bw.close();
    }
}
