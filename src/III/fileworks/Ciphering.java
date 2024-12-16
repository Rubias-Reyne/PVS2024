package III.fileworks;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Array;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
public class Ciphering {


    public static void main(String[] args) throws IOException {
        Caesar cipher = new Caesar(3, "Caesar cipher");
        List<String> lines = Files.readAllLines(Paths.get("C:\\Users\\vladimir.topolcany\\IdeaProjects\\PRG\\textFiles\\cipher.txt"));

        System.out.println("Original");
        System.out.println(lines);
        //pro ucely debugu, ulozit cely soubor do promenne
        ArrayList<String> encryptedLines = new ArrayList<>();
        for (String line : lines){
            encryptedLines.add(cipher.encrypt(line));
        }

        System.out.println("Encrypted:");
        System.out.println(encryptedLines);

        //nahazet do souboru:
        PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter("encryptedTest.txt")));
        for (String line : encryptedLines){
            writer.println(line);
        }
        writer.close();

        lines = Files.readAllLines(Paths.get("encryptedTest.txt"));
        System.out.println("Decrypted");
        for (String line : lines){
            System.out.println(cipher.decrypt(line));
        }

    }
}
abstract class Cipher{
    int key;
    String name;

    public Cipher(int key, String name) {
        this.key = key;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Cipher name:" + name + " secret: " + key;
    }

    abstract String encrypt(String input);

    abstract String decrypt(String encryptedInput);

}
class Caesar extends Cipher{

    public Caesar(int key, String name) {
        super(key, name);
    }

    @Override
    String encrypt(String input) {
//        char[] pole = input.toLowerCase().toCharArray();
//        System.out.println(pole);
//        char[] LowerCaseAlphabet = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z','a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
//        String out = "";
//        for (int i = 0; i < pole.length; i++) {
//            out += LowerCaseAlphabet[i+key];
//
//        }
//        return out;
        return null;
    }

    @Override
    String decrypt(String encryptedInput) {

        return null;
    }
}