package III.fileworks.practice;

public class Movie{
    String name;
    int yearOfRelease;
    double rating;
    int duraiton;

    public Movie(String name, int yearOfRelease, double rating, int duraiton) {
        this.name = name;
        this.yearOfRelease = yearOfRelease;
        this.rating = rating;
        this.duraiton = duraiton;
    }

    @Override
    public String toString() {
        return "Name: " + name + " YOR: " + yearOfRelease + " Rating: " + rating + " Duration: " + duraiton;
    }
    

//a vse pro vas potrebne
}
