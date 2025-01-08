package III.fileworks.serials;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CollectionSerialize {


    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ArrayList<Coordinates> coordinates = new ArrayList<>();
        Random r = new Random();
        //plneni listu "coordinates" s random hodnotami
        for (int i = 0; i < 100; i++) {
            coordinates.add(new Coordinates(r.nextInt(),r.nextInt(),r.nextInt()));
        }
        System.out.println(coordinates);

        //vytvoreni output streamu a pridani listu "coordinates"
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("listed_multiple_coords.ser"));
        oos.writeObject(coordinates);
        oos.close();

        //vytvoreni listu v importove casti, aby bylo kam importovat list
        List<Coordinates> deserializedCoordinates = null;
        //import predchoziho outputu, assignuti outputu do predpripraveneho listu
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("listed_multiple_coords.ser"));
        deserializedCoordinates = (List<Coordinates>) ois.readObject();
        ois.close();
        //DEBUG
        //vypis hodnot + zkouska
        System.out.println(deserializedCoordinates);
        System.out.println(deserializedCoordinates.size() == coordinates.size());
    }

}
