package III.oop.import_export;

import fileworks.DataImport;

import java.util.Arrays;

public class Compare {
//    extends Comparable

    public static void main(String[] args) {
        DataImport di = new DataImport("Movies.txt");
        Compare c;
        String line;
        String[] params;

        while(di.hasNext()){
            line = di.readLine();
            params = line.split(";");
            c = new Compare(params[0],
            Integer.parseInt(params[1]),
            Double.parseDouble(params[2]),
            Integer.parseInt(params[3]));
            System.out.println(c);
        }
        di.finishImport();

    }
    String name;
    int year;
    double rating;
    int ID;

    public Compare(String name, int year, double rating, int ID) {
        this.name = name;
        this.year = year;
        this.rating = rating;
        this.ID = ID;
    }

    @Override
    public String toString() {
        return "Compare{" +
                "name='" + name + '\'' +
                ", year=" + year +
                ", rating=" + rating +
                ", ID=" + ID +
                '}';
    }

//    @Override
//    public int compareTo(Object o) {
//        return 0;
//    }
}
