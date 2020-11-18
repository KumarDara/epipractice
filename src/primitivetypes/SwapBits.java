package primitivetypes;

public class SwapBits {
    public static void main(String[] args) {
        System.out.println(swapBits(10, 1, 2));
    }

    public static int swapBits(int x, int i, int j) {
        //swap only if ith and jth bits differ in the given number
        if(((x >>> i) & 1) != ((x >>> j) & 1)) {
            //setting the ith and jth positions to 1
            int bitMask = (1 << i) | (1 << j);
            //select the bits to flip with bitmask.
            //x ^ 1 = 0 when x is 1
            //x ^ 1 = 1 when x is 0
            x ^= bitMask;
        }
        return  x;
    }
}
