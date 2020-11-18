package primitivetypes;

public class ReverseBits {
    public static void main(String[] args) {
        System.out.println(reverseBits(10));
    }
    public static int usingSwapBits(int n) {
        n = SwapBits.swapBits(n, 0, 31);
        n = SwapBits.swapBits(n, 1, 30);
        n = SwapBits.swapBits(n, 2, 29);
        n = SwapBits.swapBits(n, 3, 28);
        n = SwapBits.swapBits(n, 4, 27);
        n = SwapBits.swapBits(n, 5, 26);
        n = SwapBits.swapBits(n, 6, 25);
        n = SwapBits.swapBits(n, 7, 24);
        n = SwapBits.swapBits(n, 8, 23);
        n = SwapBits.swapBits(n, 9, 22);
        n = SwapBits.swapBits(n, 10, 21);
        n = SwapBits.swapBits(n, 11, 20);
        n = SwapBits.swapBits(n, 12, 19);
        n = SwapBits.swapBits(n, 13, 18);
        n = SwapBits.swapBits(n, 14, 17);
        n = SwapBits.swapBits(n, 15, 16);
        return  n;
    }

    public static int reverseBits(int n) {
        int ans = 0;
        for (int i = 0; i < 32; i++) {
            //pushing the processed bits to left
            ans <<= 1;
            //extracting the last bit of n
            ans = ans | (n & 1);
            //removing the last bit of n
            n >>= 1;
        }
        return ans;
    }

    public static int maskAndShift(int n) {
        n = (n >> 16) | (n << 16);
        n = ((n & 0xff00ff00) >> 8) | ((n & 0x00ff00ff) << 8);
        n = ((n & 0xf0f0f0f0) >> 4) | ((n & 0x0f0f0f0f) << 4);
        n = ((n & 0xcccccccc) >> 2) | ((n & 0x33333333) << 2);
        n = ((n & 0xaaaaaaaa) >> 1) | ((n & 0x55555555) << 1);
        return n;
    }
}
