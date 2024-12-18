package III.fileworks;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class BloodBank {
    void testDonations(int times){
        for (int i = 0; i < times; i++) {
            // TODO: 18.12.2024 Nahodna dvojce se pokusi daroovat
        }
    }

    static BloodType parseBlood (String bloodType){
        switch (bloodType){
            case "A+": return BloodType.A_POSITIVE;
            case "A-": return BloodType.A_NEGATIVE;
            case "B+": return BloodType.B_POSITIVE;
            case "B-": return BloodType.B_NEGATIVE;
            case "AB+": return BloodType.AB_POSITIVE;
            case "AB-": return BloodType.AB_NEGATIVE;
            case "0+": return BloodType.O_POSITIVE;
            case "0-": return BloodType.O_NEGATIVE;
            default: return BloodType.AB_POSITIVE;
        }
    }
//    static ArrayList<BloodDonor> getDonors(String filePath) throws IOException{
//        ArrayList<BloodDonor> donors = new ArrayList<>();
//        List<String> lines = Files.readAllLines(Paths.get(filePath));
//        lines.remove(1); //prvni radek jsou nazvy skoupcu
//        String[] params;
//        BloodDonor donor;
//        for (String line: lines){
//            params = line.split(",");
//            donor = new BloodDonor(
//                     params[0],
//                     Integer.parseInt(params[1]),
//                     params[2],
//                     parseBlood(params[3]));
//            donors.add(donor);
//        }
//        return donors;
//    }
    public static void main(String[] args) throws IOException {
//        ArrayList<BloodDonor> donors = getDonors("C:\\Users\\vladimir.topolcany\\IdeaProjects\\PRG\\blood.csv");
//        for (BloodDonor donor : donors){
//            System.out.println(donor);
//        }

        BloodDonor bd1 = new BloodDonor("Pepa", 21, "Mexico", BloodType.AB_NEGATIVE);
        BloodDonor bd2 = new BloodDonor("Ronin", 28, "eee?", BloodType.O_POSITIVE);
        System.out.println(bd1.donate(bd1, bd2));
    }
}
class BloodDonor{
    String name;
    int age;
    String state;
    BloodType bloodType;

    public BloodDonor(String name, int age, String state, BloodType bloodType) {
        this.name = name;
        this.age = age;
        this.state = state;
        this.bloodType = bloodType;
    }

    @Override
    public String toString() {
        return "BloodDonor{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", state='" + state + '\'' +
                ", bloodType=" + bloodType +
                '}';
    }

    boolean donate(BloodDonor from, BloodDonor to){
        if (BloodType.BLOOD_COMPABILITY[from.bloodType.position][to.bloodType.position] == 1){
            return true;
        }else{
            return false;
        }
    }
} enum BloodType{
    O_POSITIVE(0),
    O_NEGATIVE(1),
    A_POSITIVE(2),
    A_NEGATIVE(3),
    B_POSITIVE(4),
    B_NEGATIVE(5),
    AB_POSITIVE(6),
    AB_NEGATIVE(7);

    public int position;
    BloodType(int position){

    }
    public static final byte[][] BLOOD_COMPABILITY = {

            {1,1,1,1,1,1,1,1},
            {1,0,1,0,1,0,1,0},
            {1,1,0,0,1,1,0,0},
            {1,0,0,0,1,0,0,0},
            {1,1,1,1,0,0,0,0},
            {1,0,1,0,0,0,0,0},
            {1,1,0,0,0,0,0,0},
            {1,0,0,0,0,0,0,0}
    };
}
