package III.oop.polymorphism;

import fileworks.DataImport;

import java.util.ArrayList;

public class CountrySorting {

    static ArrayList<Country> loadData(String filePath){
        ArrayList<Country> countries = new ArrayList<>();
        DataImport di = new DataImport(filePath);
        String line;
        String[] split;
        while (di.hasNext()){
            line = di.readLine();
            split = line.split(";");
            countries.add(new Country(split[0], split[1], Integer.parseInt(split[2]),Double.parseDouble(split[3])));
        }

        di.finishImport();
        return countries;
    }

    public static void main(String[] args) {
        ArrayList<Country> countries = loadData("countries.txt");
        System.out.println(countries);
        System.out.println("Natural ordering");
//        Collections.sort(countries);
//        Collection.sort(countries, new CountryComparator)
    }
}

class Country {
    String name, continent;
    int population;
    double lifeExpectancy;

    public Country(String name, String continent, int population, double lifeExpectancy) {
        this.name = name;
        this.continent = continent;
        this.population = population;
        this.lifeExpectancy = lifeExpectancy;
    }

    @Override
    public String toString() {
        return "\n" + name + ", " + population + ", " + continent + ", " + lifeExpectancy;
    }


}
//class ContryComparator implements Comparator<Country>{
//
//}
