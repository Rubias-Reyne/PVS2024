package III;

import fileworks.DataExport;
import fileworks.DataImport;

public class fileBasics {
    public static void main(String[] args) {
        DataImport di = new DataImport("inputs.txt");
        DataExport de = new DataExport("output.txt");
//        di.printFile();
        String line;
        String[] params;
        int a, b;
        while (di.hasNext()){
            line = di.readLine();
//            System.out.println(line);
            params = line.split(",");
            a = Integer.parseInt(params[0]);
            b = Integer.parseInt(params[1]);
            switch (params[2]){
                case "A":
                    de.writeLine(String.valueOf(a+b)); break;
                case "S":
                    de.writeLine(String.valueOf(a-b)); break;
                case "M":
                    de.writeLine(String.valueOf(a*b)); break;
                case "D":
                    de.writeLine(String.valueOf(a/b)); break;
            }

        }
        di.finishImport();
        de.finishExport();

    }
}
