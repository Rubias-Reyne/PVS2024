package III.fileworks;

import java.awt.image.AreaAveragingScaleFilter;
import java.io.File;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Comparator;

public class FileFilter {

    static ArrayList<File> getFilesByType(String dirPath, String fileType){
        ArrayList<File> filteredFiles = new ArrayList<>();
        File wannabeDir = new File(dirPath);
        if (!wannabeDir.exists() && wannabeDir.isDirectory()){
            return null;
        }
        File[] dirContent = wannabeDir.listFiles();
        for (File file : dirContent){
            if (file.isFile() && file.getName().endsWith(fileType)){
                filteredFiles.add(file);
            }
        }

        return filteredFiles;
    }
//    final static Comparator<File> BY_SIZE = new Comparator<File>() {
//        @Override
//        public int compare(File o1, File o2) {
//            return Long.compare();
//        }
//    }
//    static void printSortedFiles(ArrayList<File> files){
//        files.sort(BY_SIZE.reversed());
//        for (File file: files){
//            System.out.println(file + ": " + file.length());
//        }
//    }
    public static void main(String[] args) {

    }
}
