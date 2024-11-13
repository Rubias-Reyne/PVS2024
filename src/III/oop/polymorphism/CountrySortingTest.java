package III.oop.polymorphism;

import fileworks.DataImport;

import java.util.ArrayList;
import java.util.Collections;

public class CountrySortingTest{

    static ArrayList<CountryTest> loadData(String filePath){
        ArrayList<CountryTest> countries = new ArrayList<>();

        DataImport di = new DataImport(filePath);
        String line;
        String[] split;

        while (di.hasNext()){
            line = di.readLine();
            split = line.split(",");
            countries.add(new CountryTest(split[0], Integer.parseInt(split[1]), Double.parseDouble(split[2])));
        }

        di.finishImport();
        return countries;
    }

    public static void main(String[] args) {
        ArrayList<CountryTest> countries = loadData("country.txt");
        System.out.println(countries);
        System.out.println("Natural ordering");
        System.out.println();
//        System.out.println(countries.get(1).compareTo(countries.get(2)));;

//        Collections.sort(countries);
        System.out.println(countries);
//        Collections.sort(countries);
//        Collection.sort(countries, new CountryComparator)
        for (int i = 0; i < 10; i++) {
//            countries.get(i).compareTo(countries.get(5));
        }
    }
}

class CountryTest implements Comparable<Country>{
    String name;
    int population;
    Double area;
    Double hustota = area / population;

    public CountryTest(String name, int population, Double area) {
        this.name = name;
        this.population = population;
        this.area = area;
    }

    @Override
    public String toString() {
        return "\n" + name + ", " + population + ", " + area;
    }

    @Override
    public int compareTo(Country o) {
        return this.population - o.population;
    }
//    @Override
//    public int compareTo(Country o) {
//        return o.name.compareTo(this.name);
//    }

//    @Override
//    public int compareTo(Country o) {
//        return this.hustota - o.hustota;
//    }
}

