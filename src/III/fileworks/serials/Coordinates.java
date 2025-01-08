
package III.fileworks.serials;

import java.io.*;

public class Coordinates implements Serializable {
    private final int x,y,z;
    @Serial
    private static final long serialVersionUID = 42L;

    public Coordinates(int x, int y, int z) throws IOException {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    @Override
    public String toString() {
        return "[" + "x=" + x + ", y=" + y + ", z=" + z + ']';
    }


}
