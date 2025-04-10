package III.map;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PharmacyBills {

    static class Pills{
        String name;
        int pieces;
        String pharmacy;
        int month;
        boolean Insurance_Paid;

        public Pills(String name, int pieces, String pharmacy, int month, boolean insurance_Paid) {
            this.name = name;
            this.pieces = pieces;
            this.pharmacy = pharmacy;
            this.month = month;
            Insurance_Paid = insurance_Paid;
        }

        public String getName() {
            return name;
        }

        public int getPieces() {
            return pieces;
        }

        public String getPharmacy() {
            return pharmacy;
        }

        public int getMonth() {
            return month;
        }

        public boolean isInsurance_Paid() {
            return Insurance_Paid;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setPieces(int pieces) {
            this.pieces = pieces;
        }

        public void setPharmacy(String pharmacy) {
            this.pharmacy = pharmacy;
        }

        public void setMonth(int month) {
            this.month = month;
        }

        public void setInsurance_Paid(boolean insurance_Paid) {
            Insurance_Paid = insurance_Paid;
        }
    }
    static int soldIn(List<Pills> sales, int from, int to){
        int count = 0;
        if (from > to){
            return 0;
        }
        for(Pills sale:sales){
            if (sale.getMonth() >= from && sale.getMonth() <= to){
                count += sale.getPieces();
            }
        }
        System.out.println("From " + from + ", To " + to + ", sales: " + count);
        return count;
    }


    public static void main(String[] args) throws IOException {
        List<Pills> pillsList = Files.lines(Paths.get("meds_sales.csv"))
                .skip(1)
                .map(line -> line.split(","))
                .map(splitLine -> new Pills(
                        splitLine[0],
                        Integer.parseInt(splitLine[1]),
                        splitLine[2],
                        Integer.parseInt(splitLine[3]),
                        Boolean.parseBoolean(splitLine[4])
                )).toList();

        System.out.println("Loaded: " + pillsList.size());
        List<String> uniqueStudents = pillsList.stream()
                .map(s -> s.getName())
                .distinct()
                .toList();
        System.out.println("Unique pills: " + uniqueStudents);

        Map<String, Long> amountPerPharmacyInsurancePaid = pillsList.stream()
                .collect(Collectors.groupingBy(Pills::getPharmacy, Collectors.counting()));

//        Map<String, Long> pillsSales = pillsList.stream()
//                        .collect(Collectors.groupingBy(Pills::getName,i -> {
//                            int count += i;
//                            return count;
//                        }));

//        Map<String, Integer> soldPerQ = pillsList.stream()
//                .map(Pills::getPieces)
//                .distinct()
//                .collect(Collectors.groupingBy(month -> {
//                    if (month.getMonth() <= 3) return "Q1";
//                    if (month.getMonth() <= 6) return "Q2";
//                    if (month.getMonth() <= 9) return "Q3";
//                    if (month.getMonth() <= 12) return "Q4";
//                    return "error";
//                }, Collectors.groupingBy()));

        System.out.println(amountPerPharmacyInsurancePaid);
//        System.out.println(pillsSales);
        soldIn(pillsList, 6, 9);


    }

}
