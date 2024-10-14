package III.inheritance.medicationExample;

public class Doctor {
    int salary;
    String name;

    public Doctor(int salary, String name) {
        this.salary = salary;
        this.name = name;
    }

    void diagnose(){
        System.out.println("Figuring out what's wrong ...");
        salary += 1000;
    }

    public int getSalary(){
        return salary;
    }

    @Override
    public String toString() {
        return name + ": " + salary;
    }


}
