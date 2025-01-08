package III.fileworks.serials;

import java.io.*;

public class MultipleSerial {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Coordinates c1 = new Coordinates(1,2,3);
        Coordinates c2 = new Coordinates(123,2165,354);
        Coordinates c3 = new Coordinates(541,4224,2540);

        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("multiple_coords.ser"));
        oos.writeObject(c1);
        oos.writeObject(c2);
        oos.writeObject(c3);
        oos.close();

        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("multiple_coords.ser"));
        Coordinates d1 = (Coordinates) ois.readObject();
        Coordinates d2 = (Coordinates) ois.readObject();
        Coordinates d3 = (Coordinates) ois.readObject();
        ois.close();

        System.out.println(d1);
        System.out.println(d2);
        System.out.println(d3);
    }
}
