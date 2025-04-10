package III.map;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class SongProcessing {

    static class Track{
        String name;
        int duration;

        public Track(String name, int duration) {
            this.name = name;
            this.duration = duration;
        }

        public String getName() {
            return name;
        }

        public int getDuration() {
            return duration;
        }
    }

    static class Album{
    String name;
    List<Track> songs;
    int id;

        public Album(String name, List<Track> songs, int id) {
            this.name = name;
            this.songs = songs;
            this.id = id;
        }

        public Album(String name) {
            this.name = name;
            this.songs = new ArrayList<>();
        }

        void addSong(Track song){
            songs.add(song);
        }
        public String getName() {
            return name;
        }

        public List<Track> getSongs() {
            return songs;
        }

        public int getId() {
            return id;
        }
    }

    static class Band{
        String name;
        List<Album> albums;
        int id;

        public Band(String name, List<Album> albums, int id) {
            this.id = id;
            this.name = name;
            this.albums = albums;
        }

        public Band(String name) {
            this.name = name;
            this.albums = new ArrayList<>();
        }

        void addAlbum(Album a){
            albums.add(a);
        }
        public String getName() {
            return name;
        }

        public List<Album> getAlbums() {
            return albums;
        }

        public int getId() {
            return id;
        }
    }

    public static void main(String[] args) throws IOException {
//        List<Band> bands = Files.lines(Paths.get("artists.csv"))
//                .skip(1)
//                .map(line -> line.split(";"))
//                .map(splitLine -> new Band(Integer.parseInt(splitLine[0]),splitLine[1])).toList();
    }

}
