package III.oop.import_export;

import fileworks.DataExport;
import fileworks.DataImport;

public class Song {
    public static void main(String[] args) {
        DataImport di = new DataImport("Tracks.txt");
        DataExport de = new DataExport("Outputsongs.txt");

        String line;
        String[] params;
        Song s;

        while(di.hasNext()){
            line = di.readLine();
            params = line.split(";");
            s = new Song(
                    params[0],
                    Integer.parseInt(params[1]),
                    Double.parseDouble(params[2]),
                    Integer.parseInt(params[3]));
            de.writeLine(s.toString());
            System.out.println(s);
        }
        de.finishExport();
        di.finishImport();
    }
    String name;
    int yearOfRelease;
    double rating;
    int seconds;

    public Song(String name, int yearOfRelease, double rating, int seconds) {
        this.name = name;
        this.yearOfRelease = yearOfRelease;
        this.rating = rating;
        this.seconds = seconds;
    }

    @Override
    public String toString() {
        return name + "(" + yearOfRelease + ") " + timeFormat(seconds);
    }

    String timeFormat(int s){
        return (s/60) + ":" + (s%60);
    }
}
