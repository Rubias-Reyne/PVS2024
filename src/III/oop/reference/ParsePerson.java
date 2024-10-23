package III.oop.reference;

import fileworks.DataImport;

public class ParsePerson {
    String fullName;
    int Height;
    int Weight;
    int age;




    public static void main(String[] args) {
        DataImport di = new DataImport("osoba.txt");
        String line;
        String[] atributes;
        ParsePerson p;
        while(di.hasNext()){
            line = di.readLine();
            atributes = line.split(",");
            p = new ParsePerson(atributes[0],
                    Integer.parseInt(atributes[1]),
                    Integer.parseInt(atributes[2]),
                    Integer.parseInt(atributes[3]));
        }
        di.finishImport();
    }

    public ParsePerson(String fullName, int height, int weight, int age) {
        this.fullName = fullName;
        Height = height;
        Weight = weight;
        this.age = age;
    }

    @Override
    public String toString() {
        return "ParsePerson{" +
                "fullName='" + fullName + '\'' +
                ", Height=" + Height +
                ", Weight=" + Weight +
                ", age=" + age +
                '}';
    }
}
