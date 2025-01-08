package III.fileworks.serials;

import java.io.*;

public class SerialExportImport {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        //serialization
        Coordinates coords = new Coordinates(5,6,20);
        System.out.println("I am exporting... " + coords);

        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("single_coord.ser"));
        oos.writeObject(coords);
        oos.close();

        //deserialization
        Coordinates deserialized = null;
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("single_coord.ser"));
        deserialized = (Coordinates) ois.readObject();

        System.out.println("I am importing... " + deserialized);

    }
}
