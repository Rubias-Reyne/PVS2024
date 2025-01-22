package III.fileworks.practice;

import fileworks.DataImport;

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
    public static Integer getValueInt(Scanner input, int minValue, int maxValue) {

        int value = 0;

        while (true) {
            try {

                value = input.nextInt();
                if((value < minValue) || (value > maxValue)) {
                    // ERROR message goes here
                    System.out.println("Incorrect input, try again");
                } else {
                    break; // Input successful, break loop.
                }
            }
            catch (InputMismatchException IME) {
                // ERROR message goes here.
                System.out.println("Incorrect input, try again");
                input.nextLine(); // Discards input so user can try again
            }
        }
        return (value);
    }
    public static String getValueString(Scanner input) {

        String value = null;

        while (true) {
            try {
                value = input.nextLine();
                break;
            } catch (InputMismatchException IME) {
                // ERROR message goes here.
                System.out.println("Incorrect input, try again");
                input.nextLine(); // Discards input so user can try again
            }
        }
        return value;
    }
    static Playlist playlistCreate(String name){
        Playlist pl = new Playlist(name);
        while (true) {
            int value = getValueInt(sc, -1, movies.size()-1);
            if(value== -1){
                break;
            }else if(value == 0){
                for (int i = 1; i < movies.size()+1; i++) {
                    System.out.println(i + " -> " + movies.get(i-1));
                }
            }
            else{
                pl.programme.add(movies.get(value));
                System.out.println("We just added to your playlist a movie called: " + movies.get(value-1).name);
            }
        }
        return pl;
    }
    static List<Movie> movies = getFilmsFromFile("Movies.txt");
    static Scanner sc = new Scanner(System.in);
    static List<Playlist> playlists = new ArrayList<>();
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        String userInputString = "";
        int userInput = 10;

        System.out.println("Hello and welcome!");
        while (true){
            System.out.println("PRESS THE NUMBER OF YOUR CHOICE");
            System.out.println("------------------------------------------------------");
            System.out.println("1\t -> Write list of all movies");
            System.out.println("2\t -> Write list of all playlists");
            System.out.println("3\t -> Create a new playlist");
            System.out.println("4\t -> Edit a playlist");
            System.out.println("0\t -> Save & exit");
            System.out.println("-1\t -> Exit without saving");
            System.out.println("------------------------------------------------------");
            userInput = getValueInt(sc,-1,4);
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
                    System.out.println("Insert the name of your playlist: ");
                    playlists.add(playlistCreate(getValueString(sc)));
                    break;
                case 0:
                    break;
                case -1:
                    break;

            }
        }
    }
}
