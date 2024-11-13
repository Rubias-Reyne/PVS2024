package III.oop.polymorphism;

import fileworks.DataImport;

import java.util.ArrayList;
import java.util.Collections;

public class CountrySorting {

    static ArrayList<Country> loadData(String filePath){
        ArrayList<Country> countries = new ArrayList<>();
        DataImport di = new DataImport(filePath);
        String line;
        String[] split;
        while (di.hasNext()){
            line = di.readLine();
            split = line.split(";");
            countries.add(new Country(split[0], Integer.parseInt(split[1]), Integer.parseInt(split[2])));
        }

        di.finishImport();
        return countries;
    }

    public static void main(String[] args) {
        ArrayList<Country> countries = loadData("countries.txt");
        System.out.println(countries);
        System.out.println("Natural ordering");
        System.out.println(countries.get(1).compareTo(countries.get(2)));;

        Collections.sort(countries);
        System.out.println(countries);
//        Collections.sort(countries);
//        Collection.sort(countries, new CountryComparator)
    }
}

class Country implements Comparable<Country>{
    String name;
    int population, area;

    public Country(String name, int population, int area) {
        this.name = name;
        this.population = population;
        this.area = area;
    }

    @Override
    public String toString() {
        return "\n" + name + ", " + population + ", " +area;
    }

    @Override
    public int compareTo(Country o) {
        return this.population - o.population;
    }
}
//class ContryComparator implements Comparator<Country>{
//
//}
