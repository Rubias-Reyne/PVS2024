package III.inheritance.medicationExample;

@SuppressWarnings("ALL")
public class Hospital {

    public static void main(String[] args) {
        Doctor carl = new Doctor(50000,"Carl");
        System.out.println(carl.name + ": " + carl.getSalary());
        carl.diagnose();
        carl.diagnose();
        System.out.println(carl.name + ": " + carl.getSalary());
        Surgeon joseph = new Surgeon(50000,"Joseph");
        System.out.println(joseph.name + ": " + joseph.getSalary());
        joseph.surgery();
        joseph.diagnose();
        System.out.println(joseph.name + ": " + joseph.getSalary());

        CardiacSurgeon frenchie = new CardiacSurgeon(50000, "Frenchie");
        System.out.println(frenchie.name + ": " + frenchie.getSalary());
        frenchie.cardiacSurgery();

        System.out.println(frenchie.name + ": " + frenchie.getSalary());


        Doctor jarmil = new Surgeon(50000,"Jarmil");
        System.out.println(jarmil.getSalary());

/*
        // variant 1
        Surgeon temp = (Surgeon)jarmil;

        // variant 2
        ((Surgeon)jarmil).surgery();
*/
        Doctor[] doctors = {carl, joseph, frenchie, jarmil};
        //vsichni zkusi operaci:

        for(Doctor doctor: doctors){
            //pokus se o operaci
            System.out.println(doctor.name + " attempting surgery...");
            if (doctor instanceof Surgeon){
                ((Surgeon)doctor).surgery();
            }else {
                System.out.println(doctor.name + " is not qualified for surgeries");
            }
        }
    }
}
