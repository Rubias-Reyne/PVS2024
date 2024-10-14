package III.polymorphism;

import java.util.Objects;

public class Movie {
    String name;
    int yearOfRelease;
    int length;
    int mvID;

    public Movie(String name, int yearOfRelease, int length, int mvID) {
        this.name = name;
        this.yearOfRelease = yearOfRelease;
        this.length = length;
        this.mvID = mvID;
    }

    public static void main(String[] args) {
        Movie shrek = new Movie("Shrek 2", 2004, 5580, 2);
        Movie alsoShrek = new Movie("Shrek 2", 2004, 5580, 2);
        Movie alsoAnotherShrek = new Movie("Shrek 2", 2004, 5520, 2);

        System.out.println(shrek == alsoShrek);
        System.out.println(shrek.equals(alsoShrek));
        System.out.println(alsoAnotherShrek.equals(alsoShrek));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Movie movie = (Movie) o;
        return yearOfRelease == movie.yearOfRelease && mvID == movie.mvID && Objects.equals(name, movie.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, yearOfRelease, mvID);
    }

    @Override
    public String toString() {
        return name + "(" + yearOfRelease + ")";
    }


}
