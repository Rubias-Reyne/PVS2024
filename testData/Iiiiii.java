public class Iiiiii {
    public static void main(String[] args) {
        int i1 = 3;
        int i2 = 4;
        int i3 = 5;
        int[] ii = {i1, i2, i3};
        i1 = i2;
        i1++;
        i2+=3;
        ii[1] = 8;

        for (int i = 0; i < ii.length; i++) {
            System.out.println(ii[i]);
        }
    }
}
