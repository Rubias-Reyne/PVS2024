package III.material;

import fileworks.DataExport;
import fileworks.DataImport;

import java.util.LinkedList;
import java.util.Queue;

public class QueuePractice {
    public static void main(String[] args) {
        Queue<String> doctors = new LinkedList<>();
        Queue<String> patients = new LinkedList<>();
        DataImport di = new DataImport("txt"/*"hospital.txt"*/);
        while (di.hasNext()){
            String line = di.readLine();
            String[] params = line.split(";");
            if (params[1].equals("D")){
                doctors.add(params[0]);
            }else {
                patients.add(params[0]);
            }
        }
//        System.out.println(doctors);
//        System.out.println(patients);
        //nacteni jmen ze souboru a rozdeleni na doktory a pacienty
        di.finishImport();
        DataExport de = new DataExport("finalHospital.txt");
        while (!patients.isEmpty()){ //dokud jsou jeste nejaky pacienti
            String patient = patients.poll(); //vybere prvniho pacienta
            String doctor = doctors.poll(); //vybere prvnigo doktora
            if (doctor!=null){
                de.writeLine(patient + " byl obsloužen " + doctor);
                doctors.add(doctor); //vrati doktor zpět do fronty
                patients.remove(patient); //odstrani pacienta z fronty
                System.out.println("Zbylo " + patients.size() + " pacientů ve frontě");
            }
        }

        de.finishExport();
    }
}
