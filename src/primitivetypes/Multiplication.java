package primitivetypes;

public class Multiplication {
    public static int multiply(int x, int y) {
        int res = 0;
        while(x != 0) {
            //in case last bit set
            if ((x & 1) == 1) {
               res = sum(res, y);
            }
            x >>>=1;
            y <<= 1;
        }
        return res;
    }

    private static int add(int x, int y) {
        int res = 0;
        int carrying = 0;
        int tempX = x;
        int tempY = y;
        int k = 1;
        while (tempX != 0 || tempY != 0) {
            int xk = x & k;
            int yk = y & k;
            int carryout = (xk & yk) | (xk & carrying) | (yk & carrying);
            res |= (xk ^ yk ^ carrying);
            carrying = carryout << 1;
            k <<= 1;
            tempX >>>= 1;
            tempY >>>= 1;
        }
        return res | carrying;
    }

    private static int sum(int x, int y) {
        // Iterate till there is no carry
        while (y != 0)
        {
            // carry now contains common
            // set bits of x and y
            int carry = x & y;

            // Sum of bits of x and
            // y where at least one
            // of the bits is not set
            x = x ^ y;

            // Carry is shifted by
            // one so that adding it
            // to x gives the required sum
            y = carry << 1;
        }
        return x;
    }
    public static void main(String[] args) {
        System.out.println(multiply(5,6));
    }
}
