package III.tests;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class LambdaTest {
    public static void main(String[] args) {
        List<String> lines = null;
        try {
            lines = Files.readAllLines(Paths.get("C:\\Users\\vladimir.topolcany\\IdeaProjects\\PVS2024\\Movies.txt"));
            ArrayList<Movie> movies = new ArrayList<>();
            String[] params;
            int count;
            for (String line : lines) {
                params = line.split(";");
                movies.add(
                        new Movie(params[0],
                                Integer.parseInt(params[1]),
                                Double.parseDouble(params[2]),
                                Integer.parseInt(params[3]))
                );
            }
            movies.stream()
                    .filter(movie -> movie.length > 7200)
                    .filter(movie -> movie.year >= 2000 && movie.year <= 2010)
                    .forEach(System.out::println);

            int ratingPercentage = (int) movies.stream()
                    .filter(movie -> movie.rating > 6.0)
                    .count();
            System.out.println(ratingPercentage);
            System.out.println(((double)ratingPercentage/(double)movies.size())*100 + "%");

            movies.stream()
                    .filter(movie -> movie.rating < 4)
                    .mapToInt(movie -> movie.length)
                    .sum();

            double avg = movies.stream()
                    .filter(movie -> movie.year >= 1995 && movie.year <= 2008)
                    .mapToDouble(movie -> movie.rating)
                    .average()
                    .orElse(0);
            System.out.println(avg);

        } catch (IOException e) {
            System.out.println(":(," + e.getMessage());
        }

    }

}class Movie {
    String name;
    int year;
    double rating;
    int length;

    public Movie(String name, int year, double rating, int length) {
        this.name = name;
        this.year = year;
        this.rating = rating;
        this.length = length;
    }

    public String getName() {
        return name;
    }

    public int getYear() {
        return year;
    }

    public double getRating() {
        return rating;
    }

    public int getLength() {
        return length;
    }

    @Override
    public String toString() {
        return name + " (" + year + ")";
    }
}
