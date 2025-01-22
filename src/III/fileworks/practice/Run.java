package III.fileworks.practice;

import III.fileworks.serials.Coordinates;
import III.oop.import_export.Compare;
import fileworks.DataImport;
import org.w3c.dom.ls.LSOutput;

import java.io.*;
import java.util.*;

public class Run {
    static List<Movie> getFilmsFromFile(String path){
        List<Movie> films = new ArrayList<>();
        File file = new File(path);
        DataImport di = new DataImport(path);
        Movie m;
        String line;
        String[] params;
        if (!(file.isFile() || file.exists())){
            return null;
        }
        while(di.hasNext()){
            line = di.readLine();
            params = line.split(";");
            films.add(m = new Movie(
                    params[0],
                    Integer.parseInt(params[1]),
                    Double.parseDouble(params[2]),
                    Integer.parseInt(params[3])));
        }
        di.finishImport();
        return films;
    }
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        List<Movie> movies = getFilmsFromFile("C:\\Users\\vladimir.topolcany\\IdeaProjects\\PRG\\Movies.txt");
        List<Playlist> playlists = new ArrayList<>();
        List<Integer> options = new ArrayList<>();
        options.add(1);
        options.add(2);
        options.add(3);
        options.add(4);
        options.add(0);
        options.add(-1);
        Scanner sc = new Scanner(System.in);
        int userInput = 10;

        System.out.println("Hello and welcome!");
        while (userInput != -1 && userInput != 0){
            System.out.println("PRESS THE NUMBER OF YOUR CHOICE");
            System.out.println("------------------------------------------------------");
            System.out.println("1\t -> Write list of all movies");
            System.out.println("2\t -> Write list of all playlists");
            System.out.println("3\t -> Create a new playlist");
            System.out.println("4\t -> Edit a playlist");
            System.out.println("0\t -> Save & exit");
            System.out.println("-1\t -> Exit without saving");
            System.out.println("------------------------------------------------------");
            userInput = sc.nextInt();
            if (!options.contains(userInput)){
                System.out.println("INCORRECT INPUT, TRY AGAIN:");
            }

            switch (userInput){
                case 1:
                    for(Movie movie:movies){
                        System.out.println(movie);
                    }
                    break;
                case 2:
                    for(Playlist playlist:playlists){
                        System.out.println(playlist);
                    }
                    break;
                case 3:
                    System.out.println("Insert the name of your new playlist");
                    playlists.add(new Playlist(sc.nextLine()));
                    userInput = sc.nextInt();
                    while (userInput != 0 && userInput != -1){

                    }
                    break;
                case 0:
                    break;
                case -1:
                    break;

            }
        }

    }
}
