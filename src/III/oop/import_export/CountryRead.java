package III.oop.import_export;

import fileworks.DataImport;

public class CountryRead {
    public static void main(String[] args) {
        DataImport di = new DataImport("countries.txt");
//        DataExport de = new DataExport("OutputCountries.txt");
//        di.printFile();
        // TODO: 23.09.2024 - spocitat prumerny vek doziti
        // TODO: 23.09.2024 - nejvetsi zeme rozlohou
        // TODO: 23.09.2024 - pocet zemi v Evrope
        String line;
        String[] params;
        Country c;
        Country biggestAreaCountry = new Country("","",0,0);
        int biggestArea = 0;
        int averageAmount = 0;
        int averageCount = 0;
        int EuropeCount = 0;

        while(di.hasNext()){
            line = di.readLine();
            params = line.split(";");
            c = new Country(
                    params[0],
                    params[1],
                    Integer.parseInt(params[2]),
                    Double.parseDouble(params[3])
            );
            if (biggestArea < c.area){
                biggestArea = c.area;
                biggestAreaCountry = c;
//                System.out.println(biggestAreaCountry);
            }
            averageAmount += c.expected;
            averageCount ++;
//            System.out.println(averageCount + " " + averageAmount);
            if (c.continent.equals("Europe")){
                EuropeCount = EuropeCount + 1;
            }
//            de.writeLine(c.toString());
//            System.out.println(c);

        }
        System.out.println("prumerny vek doziti je: " + averageAmount/averageCount);
        System.out.println("v Evrope je " + EuropeCount + " zemi");
        System.out.println("nejvetsi zeme rozlohou je: " + biggestAreaCountry.name);

        di.finishImport();
//        de.finishExport();
    }
} class Country{
    String name,continent;
    int area;
    double expected;

    public Country(String name, String continent, int area, double expected) {
        this.name = name;
        this.continent = continent;
        this.area = area;
        this.expected = expected;
    }

    @Override
    public String toString() {
        return "Country{" +
                "name='" + name + '\'' +
                ", continent='" + continent + '\'' +
                ", area=" + area +
                ", expected=" + expected +
                '}';
    }
}
