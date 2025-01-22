package III.fileworks.practice;

import java.util.ArrayList;
import java.util.List;

/**
 * Kolekce vsech filmu v playlistu
 * @author  bohac
 * @version 22-1-25
 */
public class Playlist {

    /**
     * Kolekce vsech filmu v playlistu
     */
    List<Movie> programme;
    /**
     * Jmeno pro playlist filmu
     */
    String name;

    /**
     * Konstruktor pro vytvoreni playlistu rovnou s nejakou sadou filmu
     * @param name nazev pro playlist
     * @param programme pocatecni list, do kteroho lze vkladat
     */
    public Playlist(List<Movie> programme, String name){
        this.name = name;
        this.programme = programme;
    }

    /**
     * Konstruktor pro vytvoreni prazdneho playlistu
     * @param name nazev pro playlist
     */
    public Playlist(String name){
        this.name = name;
        this.programme = new ArrayList<>();
    }


    @Override
    public String toString(){
        //Vypise ve formatu: PlaylistName (doba trvani ve formatu mm:ss):
        //
        //                      movie1.toString()...
        return null;
    }

    /**
     * Metoda pro celkove doby trvani ve vterinach
     * @return
     */
    public int getTotalDuration(){
        return 0;
    }
}
