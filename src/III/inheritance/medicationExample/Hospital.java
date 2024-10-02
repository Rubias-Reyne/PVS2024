package III.inheritance.medicationExample;

import fileworks.DataExport;
import fileworks.DataImport;

import javax.print.Doc;

@SuppressWarnings("ALL")
public class Hospital {


    public static void main(String[] args) {
        DataImport di = new DataImport("procedures.txt");
        DataExport de = new DataExport("report.txt");
        String line;
        String[] params;
        int highestSalary = 0;
        String highestSalaryName = "";
        int lowestSalary = 0;
        String lowestSalaryName = "";
        Doctor d = new Doctor(0,"");

        while(di.hasNext()){
            line = di.readLine();
            params = line.split(",");
            switch(params[1]){
                case "DOC":
                    d = new Doctor(0, params[0]);
                    break;
                case "SUR":
                    d = new Surgeon(0,params[0]);
                    break;
                case "CAR":
                    d = new CardiacSurgeon(0,params[0]);
                    break;
            }
            for (int i = 2; i < params.length; i++) {
                switch (params[i]){
                    case "D":
                        d.diagnose();
                        break;
                    case "S":
                        if (d instanceof Surgeon || d instanceof CardiacSurgeon){
                            ((Surgeon)d).surgery();
                        }else {
                            d.salary -= 50000;
                        }
                        break;
                    case "C":
                        if (d instanceof CardiacSurgeon){
                            ((CardiacSurgeon)d).cardiacSurgery();
                        }else {
                            d.salary -= 50000;
                        }
                        break;
                }
            }
            if (d.salary > highestSalary){
                highestSalary = d.salary;
                highestSalaryName = d.name;
            }
            if (d.salary < lowestSalary){
                lowestSalary = d.salary;
                lowestSalaryName = d.name;
            }

            de.writeLine(d.toString());
        }
        System.out.println(highestSalaryName + " has the highest salary of " + highestSalary);
        System.out.println(lowestSalaryName + " has the lowest salary of " + lowestSalary);

        di.finishImport();
        de.finishExport();
    }

}
