package III.streaming;

import java.util.HashMap;

public class Basic {
    public static void main(String[] args) {
        HashMap<String, String> countries = new HashMap<>();

        countries.put("USA", "Washington DC");
        countries.put("Finland", "Helsinki");
        countries.put("Iceland", "Reykjavik");
        System.out.println(countries.get("Iceland"));

    }
}
