package III.map;

import III.oop.reference.ParsePerson;
import org.w3c.dom.ls.LSOutput;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class SeriesMapping {
    static void printStructure(List<Series> series){
        series.forEach(s -> {
            System.out.println(s.getTitle());

            Map<Integer, List<Episode>> seasonsMap = s.getEpisodes().stream()
                    .collect(Collectors.groupingBy(Episode::getSeason));

            seasonsMap.forEach((season, episode) -> {
                System.out.println("\tS: " + season);
                episode.forEach(e -> System.out.println("\t\t" + e.getEpisodeNumber()));
            });
        });
    }
    public static void main(String[] args) throws IOException {
        List<Series> seriesList = Files.lines(Paths.get("series.csv"))
                .skip(1)
                .map(line -> line.split(";"))
                .map(splitLine -> new Series(splitLine[0], splitLine[1]))
                .toList();

        List<Episode> episodeList = Files.lines(Paths.get("episodes.csv"))
                .skip(1)
                .map(line -> line.split(";"))
                .map(splitLine -> new Episode(Integer.parseInt(splitLine[0]), Integer.parseInt(splitLine[1]), Double.parseDouble(splitLine[2]), splitLine[3])).toList();

        seriesList.forEach(series -> {
            episodeList.stream()
                    .filter(episode -> episode.getEpisodeID().equals(series.getSeriesID()))
                    .forEach(series::addEpisode);
        });

        printStructure(seriesList);

    }
}
class Series {
    String seriesID, title;
    List<Episode> episodes;

    public Series(String seriesID, String title) {
        this.seriesID = seriesID;
        this.title = title;
        episodes = new ArrayList<>();
    }

    void addEpisode(Episode episode){
        this.episodes.add(episode);
    }

    public String getSeriesID() {
        return seriesID;
    }

    public String getTitle() {
        return title;
    }

    public List<Episode> getEpisodes() {
        return episodes;
    }
}
class Episode {
    String episodeID;
    int episodeNumber;
    int season;

    double rating;

    public Episode(int season, int episodeNumber, double rating, String episodeID) {
        this.episodeID = episodeID;
        this.episodeNumber = episodeNumber;
        this.season = season;
        this.rating = rating;
    }

    public String getEpisodeID() {
        return episodeID;
    }

    public int getEpisodeNumber() {
        return episodeNumber;
    }

    public int getSeason() {
        return season;
    }

    public double getRating() {
        return rating;
    }

//    @Override
//    public String toString() {
//        return super.toString();
//    }
}
