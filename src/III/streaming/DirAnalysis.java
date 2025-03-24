package III.streaming;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DirAnalysis
{
    public static void analyzeDir(String path) throws IOException
    {
        Path p = Paths.get(path);
        try(Stream<Path> fileStream = Files.walk(p))
        {
//            fileStream.forEach(System.out::println);

            List<Path> filePaths = fileStream
                    .filter(Files::isRegularFile)
                    .toList();
            System.out.println(filePaths);

            Map<String, Long> fileTypCount = filePaths.stream()
                    .collect(Collectors.groupingBy(filePath -> getExtension(filePath.getFileName().toString()),Collectors.counting()//poxty souboru v grupe
                             ));
//            System.out.println(fileTypCount); //ew
            fileTypCount.forEach((ext,count) -> System.out.println(ext + ":" + count + " souboru"));

            Map<String, Long> fileTypeSizeTotal = filePaths.stream()
                    .collect(Collectors.groupingBy(filePath -> getExtension(filePath.getFileName().toString()),Collectors.summingLong(p1 -> {
                        try{
                            return Files.size(p1);
                        }catch(IOException e){
                            return 0L;
                        }
                    })));
            System.out.println(fileTypeSizeTotal);
        }
        catch (IOException e)
        {
            System.out.println(e.getMessage());
        }
    }
    static String getExtension(String fileName){
        int dotIndex = fileName.lastIndexOf(".");
        return (dotIndex == -1 ) ? "NO_TYPE" : fileName.substring(dotIndex+1).toLowerCase();
    }
    public static void main(String[] args)
    {
        try
        {
        analyzeDir("C:\\Users\\vladimir.topolcany\\IdeaProjects\\PVS2024");
        }
        catch (IOException e)
        {
            System.out.println("zzz");
        }
    }
}
