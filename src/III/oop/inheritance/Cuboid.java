package III.oop.inheritance;

public class Cuboid extends Rectangle{
    double depth;
    public Cuboid(double width, double height, double depth) {
        super(width, height);
        this.depth = depth;
    }

    double getVolume(){
        return super.getArea() * depth;
    }

    public double getArea() {
        return 2* ((height * width) + (height * depth) + (width * depth));
    }

    public static void main(String[] args) {
        Rectangle r = new Rectangle(5,6);
        System.out.println(r.getArea());

        Cuboid c = new Cuboid(5,6,3);
        System.out.println(c.getArea());

        Rectangle weird = new Cuboid(4,1,3);

        if (weird instanceof Cuboid){
//            pretypovani, weirdCuboid je ted kvadr
            Cuboid weirdCuboid = (Cuboid) weird;
//            rovnou pouzivam veci kvadru
            ((Cuboid)weird).getArea();
        }

//        nefunguje
//        Cuboid another = new Rectangle(4,5)

    }

}
