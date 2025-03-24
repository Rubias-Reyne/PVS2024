package III.streaming;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class DirStream
{
    public static void main(String[] args)
    {
        Path start = Paths.get("C:\\Users\\vladimir.topolcany\\IdeaProjects\\PVS2024");

        try(Stream<Path> fileStream = Files.walk(start))
        {
            fileStream
                    .forEach(System.out::println);
        }
        catch (IOException e)
        {
            System.out.println(e.getMessage());
        }
    }
}
