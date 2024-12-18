package III.basics;

public class Enums {

    public static void main(String[] args) {
        User basicUser = new User("Karel", 15, ACCESS.BASE_USER);
        SpecificLocation SpecificLocation = new SpecificLocation(5.1, 5, Geo.NORTH);
    }
}
class SpecificLocation{
    double x,y;
    Geo region;

    public SpecificLocation(double x, double y, Geo region) {
        this.x = x;
        this.y = y;
        this.region = region;
    }
}
enum Geo{
    NORTH,
    SOUTH,
    EAST,
    WEST
}

enum ACCESS{
    BASE_USER(3),
    SUPERVISOR(2),
    ADMIN(1);

    ACCESS(int i) {
    }
}
class User {
    String name;
    int id;
    ACCESS access;

    public User(String name, int id, ACCESS access) {
        this.name = name;
        this.id = id;
        this.access = access;
    }

    void grantAccess(User user, ACCESS ac){
        if (user.access == ACCESS.SUPERVISOR){
            System.out.println("Pristup povolen");
        }
        System.out.println("Pristup odepren");
    }
}