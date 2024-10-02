package III.inheritance.medicationExample;

public class CardiacSurgeon extends Surgeon{
    int CARDIAC_SURGEON_BONUS = 35000;

    public CardiacSurgeon(int salary, String name) {
        super(salary, name);
        this.salary += CARDIAC_SURGEON_BONUS;
    }

    void cardiacSurgery(){
        System.out.println("Cut through the heart and I'm to blame ...");
        salary += 15000;
    }
}
